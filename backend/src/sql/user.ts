import { Mysql } from "../until/mysql";
import { SQL_HOST, SQL_USER, SQL_PASSWORD, SQL_DATABASE } from "../static";

const mysql = new Mysql({
  host: SQL_HOST,
  user: SQL_USER,
  password: SQL_PASSWORD,
  database: SQL_DATABASE
});

// 登陆功能
export async function login(userName: string, password: string) {
  const results: any = await mysql.operate(
    `SELECT * FROM user WHERE userName = ? AND password = ?;`,
    [userName, password]
  );
  return results[0];
}

// 通过 id 查询用户是否存在
export async function hasUserById(id: string) {
  const results: any = await mysql.operate(`SELECT * FROM user WHERE id = ?;`, [
    id
  ]);
  return results[0];
}

// 通过用户名查询用户是否存在
export async function hasUserByName(userName: string) {
  const results: any = await mysql.operate(
    `SELECT * FROM user WHERE userName = ?;`,
    [userName]
  );
  return results[0];
}

// 注册功能
export async function register(userName: string, password: string) {
  // 检验是否已经存在该用户
  const result = await hasUserByName(userName);
  if (result) {
    return false;
  }

  // 注册用户
  const currentDate = new Date().toISOString().slice(0, 19).replace("T", " ");
  const data: any = await mysql.operate(
    `INSERT INTO user (time, userName, password) VALUES (?, ?, ?);`,
    [currentDate, userName, password]
  );
  return data.affectedRows == 1;
}

// 获取用户详细信息
export async function getUserInfo(id: string) {
  const results: any = await mysql.operate(`SELECT * FROM user WHERE id = ?;`, [
    id
  ]);
  return results[0];
}

// 更新用户信息
export async function updateUserInfo(
  id: string,
  time: string,
  userName: string,
  password: string,
  avatar: string,
  name: string,
  sex: string,
  phone: string,
  email: string,
  description: string
) {
  // 检验是否已经存在该用户
  const result = await hasUserById(id);
  if (!result) {
    return false;
  }

  // 更新用户
  const data: any = await mysql.operate(
    `UPDATE user
    SET time = ?,
      userName = ?,
      password = ?,
      avatar = ?,
      name = ?,
      sex = ?,
      phone = ?,
      email = ?,
      description = ?
    WHERE id = ?;`,
    [time, userName, password, avatar, name, sex, phone, email, description, id]
  );
  return data.affectedRows == 1;
}

export async function deleteUserInfo(id: string) {
  // 检验是否已经存在该用户
  const result = await hasUserById(id);
  if (!result) {
    return false;
  }

  // 删除用户
  const data: any = await mysql.operate(`DELETE FROM user WHERE id = ?;`, [id]);
  return data.affectedRows == 1;
}
