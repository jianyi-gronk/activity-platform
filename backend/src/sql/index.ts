import { Mysql } from "../until/mysql";
import { SQL_HOST, SQL_USER, SQL_PASSWORD, SQL_DATABASE } from "../static";

export const mysql = new Mysql({
  host: SQL_HOST,
  user: SQL_USER,
  password: SQL_PASSWORD,
  database: SQL_DATABASE
});
