import { createApp } from "vue";
import "./style.css";
import "ant-design-vue/dist/reset.css";
import App from "./App.vue";
import Vue3ColorPicker from "vue3-colorpicker";
import router from "./router";

import Antd from "ant-design-vue";

createApp(App).use(Antd).use(router).use(Vue3ColorPicker).mount("#app");
