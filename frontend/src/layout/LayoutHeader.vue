<template>
  <div class="__container_layout_header">
    <a-flex class="header flex-center">
      <a-flex>
        <div class="tab-item" @click="() => router.push('/home')">首页</div>
        <div class="tab-item" @click="() => router.push('/all')">全部</div>
        <div class="tab-item" @click="() => router.push('/like')">喜欢</div>
      </a-flex>
      <a-flex >
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
import { useRouter } from 'vue-router';
import {
  LOCAL_STORAGE_THEME,
  PRIMARY_COLOR
} from '@/base/constants'

const router = useRouter();
function changeTheme(val: string) {
  localStorage.setItem(LOCAL_STORAGE_THEME, val)
  PRIMARY_COLOR.value = val
}
</script>

<style scoped lang="less">
.__container_layout_header {
  background: v-bind('PRIMARY_COLOR');
  .header {
    height: 50px;
    width: 100%;
    .tab-item {
      padding: 10px;
      font-size: 16px;
      color: white;
      margin-left: 20px;
      &:hover {
        cursor: pointer;
      }
    }
  }
  .flex-center {
    justify-content: space-between;
    align-items: center;
  }
}
</style>
