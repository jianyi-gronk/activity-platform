<template>
  <div class="__container_layout_header">
    <a-flex class="header">
      <a-flex class="flex-container">
        <div @click="() => router.push('/home')">首页</div>
        <div @click="() => router.push('/all')">全部</div>
        <div @click="() => router.push('/manage')">管理</div>
      </a-flex>
      <a-flex class="flex-container">
        <color-picker
          :pureColor="GET_THEME"
          @pureColorChange="changeTheme"
          format="hex6"
          shape="circle"
          useType="pure"
        ></color-picker>
        <div>
          <a-avatar v-if="GET_TOKEN === '' || GET_USERID === ''" @click="() => openModal = true">
            请登陆
          </a-avatar>
          <a-avatar v-else @click="() => router.push({ name: 'my', params: { userId: GET_USERID }})">
            <template #icon><UserOutlined /></template>
          </a-avatar>
        </div>
      </a-flex>
    </a-flex>
    <a-modal v-model:open="openModal" :footer="null">
      <a-tabs v-model:activeKey="activeKey">
        <a-tab-pane key="login" tab="登陆">
          <a-form
            :model="loginForm"
            :label-col="{ span: 6 }"
            :wrapper-col="{ span: 16 }"
            name="loginForm"
            @submit="userLogin"
          >
            <a-form-item
              label="用户名"
              name="userName"
              :rules="[{ required: true, message: '用户名不能为空！' }]"
            >
              <a-input v-model:value="loginForm.userName" />
            </a-form-item>
            <a-form-item
              label="密码"
              name="password"
              :rules="[{ required: true, message: '密码不能为空！' }]"
            >
              <a-input-password v-model:value="loginForm.password" />
            </a-form-item>
            <a-form-item :wrapper-col="{ offset: 6, span: 16 }">
              <a-button type="primary" html-type="submit" :disabled="!isLoginFormValid">确认</a-button>
            </a-form-item>
          </a-form>
        </a-tab-pane>
        <a-tab-pane key="register" tab="注册" force-render>
          <a-form
            :model="registerForm"
            :label-col="{ span: 6 }"
            :wrapper-col="{ span: 16 }"
            name="registerForm"
            @submit="userRegister"
          >
            <a-form-item
              label="用户名"
              name="userName"
              :rules="[{ required: true, message: '用户名不能为空！' }]"
            >
              <a-input v-model:value="registerForm.userName" />
            </a-form-item>
            <a-form-item
              label="密码"
              name="password"
              :rules="[{ required: true, message: '密码不能为空！' }]"
            >
              <a-input-password v-model:value="registerForm.password" />
            </a-form-item>
            <a-form-item
              label="确认密码"
              name="confirmPassword"
              :rules="[{ required: true, message: '两次密码不相同！', pattern: new RegExp('^'+ registerForm.password + '$') }]"
            >
              <a-input-password v-model:value="registerForm.confirmPassword" />
            </a-form-item>
            <a-form-item :wrapper-col="{ offset: 6, span: 16 }">
              <a-button type="primary" html-type="submit" :disabled="!isRegisterFormValid">确认</a-button>
            </a-form-item>
          </a-form>
        </a-tab-pane>
      </a-tabs>
    </a-modal>
  </div>
</template>

<script setup lang="ts">
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';
import { UserOutlined } from '@ant-design/icons-vue';
import {
  GET_THEME,
  changeTheme,
  GET_TOKEN,
  GET_USERID,
  changeIsLogin
} from '@/base/localStorage';
import { login, register } from '@/api/api';
import { message } from 'ant-design-vue';

const router = useRouter();

const openModal = ref(false);
const activeKey = ref("login")

const isLoginFormValid = computed(() => {
  return loginForm.value.userName && loginForm.value.password;
});;

const isRegisterFormValid = computed(() => {
  return registerForm.value.userName 
    && registerForm.value.password 
    && registerForm.value.confirmPassword 
    && registerForm.value.password === registerForm.value.confirmPassword;
});;

interface LoginForm {
  userName: string;
  password: string;
}

const loginForm = ref<LoginForm>({
  userName: '',
  password: ''
});

interface registerForm {
  userName: string;
  password: string;
  confirmPassword: string;
}

const registerForm = ref<registerForm>({
  userName: '',
  password: '',
  confirmPassword: ''
});

const userLogin = async () => {
  const data = await login(loginForm.value);
  if (data.result) {
    changeIsLogin({ token: data.result.token, id: data.result.id });
    message.success('登陆成功！');
    openModal.value = false;
  }
  else {
    message.error('用户名或密码错误！');
  }
}

const userRegister = async () => {
  const data = await register({
    userName: registerForm.value.userName,
    password: registerForm.value.password
  })
  if (data.result) {
    message.success('注册成功，即将自动登录！');
    loginForm.value.userName = registerForm.value.userName;
    loginForm.value.password = registerForm.value.password;
    userLogin();
  }
  else {
    message.error('注册失败！');
  }
}

</script>

<style scoped lang="less">
.__container_layout_header {
  background: v-bind('GET_THEME');
  .header {
    height: 50px;
    width: 100%;
    justify-content: space-between;
    .flex-container {
      align-items: center;
      & > * {
        padding: 10px;
        font-size: 16px;
        color: white;
        margin-left: 20px;
        margin-right: 20px;
        &:hover {
          cursor: pointer;
        }
      }
    }
  }
}
</style>
