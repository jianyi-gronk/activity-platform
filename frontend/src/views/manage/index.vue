<template>
  <div class="__container_manage_index">
    <a-flex class="activity-container">
      <div class="activity-item" v-for="i in new Array(100)" :key="i" @click="() => router.push('/manage/' + 123)"></div>
    </a-flex>
  </div>
</template>

<script setup lang="ts">
import { useRouter } from 'vue-router';

const router = useRouter();
</script>

<style scoped lang="less">
.__container_manage_index {
    .activity-container {
    align-items: center;
    justify-content: space-between;
    flex-wrap: wrap;
    .activity-item {
      width: 250px;
      height: 300px;
      background-color: pink;
      margin-bottom: 20px;
    }
  }
}
</style>