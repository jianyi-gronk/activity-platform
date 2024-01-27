import { createApp } from "vue";

import App from "./App.vue";

import router from "./router";

import "./style.css";

import Antd from "ant-design-vue";
import "ant-design-vue/dist/reset.css";

import Vue3ColorPicker from "vue3-colorpicker";
import "vue3-colorpicker/style.css";

import "nprogress/nprogress.css";

createApp(App).use(Antd).use(router).use(Vue3ColorPicker).mount("#app");
