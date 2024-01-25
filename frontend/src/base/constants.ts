import { ref } from "vue";

export const PRIMARY_COLOR_DEFAULT = "#17b392";

export const LOCAL_STORAGE_THEME = "LOCAL_STORAGE_THEME";

export const PRIMARY_COLOR = ref(
  localStorage.getItem(LOCAL_STORAGE_THEME) || PRIMARY_COLOR_DEFAULT
);
