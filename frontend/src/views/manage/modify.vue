<template>
  <div class="__container_manage_modify">
    <a-descriptions bordered :column="1" title="编辑活动设置" :labelStyle="{ width: '200px' }">
      <a-descriptions-item label="活动图片">
        <a-upload
          v-model:file-list="fileList"
          name="picture"
          list-type="picture-card"
          class="picture-uploader"
          :show-upload-list="false"
          :before-upload="beforeUpload"
          @change="handleChange"
          :customRequest="updateImg"
        >
          <img v-if="activityData.picture" :src="activityData.picture" alt="picture" class="picture-image" />
          <div v-else>
            <loading-outlined v-if="loading"></loading-outlined>
            <plus-outlined v-else></plus-outlined>
            <div class="ant-upload-text">Upload</div>
          </div>
        </a-upload>
      </a-descriptions-item>
      <a-descriptions-item label="活动标题">
        <div v-if="!editValue.title.isEdit">
          <span>{{ activityData.title }}</span>
          <edit-outlined class="edit-icon" @click="showEdit('title')" />
        </div>
        <div v-else>
          <a-flex class="edit-container">
            <a-input v-model:value="editValue.title.value" placeholder="请输入" class="edit-input" />
            <check-outlined @click="update('title')" />
            <close-outlined @click="closeEdit('title')"/>
          </a-flex>
        </div>
      </a-descriptions-item>
      <a-descriptions-item label="活动描述">
        <div v-if="!editValue.description.isEdit">
          <span>{{ activityData.description }}</span>
          <edit-outlined class="edit-icon" @click="showEdit('description')" />
        </div>
        <div v-else>
          <a-flex class="edit-container">
            <a-input v-model:value="editValue.description.value" placeholder="请输入" class="edit-input" />
            <check-outlined @click="update('description')" />
            <close-outlined @click="closeEdit('description')"/>
          </a-flex>
        </div>
      </a-descriptions-item>
      <a-descriptions-item label="开始 - 结束时间">
        <div v-if="!editValue.timeArr.isEdit">
          <a-range-picker v-model:value="activityData.timeArr" disabled />
          <edit-outlined class="edit-icon" @click="showEdit('timeArr')" />
        </div>
        <div v-else>
          <a-flex class="edit-container">
            <a-range-picker v-model:value="editValue.timeArr.value" />
            <check-outlined @click="update('timeArr')" />
            <close-outlined @click="closeEdit('timeArr')"/>
          </a-flex>
        </div>
      </a-descriptions-item>
      <a-descriptions-item label="举办地点">
        <div v-if="!editValue.location.isEdit">
          <span>{{ activityData.location }}</span>
          <edit-outlined class="edit-icon" @click="showEdit('location')" />
        </div>
        <div v-else>
          <a-flex class="edit-container">
            <a-input v-model:value="editValue.location.value" placeholder="请输入" class="edit-input" />
            <check-outlined @click="update('location')" />
            <close-outlined @click="closeEdit('location')"/>
          </a-flex>
        </div>
      </a-descriptions-item>
      <a-descriptions-item label="人数上限">
        <div v-if="!editValue.upperLimit.isEdit">
          <span>{{ activityData.upperLimit }}</span>
          <edit-outlined class="edit-icon" @click="showEdit('upperLimit')" />
        </div>
        <div v-else>
          <a-flex class="edit-container">
            <a-input v-model:value="editValue.upperLimit.value" placeholder="请输入" class="edit-input" />
            <check-outlined @click="update('upperLimit')" />
            <close-outlined @click="closeEdit('upperLimit')"/>
          </a-flex>
        </div>
      </a-descriptions-item>
      <a-descriptions-item label="标签">
          <a-flex class="edit-container">
            <template v-for="label in labels" :key="label">
              <a-tag closable @close="handleClose(label)">
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
          </a-flex>
      </a-descriptions-item>
    </a-descriptions>
  </div>
</template>

<script setup lang="ts">
import { ref, watch, nextTick } from 'vue';
import { PlusOutlined, LoadingOutlined, EditOutlined, CheckOutlined, CloseOutlined } from '@ant-design/icons-vue';
import { message } from 'ant-design-vue';
import type { UploadChangeParam, UploadProps } from 'ant-design-vue';
import { useRoute } from 'vue-router';
import { getActivityById, updateUserInformatio } from '@/api/api';
import type { Dayjs } from 'dayjs';
import dayjs from 'dayjs';

type RangeValue = [Dayjs, Dayjs];

const route = useRoute();

const activityId = ref(route.params.activityId);

const inputRef = ref<HTMLInputElement | null>(null);

const labels = ref([]);

const handleClose = (removedLabel: string) => {
  labels.value = labels.value.filter(tag => tag !== removedLabel);
};

const inputLabel = ref('');
const inputVisible = ref(false);

const handleInputConfirm = () => {
  if (inputLabel.value) {
    labels.value.push(inputLabel.value);
  }
  inputLabel.value = '';
  inputVisible.value = false;
};

const showInput = () => {
  inputVisible.value = true;
  nextTick(() => {
    inputRef.value!.focus();
  });
};

const editValue = ref({
  title: {
    isEdit: false,
    value: '',
  },
  description: {
    isEdit: false,
    value: '',
  },
  timeArr: {
    isEdit: false,
    value: '',
  },
  location: {
    isEdit: false,
    value: '',
  },
  upperLimit: {
    isEdit: false,
    value: '',
  }
})

const activityData = ref({
  picture: '',
  title: '',
  description: '',
  timeArr: [dayjs(), dayjs()] as RangeValue,
  startTime: undefined,
  endTime: undefined,
  location: '',
  upperLimit: '',
});

const getAcitivityInfo = async () => {
  const data = await getActivityById({ id: activityId.value });
  if(data.result) {
    console.log(data.result);
    activityData.value = data.result;
    activityData.value.timeArr = [dayjs(activityData.value.startTime), dayjs(activityData.value.endTime)];
  } else {
    message.error('获取活动信息失败！');
  }
}

const update = async (param: string) => {
  activityData.value[param] = activityData.value[param].value;
  const data = await updateUserInformation(activityData.value);
  if(data.result) {
    message.success('更新用户信息成功！')
  }
  else {
    message.error('更新用户信息失败！');
  }
  closeEdit(param);
  getAcitivityInfo();
}

const updateImg = (options) => {
  const { file, onSuccess } = options;

  // 创建 FileReader 对象
  const reader = new FileReader();
  reader.onload = async () => {
    const base64Image = reader.result;
    activityData.value.picture = base64Image;

    const data = await updateUserInformation(activityData.value);
    if(!data.result) {
      message.error('更新用户信息失败！');
    }
    await getAcitivityInfo();
    onSuccess();
  };

  reader.readAsDataURL(file);
}

const closeEdit = (param: string) => {
  editValue.value[param].isEdit = false;
}

const showEdit = (param: string) => {
  editValue.value[param].isEdit = true;
  editValue.value[param].value = activityData.value[param];
}

function getBase64(img: Blob, callback: (base64Url: string) => void) {
  const reader = new FileReader();
  reader.addEventListener('load', () => callback(reader.result as string));
  reader.readAsDataURL(img);
}

const fileList = ref([]);
const loading = ref<boolean>(false);
const imageUrl = ref<string>('');

const handleChange = (info: UploadChangeParam) => {
  if (info.file.status === 'uploading') {
    loading.value = true;
    return;
  }
  if (info.file.status === 'done') {
    // Get this url from response in real world.
    getBase64(info.file.originFileObj, (base64Url: string) => {
      imageUrl.value = base64Url;
      loading.value = false;
    });
  }
  if (info.file.status === 'error') {
    loading.value = false;
    message.error('upload error');
  }
};

const beforeUpload = (file: UploadProps['fileList'][number]) => {
  const isJpgOrPng = file.type === 'image/jpeg' || file.type === 'image/png';
  if (!isJpgOrPng) {
    message.error('You can only upload JPG file!');
  }
  const isLt2M = file.size / 1024 / 1024 < 2;
  if (!isLt2M) {
    message.error('Image must smaller than 2MB!');
  }
  return isJpgOrPng && isLt2M;
};

watch(
  () => route.params,
  () => {
    activityId.value = route.params.activityId;
    getAcitivityInfo();
  },
  { immediate: true }
);
</script>

<style scoped lang="less">
.__container_manage_modify {
  margin-top: 20px;
  width: 800px;
  margin-left: auto;
  margin-right: auto;
  .edit-icon {
    margin-left: 50px;
  }
  .edit-container {
    align-items: center;
    .edit-input {
      width: 200px;
    }
    .edit-textarea {
      width: 300px;
    }
    & > * {
      margin-right: 20px;
    }
  }
  .operate {
    margin-top: 20px;
    justify-content: flex-end;
  }
}

.picture-uploader {
  .picture-image {
    height: 102px;
    width: 102px;
  }
}
</style>