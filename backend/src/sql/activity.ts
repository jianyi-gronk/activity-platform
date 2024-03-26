import { mysql } from "./index";

// 创建活动
export async function addActivity(
  userId: string,
  title: string,
  description: string,
  startTime: string,
  endTime: string,
  location: string,
  upperLimit: string
) {
  startTime = new Date(startTime).toISOString().slice(0, 10).replace("T", " ");
  endTime = new Date(endTime).toISOString().slice(0, 10).replace("T", " ");
  const results: any = await mysql.operate(
    `INSERT INTO activity (user_id, title, description, start_time, end_time, location, upper_limit) VALUES (?, ?, ?, ?, ?, ?, ?);`,
    [userId, title, description, startTime, endTime, location, upperLimit]
  );
  return results.affectedRows == 1;
}

// 获取所有活动
export async function getActivityAll() {
  const results: any = await mysql.operate(`SELECT * FROM activity;`);
  return results;
}

// 获取个人创建的所有活动
export async function getActivityByUser(userId: string) {
  const results: any = await mysql.operate(
    `SELECT * FROM activity WHERE user_id = ?;`,
    [userId]
  );
  return results;
}

// 获取某个活动信息
export async function getActivityById(id: string) {
  const results: any = await mysql.operate(
    `SELECT * FROM activity WHERE id = ?;`,
    [id]
  );
  return results[0];
}

// 查看是否活动是否属于用户
export async function getActivityByIdAndUser(id: string, userId: string) {
  const results: any = await mysql.operate(
    `SELECT * FROM activity WHERE id = ? AND user_id = ?;`,
    [id, userId]
  );
  return results[0];
}

// 删除活动
export async function deleteActivity(id: string, userId: string) {
  // 检验是否已经存在该活动
  const result = await getActivityByIdAndUser(id, userId);
  if (result) {
    return false;
  }

  const data: any = await mysql.operate(`DELETE FROM activity WHERE id = ?`, [
    id
  ]);
  return data.affectedRows == 1;
}
