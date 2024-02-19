import * as tf from "@tensorflow/tfjs";

// 实现局部敏感哈希 LSH
export class LSH {
  dimensions: number; // 特征向量的维度
  w: number; // 桶的宽度
  r: tf.Tensor1D; // 随机投影向量
  b: number; // 偏置项
  buckets: { [key: number]: number[][] }; // 存储哈希桶的字典

  constructor(dimensions: number, w: number) {
    this.dimensions = dimensions;
    this.w = w;
    this.r = tf.randomNormal([dimensions]); // 生成随机投影向量
    this.b = w * Math.random(); // 生成偏置项
    this.buckets = {}; // 初始化哈希桶字典
  }

  // 将特征向量 point 哈希到桶中
  hash(point: number[]): number {
    let value = tf.tidy(() => {
      let dotProduct = tf.dot(this.r, tf.tensor1d(point)); // 计算随机投影向量和特征向量的点积
      return dotProduct.dataSync()[0]; // 将点积转换为普通的 JavaScript 数组，取第一个元素作为哈希值
    });
    return Math.floor((value + this.b) / this.w); // 计算哈希值，返回桶的索引
  }

  // 将特征向量 point 插入哈希桶中
  insert(point: number[]): void {
    let key = this.hash(point); // 计算哈希值，获取桶的索引
    if (this.buckets[key] === undefined) {
      // 如果桶不存在，则初始化为空数组
      this.buckets[key] = [];
    }
    this.buckets[key].push(point); // 将特征向量 point 插入桶中
  }

  // 查询与特征向量 point 距离最近的 numNeighbors 个点
  query(point: number[], numNeighbors: number): number[][] {
    let key = this.hash(point); // 计算哈希值，获取桶的索引
    let candidates = this.buckets[key]; // 获取桶中所有候选点
    if (candidates.length <= numNeighbors) {
      // 如果候选点数不超过 numNeighbors，则直接返回
      return candidates;
    }
    let distances = candidates.map((candidate) => {
      // 计算每个候选点到 point 的距离
      let diff = tf.tidy(() => {
        let diff = tf.sub(tf.tensor1d(candidate), tf.tensor1d(point)); // 计算差向量
        return tf.norm(diff).dataSync()[0]; // 计算 L2 范数，取第一个元素作为距离
      });
      return diff;
    });
    return candidates.sort((a, b) => a[0] - b[0]).slice(0, numNeighbors); // 按距离排序，取前 numNeighbors 个点
  }

  // 将旧特征向量 oldPoint 替换为新特征向量 newPoint
  update(oldPoint: number[], newPoint: number[]): void {
    let oldKey = this.hash(oldPoint); // 计算旧特征向量的哈希值，获取其所在的桶
    this.buckets[oldKey] = this.buckets[oldKey].filter(
      (point) => point !== oldPoint // 将旧特征向量从桶中删除
    );
    this.insert(newPoint); // 将新特征向量插入桶中
  }
}

let lsh = new LSH(2, 10);
lsh.insert([1, 2]);
lsh.insert([2, 3]);
lsh.insert([10, 20]);
console.log(lsh.query([1, 2], 100)); // 查询与 [1, 2] 距离最近的 100 个点
