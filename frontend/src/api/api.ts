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

export const addActivity = (params: any): Promise<any> => {
  return request.post("/activity/item", params);
};

export const getActivityByUserId = (params: any): Promise<any> => {
  return request.get("/activity/user", { params });
};

export const getActivityById = (params: any): Promise<any> => {
  return request.get("/activity/item", { params });
};

export const getActivityAll = (): Promise<any> => {
  return request.get("/activity/all");
};

export const deleteActivity = (params: any): Promise<any> => {
  return request.delete("/activity/item", { params });
};
