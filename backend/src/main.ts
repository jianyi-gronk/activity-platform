import express from "express";
import cors from "cors";
import bodyParser from "body-parser";
import {
  login,
  register,
  getUserInfo,
  updateUserInfo,
  deleteUserInfo
} from "./sql/user";
import {
  addActivity,
  getActivityAll,
  getActivityByUser,
  deleteActivity,
  getActivityById
} from "./sql/activity";
import { generateToken, verifyToken } from "./until/jwt";

// 扩展 Express 的 Request 类型
declare global {
  namespace Express {
    interface Request {
      userId?: number;
    }
  }
}

const app = express();

// 使用 cors 避免跨域问题
app.use(cors());

// 使用 bodyParser 中间件解析请求体
app.use(bodyParser.json({ limit: "5mb" }));
app.use(bodyParser.urlencoded({ limit: "5mb", extended: true }));

app.get("/user/login", async function (req, res) {
  const data = await login(
    req.query.userName as string,
    req.query.password as string
  );
  if (data) {
    const token = generateToken(data.id, data.userName);
    res.send({
      result: {
        token,
        id: data.id
      }
    });
  } else {
    res.send({ result: false });
  }
});

app.post("/user/register", async function (req, res) {
  const data = await register(
    req.body.userName as string,
    req.body.password as string
  );
  res.send({ result: data });
});

app.get("/user/information", async function (req, res) {
  const data = await getUserInfo(req.query.userId as string);
  if (data) {
    res.send({ result: data });
  } else {
    res.send({ result: false });
  }
});

app.post("/user/information", verifyToken, async function (req, res) {
  const id = "" + req.body.id;
  const time = (req.body.time as string).slice(0, 19).replace("T", " ");
  const userName = req.body.userName as string;
  const password = req.body.password as string;
  const avatar = req.body.avatar as string;
  const name = req.body.name as string;
  const sex = req.body.sex as string;
  const phone = req.body.phone as string;
  const email = req.body.email as string;
  const description = req.body.description as string;
  if (req.userId && "" + req.userId === id) {
    const data = await updateUserInfo(
      id,
      time,
      userName,
      password,
      avatar,
      name,
      sex,
      phone,
      email,
      description
    );
    res.send({ result: data });
  } else {
    res.send({ result: false });
  }
});

app.delete("/user/information", verifyToken, async function (req, res) {
  if (req.userId && "" + req.userId === req.query.userId) {
    const data = await deleteUserInfo(req.query.userId);
    res.send({ result: data });
  } else {
    res.send({ result: false });
  }
});

app.get("/user/verify", verifyToken, async function (req, res) {
  if (req.userId && "" + req.userId === req.query.userId) {
    res.send({ result: true });
  } else {
    res.send({ result: false });
  }
});

app.post("/activity/item", verifyToken, async function (req, res) {
  const title = req.body.title as string;
  const description = req.body.description as string;
  const startTime = req.body.startTime as string;
  const endTime = req.body.endTime as string;
  const location = req.body.location as string;
  const upperLimit = req.body.limit as string;
  if (req.userId && "" + req.userId === req.body.userId) {
    const data = await addActivity(
      req.body.userId,
      title,
      description,
      startTime,
      endTime,
      location,
      upperLimit
    );
    res.send({ result: data });
  } else {
    res.send({ result: false });
  }
});

app.delete("/activity/item", verifyToken, async function (req, res) {
  const id = req.query.id as string;
  if (req.userId && "" + req.userId === req.query.userId) {
    const data = await deleteActivity(id, req.query.userId);
  }
  else {
    res.send({ result: false });
  }
});

app.get("/activity/user", verifyToken, async function (req, res) {
  if (req.userId && "" + req.userId === req.query.userId) {
    const data = await getActivityByUser(req.query.userId);
    res.send({ result: data });
  } else {
    res.send({ result: false });
  }
});

app.get("/activity/item", verifyToken, async function (req, res) {
  const data = await getActivityById(req.query.userId);
  if (data) {
    res.send({ result: data });
  }
  else {
    res.send({ result: false });
  }
});

app.get("/activity/all", async function (req, res) {
  const data = await getActivityAll();
  res.send({ result: data });
});

console.log("open");
app.listen(3000);
