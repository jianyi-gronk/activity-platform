<template>
  <div class="__container_all_index">
    <a-flex vertical>
      <a-form class="filter">
        <a-form-item>
          <a-checkbox v-model:checked="filterDate.like">只看我喜欢的</a-checkbox>
        </a-form-item>
        <a-form-item label="活动名">
          <a-input-search
            v-model:value="filterDate.name"
            placeholder="请输入"
            @search="() => {}"
            class="filter-input"
          />
        </a-form-item>
        <a-form-item label="活动状态">
          <a-radio-group v-model:value="filterDate.state">
            <a-radio value="all">全部</a-radio>
            <a-radio value="complete">已结束</a-radio>
            <a-radio value="progress">进行中</a-radio>
            <a-radio value="unstart">未开始</a-radio>
          </a-radio-group>
        </a-form-item>
        <a-form-item label="活动标签">
          <template v-for="label in filterDate.labels" :key="label">
            <a-tag @close="handleClose(label)">
              {{ label }}
            </a-tag>
          </template>
          <a-input
            v-if="inputVisible"
            ref="inputRef"
            v-model:value="inputLabel"
            type="text"
            size="small"
            :style="{ width: '78px' }"
            @blur="handleInputConfirm"
            @keyup.enter="handleInputConfirm"
          />
          <a-tag v-else style="background: #fff; border-style: dashed" @click="showInput">
            <plus-outlined />
            New Tag
          </a-tag>
        </a-form-item>
      </a-form>
      <a-flex class="activity-container">
        <Activity class="activity-item" v-for="_, index in acitivitys" :key="index" @click="choice(index)" :data="acitivitys[index]"></Activity>
      </a-flex>
    </a-flex>
    <activity-detail v-model:showDetail=showDetail></activity-detail>
  </div>
</template>

<script setup lang="ts">
import { ref, nextTick } from 'vue';
import { PlusOutlined } from '@ant-design/icons-vue';
import ActivityDetail from '../common/ActivityDetail.vue'
import { getActivityAll } from '@/api/api';
import Activity from '../common/Activity.vue';

const showDetail = ref(false);
const inputRef = ref<HTMLInputElement | null>(null);
const inputLabel = ref('');
const inputVisible = ref(false);

const filterDate = ref({
  like: false,
  name: '',
  state: 'all',
  labels: []
})

const handleClose = (removedLabel: string) => {
  filterDate.value.labels = filterDate.value.labels.filter(tag => tag !== removedLabel);
};

const showInput = () => {
  inputVisible.value = true;
  nextTick(() => {
    inputRef.value!.focus();
  });
};

const handleInputConfirm = () => {
  if (inputLabel.value) {
    filterDate.value.labels.push(inputLabel.value);
  }
  inputLabel.value = '';
  inputVisible.value = false;
};

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