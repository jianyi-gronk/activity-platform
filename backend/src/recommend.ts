import * as tf from '@tensorflow/tfjs';

// 用户数据
let userData = tf.tensor2d([

]);

// 新用户的数据
let newUserData = tf.tensor1d([/* 新用户的数据... */]);

// 计算新用户与所有用户的欧几里得距离
let distances = tf.sqrt(tf.sum(tf.squaredDifference(userData, newUserData), axis=1));

// 获取最相似的前100个用户的索引
let topKIndices = tf.topk(distances, 100, true).indices;

// 输出最相似的用户
topKIndices.print();