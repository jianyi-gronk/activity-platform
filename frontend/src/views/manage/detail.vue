<template>
  <a-tabs v-model:activeKey="activeKey">
    <a-tab-pane key="modify" tab="编辑">
      <modify />
    </a-tab-pane>
    <a-tab-pane key="charts" tab="数据面板" force-render>
      <charts />
    </a-tab-pane>
  </a-tabs>
</template>

<script setup lang="ts">
import { ref } from 'vue';

const activeKey = ref('modify');
</script>

<style scoped lang="less">

</style>