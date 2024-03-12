<template>
  <div class="__container_activity">
    <a-card hoverable>
      <template #cover>
        <img v-if="data.img" :src="data.img" style="height: 200px;"/>
        <img v-else src="../../assets/default.jpeg" style="height: 200px;"/>
      </template>
      <a-card-meta :title="data.title" style="height: 100px;">
        <template #description>{{ data.description }}</template>
      </a-card-meta>
    </a-card>
  </div>
</template>

<script setup lang="ts">
defineProps({
  data: {
    require: true
  }
})
</script>

<style scoped lang="less">
</style>
