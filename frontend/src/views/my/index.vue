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
          :before-upload="beforeUpload"
          @change="handleChange"
          :customRequest="updateAvatar"
          :disabled="!canEdit"
        >
          <img v-if="userData.avatar" :src="userData.avatar" alt="avatar" class="avatar-image" />
          <div v-else>
            <loading-outlined v-if="loading"></loading-outlined>
            <plus-outlined v-else></plus-outlined>
            <div class="ant-upload-text">Upload</div>
          </div>
        </a-upload>
      </a-descriptions-item>
      <a-descriptions-item label="用户名">
        <div v-if="!editValue.userName.isEdit">
          <span>{{ userData.userName }}</span>
          <edit-outlined class="edit-icon" @click="showEdit('userName')" v-if="canEdit" />
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
          <span>{{ userData.password }}</span>
          <edit-outlined class="edit-icon" @click="showEdit('password')" v-if="canEdit" />
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
          <span>{{ userData.name }}</span>
          <edit-outlined class="edit-icon" @click="showEdit('name')" v-if="canEdit" />
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
          <span>{{ toSexString(userData.sex) }}</span>
          <edit-outlined class="edit-icon" @click="showEdit('sex')" v-if="canEdit" />
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
          <span>{{ userData.phone }}</span>
          <edit-outlined class="edit-icon" @click="showEdit('phone')" v-if="canEdit" />
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
          <span>{{ userData.email }}</span>
          <edit-outlined class="edit-icon" @click="showEdit('email')" v-if="canEdit" />
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
          <span>{{ userData.description }}</span>
          <edit-outlined class="edit-icon" @click="showEdit('description')" v-if="canEdit" />
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
    <a-flex class="operate" v-if="canEdit">
      <a-button type="link" @click="exitUser">退出登陆</a-button>
      <a-popconfirm
        title="确定要注销吗？"
        ok-text="是"
        cancel-text="否"
        @confirm="deleteUser"
      >
        <a-button type="link">注销</a-button>
      </a-popconfirm>
    </a-flex>
  </div>
</template>

<script setup lang="ts">
import { ref, watch } from 'vue';
import { PlusOutlined, LoadingOutlined, EditOutlined, CheckOutlined, CloseOutlined } from '@ant-design/icons-vue';
import { message } from 'ant-design-vue';
import type { UploadChangeParam, UploadProps } from 'ant-design-vue';
import { changeIsLogin } from '@/base/localStorage'
import { useRouter, useRoute } from 'vue-router';
import { getUserInformation, updateUserInformation, deleteUserInformation, verifyUser } from '@/api/api'

const route = useRoute();
const router = useRouter();

const userId = ref(route.params.userId);

const canEdit = ref(false);

const isAbleEdit = async () => {
  const data = await verifyUser({ userId: userId.value });
  canEdit.value = data.result;
}

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

const toSexString = (param: string) => {
  switch(param) {
    case 'unselected':
      return '未选择';
    case 'woman':
      return '女';
    case 'male':
      return '男';
  }
}

const userData = ref({});

const getUserInfo = async () => {
  const data = await getUserInformation({ userId: userId.value });
  if(data.result) {
    userData.value = data.result;
  } else {
    message.error('获取用户信息失败！');
  }
}

const showEdit = (param: string) => {
  editValue.value[param].isEdit = true;
  editValue.value[param].value = userData.value[param];
}

const update = async (param: string) => {
  userData.value[param] = editValue.value[param].value;
  const data = await updateUserInformation(userData.value);
  if(data.result) {
    message.success('更新用户信息成功！')
  }
  else {
    message.error('更新用户信息失败！');
  }
  closeEdit(param);
  getUserInfo();
}

const updateAvatar = (options) => {
  const { file, onSuccess } = options;

  // 创建 FileReader 对象
  const reader = new FileReader();
  reader.onload = async () => {
    const base64Image = reader.result;
    userData.value.avatar = base64Image;

    const data = await updateUserInformation(userData.value);
    if(!data.result) {
      message.error('更新用户信息失败！');
    }
    await getUserInfo();
    onSuccess();
  };

  reader.readAsDataURL(file);
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

const exitUser = () => {
  changeIsLogin({});
  router.push('/home');
}

const deleteUser = async () => {
  const data = await deleteUserInformation({ userId: userId.value });
  if(data.result) {
    exitUser();
  }
  else {
    message.error('注销失败！');
  }
}

watch(
  () => route.params,
  () => {
    userId.value = route.params.userId;
    isAbleEdit();
    getUserInfo();
  },
  { immediate: true }
);
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
  .operate {
    margin-top: 20px;
    justify-content: flex-end;
  }
}

.avatar-uploader {
  .avatar-image {
    height: 102px;
    width: 102px;
  }
}
</style>