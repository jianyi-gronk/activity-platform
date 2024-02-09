<template>
  <div class="__container_my_index">
    <a-descriptions bordered :column="1" title="用户设置" :labelStyle="{ width: '200px' }">
      <a-descriptions-item label="头像">
        <a-upload
          v-model:file-list="fileList"
          name="avatar"
          list-type="picture-card"
          class="avatar-uploader"
          :show-upload-list="false"
          action="https://www.mocky.io/v2/5cc8019d300000980a055e76"
          :before-upload="beforeUpload"
          @change="handleChange"
        >
          <img v-if="imageUrl" :src="imageUrl" alt="avatar" />
          <div v-else>
            <loading-outlined v-if="loading"></loading-outlined>
            <plus-outlined v-else></plus-outlined>
            <div class="ant-upload-text">Upload</div>
          </div>
        </a-upload>
      </a-descriptions-item>
      <a-descriptions-item label="用户名">
        <div v-if="!editValue.userName.isEdit">
          <span>123</span>
          <edit-outlined class="edit-icon" @click="showEdit('userName')"/>
        </div>
        <div v-else>
          <a-flex class="edit-container">
            <a-input v-model:value="editValue.userName.value" placeholder="请输入" class="edit-input" />
            <check-outlined @click="update('userName')" />
            <close-outlined @click="closeEdit('userName')"/>
          </a-flex>
        </div>
      </a-descriptions-item>
      <a-descriptions-item label="用户密码">
        <div v-if="!editValue.password.isEdit">
          <span>123</span>
          <edit-outlined class="edit-icon" @click="showEdit('password')"/>
        </div>
        <div v-else>
          <a-flex class="edit-container">
            <a-input-password v-model:value="editValue.password.value" placeholder="请输入" class="edit-input" />
            <check-outlined @click="update('password')" />
            <close-outlined @click="closeEdit('password')"/>
          </a-flex>
        </div>
      </a-descriptions-item>
      <a-descriptions-item label="姓名">
        <div v-if="!editValue.name.isEdit">
          <span>123</span>
          <edit-outlined class="edit-icon" @click="showEdit('name')"/>
        </div>
        <div v-else>
          <a-flex class="edit-container">
            <a-input v-model:value="editValue.name.value" placeholder="请输入" class="edit-input" />
            <check-outlined @click="update('name')" />
            <close-outlined @click="closeEdit('name')"/>
          </a-flex>
        </div>
      </a-descriptions-item>
      <a-descriptions-item label="性别">
        <div v-if="!editValue.sex.isEdit">
          <span>123</span>
          <edit-outlined class="edit-icon" @click="showEdit('sex')"/>
        </div>
        <div v-else>
          <a-flex class="edit-container">
            <a-radio-group v-model:value="editValue.sex.value" :options="sexOptions" />
            <check-outlined @click="update('sex')" />
            <close-outlined @click="closeEdit('sex')"/>
          </a-flex>
        </div>
      </a-descriptions-item>
      <a-descriptions-item label="联系电话">
        <div v-if="!editValue.phone.isEdit">
          <span>123</span>
          <edit-outlined class="edit-icon" @click="showEdit('phone')"/>
        </div>
        <div v-else>
          <a-flex class="edit-container">
            <a-input v-model:value="editValue.phone.value" placeholder="请输入" class="edit-input" />
            <check-outlined @click="update('phone')" />
            <close-outlined @click="closeEdit('phone')"/>
          </a-flex>
        </div>
      </a-descriptions-item>
      <a-descriptions-item label="联系邮箱">
        <div v-if="!editValue.email.isEdit">
          <span>123</span>
          <edit-outlined class="edit-icon" @click="showEdit('email')"/>
        </div>
        <div v-else>
          <a-flex class="edit-container">
            <a-input v-model:value="editValue.email.value" placeholder="请输入" class="edit-input" />
            <check-outlined @click="update('email')" />
            <close-outlined @click="closeEdit('email')"/>
          </a-flex>
        </div>
      </a-descriptions-item>
      <a-descriptions-item label="个人简介">
        <div v-if="!editValue.description.isEdit">
          <span>123</span>
          <edit-outlined class="edit-icon" @click="showEdit('description')"/>
        </div>
        <div v-else>
          <a-flex class="edit-container">
            <a-textarea v-model:value="editValue.description.value" placeholder="请输入" class="edit-textarea" />
            <check-outlined @click="update('description')" />
            <close-outlined @click="closeEdit('description')"/>
          </a-flex>
        </div>
      </a-descriptions-item>
    </a-descriptions>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { PlusOutlined, LoadingOutlined, EditOutlined, CheckOutlined, CloseOutlined } from '@ant-design/icons-vue';
import { message } from 'ant-design-vue';
import type { UploadChangeParam, UploadProps } from 'ant-design-vue';

const sexOptions = ref([
  {
    label: '男',
    value: 'male'
  },
  {
    label: '女',
    value: 'woman'
  },
  {
    label: '未选择',
    value: 'unselected'
  }
])

const editValue = ref({
  userName: {
    isEdit: false,
    value: '',
  },
  password: {
    isEdit: false,
    value: '',
  },
  name: {
    isEdit: false,
    value: '',
  },
  sex: {
    isEdit: false,
    value: 'unselected',
  },
  phone: {
    isEdit: false,
    value: '',
  },
  email: {
    isEdit: false,
    value: '',
  },
  description: {
    isEdit: false,
    value: '',
  }
})

const showEdit = (param: string) => {
  editValue.value[param].isEdit = true;
  switch(param) {
    case 'password':
      editValue.value[param].value = '';
    default:
      editValue.value[param].value = '123';
  }
}

const update = (param: string) => {
  console.log(param)
}

const closeEdit = (param: string) => {
  editValue.value[param].isEdit = false;
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
</script>

<style scoped lang="less">
.__container_my_index {
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
}

.avatar-uploader > .ant-upload {
  width: 128px;
  height: 128px;
}
.ant-upload-select-picture-card i {
  font-size: 32px;
  color: #999;
}

.ant-upload-select-picture-card .ant-upload-text {
  margin-top: 8px;
  color: #666;
}
</style>