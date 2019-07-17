<template>
  <el-pagination
    background
    layout="prev, pager, next"
    :total="1000">
  </el-pagination>
</template>
<script>
export default {
  name: 'test',
  methods: {
  }
}
</script>

<style>
  .el-header{
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 800px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

</style>
