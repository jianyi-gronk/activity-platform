import { ref } from "vue";
import { LOCAL_STORAGE_KEY } from "./localStorageKey";

export const THEME_DEFAULT = "#17b392";
export const TOKEN_DEFAULT = "";
export const USERID_DEFAULT = "";

export const GET_THEME = ref(
  localStorage.getItem(LOCAL_STORAGE_KEY.THEME) || THEME_DEFAULT
);

export const GET_TOKEN = ref(
  localStorage.getItem(LOCAL_STORAGE_KEY.TOKEN) || TOKEN_DEFAULT
);

export const GET_USERID = ref(
  localStorage.getItem(LOCAL_STORAGE_KEY.USERID) || TOKEN_DEFAULT
);

export function changeTheme(val: string) {
  localStorage.setItem(LOCAL_STORAGE_KEY.THEME, val);
  GET_THEME.value = val;
}

export function changeIsLogin(val: { token?: string; id?: string }) {
  const token = val.token || TOKEN_DEFAULT;
  const userId = val.id || USERID_DEFAULT;
  localStorage.setItem(LOCAL_STORAGE_KEY.TOKEN, token);
  localStorage.setItem(LOCAL_STORAGE_KEY.USERID, userId);
  GET_TOKEN.value = token;
  GET_USERID.value = userId;
}
