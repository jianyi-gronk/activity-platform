import * as tf from '@tensorflow/tfjs';

class LSH {
  dimensions: number;
  w: number;
  r: tf.Tensor1D;
  b: number;
  buckets: {[key: number]: number[][]};

  constructor(dimensions: number, w: number) {
    this.dimensions = dimensions;
    this.w = w;
    this.r = tf.randomNormal([dimensions]);
    this.b = w * Math.random();
    this.buckets = {};
  }

  hash(point: number[]): number {
    let value = tf.tidy(() => {
      let dotProduct = tf.dot(this.r, tf.tensor1d(point));
      return dotProduct.dataSync()[0];
    });
    return Math.floor((value + this.b) / this.w);
  }

  insert(point: number[]): void {
    let key = this.hash(point);
    if (this.buckets[key] === undefined) {
      this.buckets[key] = [];
    }
    this.buckets[key].push(point);
  }

  query(point: number[], numNeighbors: number): number[][] {
    let key = this.hash(point);
    let candidates = this.buckets[key];
    if (candidates.length <= numNeighbors) {
      return candidates;
    }
    let distances = candidates.map(candidate => {
      let diff = tf.tidy(() => {
        let diff = tf.sub(tf.tensor1d(candidate), tf.tensor1d(point));
        return tf.norm(diff).dataSync()[0];
      });
      return diff;
    });
    return candidates.sort((a, b) => a[0] - b[0]).slice(0, numNeighbors);
  }

  update(oldPoint: number[], newPoint: number[]): void {
    let oldKey = this.hash(oldPoint);
    this.buckets[oldKey] = this.buckets[oldKey].filter(point => point !== oldPoint);
    this.insert(newPoint);
  }
}

let lsh = new LSH(2, 10);
lsh.insert([1, 2]);
lsh.insert([2, 3]);
lsh.insert([10, 20]);
console.log(lsh.query([1, 2], 100));