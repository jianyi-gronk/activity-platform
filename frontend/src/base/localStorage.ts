import { ref } from "vue";
import { LOCAL_STORAGE_KEY } from "./localStorageKey";

export const THEME_DEFAULT = "#17b392";
export const ISLOGIN_DEFAULT = "notSigned";

export const GET_THEME = ref(
  localStorage.getItem(LOCAL_STORAGE_KEY.THEME) || THEME_DEFAULT
);

export const GET_ISLOGIN = ref(
  localStorage.getItem(LOCAL_STORAGE_KEY.ISLOGIN) || ISLOGIN_DEFAULT
);

export function changeTheme(val: string) {
  localStorage.setItem(LOCAL_STORAGE_KEY.THEME, val);
  GET_THEME.value = val;
}

export function changeIsLogin() {
  const val = GET_ISLOGIN.value === "notSigned" ? "signed" : "notSigned";
  localStorage.setItem(LOCAL_STORAGE_KEY.ISLOGIN, val);
  GET_ISLOGIN.value = val;
}
