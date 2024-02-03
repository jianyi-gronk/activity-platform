import mysql from "mysql";
import type { MysqlError } from "mysql";
import { SQL_PASSWORD, SQL_DATABASE } from "./static";

export type SQLOptions = {
  host?: string;
  user?: string;
  password: string;
  database: string;
};

const defaultOptions = {
  host: SQL_PASSWORD,
  user: SQL_DATABASE
};

export class SQL {
  private connection: mysql.Connection;

  constructor(options: SQLOptions) {
    // 建立连接
    this.connection = mysql.createConnection(
      Object.assign(defaultOptions, options)
    );
    this.connection.connect();
  }

  // 对数据库进行增删改查
  operate(query: string, value?: string) {
    return new Promise((resolve, reject) => {
      this.connection.query(
        query,
        value,
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
