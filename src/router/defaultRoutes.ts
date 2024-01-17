import type { RouterMeta } from "@/router/RouterMeta";
import type { RouteRecordRaw } from "vue-router";
import LayoutTab from "../layout/tab/layout_tab.vue";
import _ from "lodash";

export declare type RouteRecordType = RouteRecordRaw & {
  key?: string;
  name: string;
  children?: RouteRecordType[];
  meta?: RouterMeta;
};

export const routes: Readonly<RouteRecordType[]> = [];
