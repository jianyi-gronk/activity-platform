<template>
  <div class="__container_all_index">
    <a-flex vertical>
      <a-form class="filter">
        <a-form-item label="活动名">
          <a-input-search
            v-model:value="name"
            placeholder="请输入"
            @search="() => {}"
            class="filter-input"
          />
        </a-form-item>
        <a-form-item label="活动状态">
          <a-radio-group v-model:value="state">
            <a-radio value="all">全部</a-radio>
            <a-radio value="complete">已结束</a-radio>
            <a-radio value="progress">进行中</a-radio>
            <a-radio value="unstart">未开始</a-radio>
          </a-radio-group>
        </a-form-item>
        <a-form-item label="活动标签">
          <a-checkbox-group v-model:value="selectLabels">
            <a-checkbox class="filter-checkbox-item" v-for="item in allLabels" :value="item.value" :key="item.label">{{ item.label }}</a-checkbox>
          </a-checkbox-group>
        </a-form-item>
      </a-form>
      <a-flex class="activity-container">
        <div class="activity-item" v-for="i in new Array(100)" :key="i"></div>
      </a-flex>
    </a-flex>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';

const name = ref('');
const state = ref('all');

const selectLabels = ref([]);
const allLabels = ref([]);
for (let i = 0; i < 100; i++) {
  const value = `${i.toString(36)}${i}`;
  allLabels.value.push({
    label: value,
    value
  });
}

</script>

<style scoped lang="less">
.__container_all_index {
  .filter {
    margin-top: 20px;
    .filter-input {
      width: 500px;
    }
    .filter-checkbox-item {
      width: 100px;
      margin-right: 20px;
    }
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