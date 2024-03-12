<template>
  <a-tabs v-model:activeKey="activeKey">
    <a-tab-pane key="modify" tab="编辑">
      <Modify />
    </a-tab-pane>
    <a-tab-pane key="charts" tab="数据面板" force-render>
      <Charts />
    </a-tab-pane>
  </a-tabs>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import Modify from './modify.vue';
import Charts from './charts.vue';

const activeKey = ref('modify');
</script>

<style scoped lang="less">

</style>