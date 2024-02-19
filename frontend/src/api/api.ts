import request from "./request";

export const login = (params: any): Promise<any> => {
  return request.get("/user/login", { params });
};

export const register = (params: any): Promise<any> => {
  return request.post("/user/register", params);
};

export const getUserInformation = (params: any): Promise<any> => {
  return request.get("/user/information", { params });
};

export const updateUserInformation = (params: any): Promise<any> => {
  return request.post("/user/information", params);
};

export const deleteUserInformation = (params: any): Promise<any> => {
  return request.delete("/user/information", { params });
};

export const verifyUser = (params: any): Promise<any> => {
  return request.get("/user/verify", { params });
};
