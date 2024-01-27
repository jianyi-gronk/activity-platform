<template>
  <div class="__container_home_index">
    <carousel class="carousel"></carousel>
    <recommend class="recommend"></recommend>
  </div>
</template>

<script setup lang="ts">
import Carousel from './Carousel.vue'
import Recommend from './Recommend.vue'
</script>

<style scoped lang="less">
.__container_home_index {
  .carousel {
    margin-top: 20px;
  }
  .recommend {
    margin-top: 20px;
  }
}
</style>