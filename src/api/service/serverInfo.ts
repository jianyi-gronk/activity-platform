import request from "@/base/http/request";

export const getMetricsMetadata = (params: any): Promise<any> => {
  return request({
    url: "/metrics/metadata",
    method: "get",
    params
  });
};
