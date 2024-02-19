import mysql from "mysql";
import type { MysqlError } from "mysql";

export type MysqlOptions = {
  host: string;
  user: string;
  password: string;
  database: string;
};

// 实现连接 mysql
export class Mysql {
  private connection: mysql.Connection;

  constructor(options: MysqlOptions) {
    // 建立连接
    this.connection = mysql.createConnection(options);
    this.connection.connect();
  }

  // 对数据库进行增删改查
  operate(query: string, value?: string[]) {
    return new Promise((resolve, reject) => {
      this.connection.query(
        query,
        value ? value : [],
        (error: MysqlError | null, results: any[]) => {
          if (error) reject(error);
          resolve(results);
        }
      );
    });
  }

  // 关闭连接
  close() {
    this.connection.end();
  }
}
