<template>
  <div>
    <a-row :gutter="16">
      <a-col :span="12">
        <a-statistic-countdown
          title="Countdown"
          :value="deadline"
          style="margin-right: 50px"
          @finish="onFinish"
        />
      </a-col>
      <a-col :span="12">
        <a-statistic-countdown
          title="Million Seconds"
          :value="deadline"
          format="HH:mm:ss:SSS"
          style="margin-right: 50px"
        />
      </a-col>
      <a-col :span="24" style="margin-top: 32px">
        <a-statistic-countdown title="Day Level" :value="deadline" format="D 天 H 时 m 分 s 秒" />
      </a-col>
      <a-col>
        <div
          class="echart"
          ref="mychart"
          id="mychart"
          :style="{ float: 'left', width: '100%', height: '400px' }"
        ></div>
      </a-col>
    </a-row>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import * as echarts from "echarts";

const onFinish = () => {
  console.log('finished!');
};
const deadline = Date.now() + 1000 * 60 * 60 * 24 * 2 + 1000 * 30;

const initEcharts = () => {
  const option = {
    title: {
      text: "ECharts 入门示例"
    },
    tooltip: {},
    legend: {
      data: ["销量"]
    },
    xAxis: {
      data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"]
    },
    yAxis: {},
    series: [
      {
        name: "销量",
        type: "bar", //类型为柱状图
        data: [5, 20, 36, 10, 10, 20]
      }
    ]
  };
  const myChart = echarts.init(this.$refs.mychart);// 图标初始化
  myChart.setOption(option);// 渲染页面
  //随着屏幕大小调节图表
  window.addEventListener("resize", () => {
    myChart.resize();
  });
}

initEcharts();
</script>

<style scoped lang="less">

</style>