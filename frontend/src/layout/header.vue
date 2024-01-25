<template>
  <div class="__container_layout_header">
    <a-flex>
      <a-flex></a-flex>
      <a-flex>
        <color-picker
          :pureColor="PRIMARY_COLOR"
          @pureColorChange="changeTheme"
          format="hex6"
          shape="circle"
          useType="pure"
        ></color-picker>
      </a-flex>
    </a-flex>
  </div>
</template>

<script setup lang="ts">
import {
  LOCAL_STORAGE_THEME,
  PRIMARY_COLOR
} from '@/base/constants'

function changeTheme(val: string) {
  localStorage.setItem(LOCAL_STORAGE_THEME, val)
  PRIMARY_COLOR.value = val
}
</script>

<style scoped lang="less">
.__container_layout_header {
  height: 100px;
  width: 100%;
  background: v-bind('PRIMARY_COLOR');
  justify-content: space-between;
}
</style>
