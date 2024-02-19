<template>
  <div class="__container_activity_detail">
    <a-drawer
        v-model:open="showDetail"
        width="800"
        title="活动详情"
        placement="right"
        @after-open-change="afterOpenChange"
      >
      <a-descriptions :column="1" title="xxx">

        <a-descriptions-item>
          <img alt="example" src="https://os.alipayobjects.com/rmsportal/QBnOOoLaAfKPirc.png" style="width: 240px"/>
        </a-descriptions-item>
        <a-descriptions-item label="活动描述">description</a-descriptions-item>
        <a-descriptions-item label="举办时间">time</a-descriptions-item>
        <a-descriptions-item label="举办地点">location</a-descriptions-item>
        <a-descriptions-item label="人数上限">limit</a-descriptions-item>
        <a-descriptions-item label="活动时常">duration</a-descriptions-item>
        <a-descriptions-item label="点击次数">clicknum</a-descriptions-item>
        <a-descriptions-item label="当前报名人数">number</a-descriptions-item>
        <a-descriptions-item label="当前喜欢人数">likes</a-descriptions-item>
      </a-descriptions>
    </a-drawer>
  </div>
</template>

<script setup lang="ts">
import { ref, watch } from 'vue';

const props = defineProps({
  showDetail: {
    type: Boolean,
    require: true
  }
})

const emit = defineEmits(['update:showDetail']);

const showDetail = ref(props.showDetail);

const afterOpenChange = (bool: boolean) => {
  console.log('open', bool);
};

watch(showDetail, (newValue) => {
  emit('update:showDetail', newValue);
})

watch(() => props.showDetail, (newValue) => {
  showDetail.value = newValue
})
</script>

<style scoped lang="less">

</style>
