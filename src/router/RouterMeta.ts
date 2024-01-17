import type { RouteMeta } from "vue-router";
import type { RouteRecordType } from "@/router/defaultRoutes";

export interface RouterMeta extends RouteMeta {
  icon?: string;
  hidden?: boolean;
  skip?: boolean;
  tab_parent?: boolean;
  tab?: boolean;
  _router_key?: string;
  parent?: RouteRecordType;
}
