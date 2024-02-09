<template>
  <router-view></router-view>
</template>

<script setup lang="ts">
import { ref, provide } from 'vue';
import { RouterView } from 'vue-router';
import { PROVIDE_INJECT_KEY } from '@/base/provideInjectKey';

provide(PROVIDE_INJECT_KEY.ISLOGIN, ref(false))
</script>

<style scoped>

</style>
