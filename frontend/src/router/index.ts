import { createRouter, createWebHistory } from "vue-router";
import type { RouteRecordRaw } from "vue-router";

const routes: Readonly<RouteRecordRaw[]> = [
  {
    path: "/",
    name: "Root",
    redirect: "home",
    component: () => import("../layout/index.vue"),
    children: [
      {
        path: "/home",
        name: "home",
        component: () => import("../views/home/index.vue")
      },
      {
        path: "/all",
        name: "all",
        component: () => import("../views/all/index.vue")
      }
    ]
  }
];

const options = {
  history: createWebHistory("/admin"),
  routes
};
const router = createRouter(options);

export default router;
