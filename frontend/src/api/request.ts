import type {
  AxiosInstance,
  AxiosInterceptorManager,
  AxiosRequestHeaders,
  AxiosResponse,
  InternalAxiosRequestConfig
} from "axios";
import axios from "axios";
import { message } from "ant-design-vue";
import NProgress from "nprogress";
import { LOCAL_STORAGE_KEY } from "@/base/localStorageKey";

const service: AxiosInstance = axios.create({
  baseURL: window.location.protocol + "//" + window.location.hostname + ":3000",
  timeout: 30 * 1000
});

const request: AxiosInterceptorManager<InternalAxiosRequestConfig> =
  service.interceptors.request;
const response: AxiosInterceptorManager<AxiosResponse> =
  service.interceptors.response;

request.use(
  (config) => {
    config.data = JSON.stringify(config.data); //数据转化,也可以使用 qs 转换
    const token = localStorage.getItem(LOCAL_STORAGE_KEY.TOKEN);
    config.headers = <AxiosRequestHeaders>{
      "Content-Type": "application/json",
      Authorization: token || ""
    };
    NProgress.start();
    return config;
  },
  (error) => {
    Promise.reject(error);
  }
);

response.use(
  (response) => {
    NProgress.done();

    if (response.status === 200) {
      return Promise.resolve(response.data);
    }
    return Promise.reject(response);
  },
  (error) => {
    NProgress.done();
    message.error(error.message);
    return Promise.resolve(error.response);
  }
);

export default service;
