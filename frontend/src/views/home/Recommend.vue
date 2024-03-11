<template>
  <div class="__container_home_recommend">
    <p class="title">推荐活动</p>
    <a-divider />
    <a-flex class="activity-container">
      <div class="activity-item" v-for="i in new Array(100)" :key="i" @click="showDetail = true"></div>
    </a-flex>
    <activity-detail v-model:showDetail=showDetail></activity-detail>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import ActivityDetail from '../common/ActivityDetail.vue'

const showDetail = ref(false);
</script>

<style scoped lang="less">
.__container_home_recommend {
  .title {
    font-size: 20px;
  }
  .activity-container {
    align-items: center;
    flex-wrap: wrap;
    .activity-item {
      width: 250px;
      height: 300px;
      background-color: pink;
      margin-bottom: 20px;
      margin-right: 25px;
      margin-left: 25px;
    }
  }
}
</style>