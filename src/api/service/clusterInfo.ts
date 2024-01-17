import request from "@/base/http/request";

export const getClusterInfo = (params: any): Promise<any> => {
  return request({
    url: "/metrics/cluster",
    method: "get",
    params
  });
};
