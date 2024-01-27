<template>
  <div class="__container_home_recommend">
    <p class="title">推荐活动</p>
    <a-divider />
    <a-flex class="activity-container">
      <div class="activity-item" v-for="i in new Array(100)" :key="i"></div>
    </a-flex>
  </div>
</template>

<script setup lang="ts">

</script>

<style scoped lang="less">
.__container_home_recommend {
  .title {
    font-size: 20px;
  }
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