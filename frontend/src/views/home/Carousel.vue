<template>
  <div class="__container_home_carousel">
    <a-carousel arrows autoplay>
      <template #prevArrow>
        <div class="custom-slick-arrow" style="left: 10px; z-index: 1">
          <left-circle-outlined />
        </div>
      </template>
      <template #nextArrow>
        <div class="custom-slick-arrow" style="right: 10px">
          <right-circle-outlined />
        </div>
      </template>
      <div class="carousel-item"></div>
      <div class="carousel-item"></div>
      <div class="carousel-item"></div>
      <div class="carousel-item"></div>
    </a-carousel>
  </div>
</template>

<script setup lang="ts">
import { LeftCircleOutlined, RightCircleOutlined } from '@ant-design/icons-vue';
</script>

<style scoped lang="less">
.__container_home_carousel {
  width: 100%;
  position: relative;
  :deep(.slick-slide) {
    text-align: center;
    height: 300px;
    background: #364d79;
    overflow: hidden;
  }
  :deep(.slick-arrow.custom-slick-arrow) {
    width: 25px;
    height: 25px;
    font-size: 25px;
    color: #fff;
    background-color: rgba(31, 45, 61, 0.11);
    transition: ease all 0.3s;
    opacity: 0.3;
    z-index: 1;
  }
  :deep(.slick-arrow.custom-slick-arrow:before) {
    display: none;
  }
  :deep(.slick-arrow.custom-slick-arrow:hover) {
    color: #fff;
    opacity: 0.5;
  }
  :deep(.slick-slide h3) {
    color: #fff;
  }
}
</style>