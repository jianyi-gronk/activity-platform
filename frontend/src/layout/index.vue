<template>
  <div class="__container_layout_index">
    <a-layout class="container">
      <layout-header />
      <a-layout-content class="content">
        <router-view></router-view>
      </a-layout-content>
      <a-layout-footer>todo</a-layout-footer>
    </a-layout>
  </div>
</template>

<script setup lang="ts">
import LayoutHeader from './LayoutHeader.vue';
import { RouterView } from 'vue-router';
</script>

<style scoped lang="less">
.__container_layout_index {
  .container {
    height: 100vh;
    width: 100vw;
    .content {
      width: 1200px;
      margin: auto;
      overflow-y: scroll;
    }
  }
}
</style>
