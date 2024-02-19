import jwt from "jsonwebtoken";
import { Request, Response, NextFunction } from "express";

export function generateToken(id: string, userName: string) {
  const token = jwt.sign({ id, userName }, "jwt-secret-key", {
    expiresIn: "24h"
  });
  return token;
}

export function verifyToken(req: Request, res: Response, next: NextFunction) {
  const token = req.headers.authorization as string;

  if (!token) {
    return res.status(401).json({ message: "Missing token" });
  }

  jwt.verify(token, "jwt-secret-key", (err: any, decoded: any) => {
    if (err) {
      return res.status(401).json({ message: "Invalid token" });
    }

    // 将解码后的数据存储在请求对象中，以便后续路由处理程序使用
    (req as any).userId = decoded.id;

    next();
  });
}
