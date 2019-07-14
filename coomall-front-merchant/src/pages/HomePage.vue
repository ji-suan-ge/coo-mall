<template>
  <el-container>
    <el-header>商家主页</el-header>
    <el-container>
      <el-aside width="200px">
          <el-menu
            default-active="0"
            class="el-menu-vertical-demo"
            @open="handleOpen"
            @close="handleClose"
            background-color="#545c64"
            text-color="#fff"
            active-text-color="#ffd04b">
            <router-link to="/homePage/productsManage">
              <el-menu-item index="1">商品管理</el-menu-item>
            </router-link>
            <router-link to="/homePage/orderFormManage">
              <el-menu-item index="2">订单管理</el-menu-item>
            </router-link>
            <router-link to="/homePage/reportForm">
              <el-menu-item index="3">报表</el-menu-item>
            </router-link>
            <router-link to="/homePage/merchantInfo">
              <el-menu-item index="4">商家信息</el-menu-item>
            </router-link>
            <router-link to="/homePage/merchantManage">
              <el-menu-item index="5">商家管理</el-menu-item>
            </router-link>
          </el-menu>
      </el-aside>
      <el-main>
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: 'homePage',
  methods: {
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>

<style scoped>
  .el-header, .el-footer {
    background-color: #545c64;
    color: #fff;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 200px;
  }

  .el-main {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  body > .el-container {
    margin-bottom: 40px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  }
</style>
