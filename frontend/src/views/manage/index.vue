<template>
  <div class="__container_manage_index">
    <div class="activity-item-add">
      <a-button type="primary" @click="() => openModal = true">+ 创建活动</a-button>
    </div>
    <a-flex class="activity-container">
      <Activity class="activity-item" v-for="item, index in myAcitivitys" :key="index" @click="() => { router.push('/manage/' + item.id)}" :data="item"></Activity>
    </a-flex>
    <a-modal v-model:open="openModal" :footer="null">
      <a-form
        :model="addForm"
        :label-col="{ span: 6 }"
        :wrapper-col="{ span: 16 }"
        name="loginForm"
      >
        <a-form-item
          label="活动标题"
          name="title"
          :rules="[{ required: true, message: '活动标题不能为空！' }]"
        >
          <a-input v-model:value="addForm.title" />
        </a-form-item>
        <a-form-item
          label="活动描述"
          name="description"
          :rules="[{ required: true, message: '活动描述不能为空！' }]"
        >
          <a-input v-model:value="addForm.description" />
        </a-form-item>
        <a-form-item
          label="开始 - 结束时间"
          name="timeArr"
          :rules="[{ required: true, message: '活动时间不能为空！' }]"
        >
          <a-range-picker v-model:value="timeArr" />
        </a-form-item>
        <a-form-item
          label="活动举办地"
          name="location"
          :rules="[{ required: true, message: '活动举办地不能为空！' }]"
        >
          <a-input v-model:value="addForm.location" />
        </a-form-item>
        <a-form-item
          label="活动人数上限"
          name="upperLimit"
          :rules="[{ required: true, message: '活动人数上限不能为空！' }]"
        >
          <a-input v-model:value="addForm.upperLimit" />
        </a-form-item>
        <a-form-item :wrapper-col="{ offset: 6, span: 16 }">
          <a-button type="primary" html-type="submit" @click="addActivityItem">确认</a-button>
        </a-form-item>
      </a-form>
    </a-modal>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { useRouter,  } from 'vue-router';
import type { Dayjs } from 'dayjs';
import dayjs from 'dayjs';
import { addActivity, getActivityByUserId } from '@/api/api'
import { GET_USERID } from '../../base/localStorage';
import { message } from 'ant-design-vue';
import Activity from '../common/Activity.vue';

type RangeValue = [Dayjs, Dayjs];

interface AddForm {
  title: string;
  description: string;
  timeArr: RangeValue;
  startTime: Date | undefined;
  endTime: Date | undefined;
  location: string;
  upperLimit: string;
}

const addForm = ref<AddForm>({
  title:'',
  description: '',
  timeArr: [dayjs(), dayjs()],
  startTime: undefined,
  endTime: undefined,
  location: '',
  upperLimit: '',
});

const router = useRouter();
const openModal = ref(false);

const addActivityItem = () => {
  addForm.value.startTime = addForm.value.timeArr[0].toDate();
  addForm.value.endTime = addForm.value.timeArr[1].toDate();
  const data = addActivity({ ...addForm.value, userId: GET_USERID.value });
  if (data.result) {
    message.success('添加活动成功！');
    getActivity();
  }
  else {
    message.success('添加活动失败！');
  }
}

const myAcitivitys = ref([]);

const getActivity = async () => {
  const data = await getActivityByUserId({ userId: GET_USERID.value });
  if(data.result) {
    myAcitivitys.value = data.result;
    console.log(data.result)
  }
  else {
    message.success('获取失败，请先登陆！');
  }
}

getActivity();
</script>

<style scoped lang="less">
.__container_manage_index {
  .activity-item-add {
    margin-top: 20px;
    margin-left: 25px;
  }
  .activity-container {
    margin-top: 20px;
    align-items: center;
    flex-wrap: wrap;
    .activity-item {
      width: 250px;
      height: 300px;
      margin-bottom: 65px;
      margin-right: 25px;
      margin-left: 25px;
    }
  }
}
</style>