<template>
  <div class="__container_home_recommend">
    <p class="title">推荐活动</p>
    <a-divider />
    <a-flex class="activity-container">
      <Activity class="activity-item" v-for="_, index in acitivitys" :key="index" @click="choice(index)" :data="acitivitys[index]"></Activity>
    </a-flex>
    <activity-detail v-model:showDetail=showDetail :activityData="activity"></activity-detail>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import ActivityDetail from '../common/ActivityDetail.vue'
import { getActivityAll } from '@/api/api'
import Activity from '../common/Activity.vue'

const showDetail = ref(false);

const acitivitys = ref([]);

const getActivity = async () => {
  const data = await getActivityAll();
  if(data.result) {
    acitivitys.value = data.result;
  }
}

const activity = ref({});

getActivity();

const choice = (i: number) => {
  showDetail.value = true;
  activity.value = acitivitys.value[i];
}
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
      margin-bottom: 20px;
      margin-right: 25px;
      margin-left: 25px;
    }
  }
}
</style>