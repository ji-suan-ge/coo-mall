<template>
  <el-menu
    default-active="0"
    background-color="#777777"
    text-color="#ffffff"
    class="left-menu">
    <router-link to="Address">
      <el-menu-item index="1">我的收货地址</el-menu-item>
    </router-link>
    <el-submenu index="2">
      <template slot="title">我的订单</template>
      <el-submenu index="2-1">
        <template slot="title">进行中订单</template>
        <router-link to="/User/checkOrder?state=0">
          <el-menu-item index="2-1-1" @click="switchPage(0)">待付款</el-menu-item>
        </router-link>
        <router-link to="/User/checkOrder?state=1">
          <el-menu-item index="2-1-2" @click="switchPage(1)">待发货</el-menu-item>
        </router-link>
        <router-link to="/User/checkOrder?state=2">
          <el-menu-item index="2-1-3" @click="switchPage(2)">已发货</el-menu-item>
        </router-link>
        <router-link to="/User/checkOrder?state=3">
          <el-menu-item index="2-1-4" @click="switchPage(3)">已签收</el-menu-item>
        </router-link>
      </el-submenu>
      <el-submenu index="2-2">
        <template slot="title">已完成订单</template>
        <router-link to="/User/checkOrder?state=4">
          <el-menu-item index="2-2-1" @click="switchPage(4)">已完成</el-menu-item>
        </router-link>
      </el-submenu>
      <el-submenu index="2-3">
        <template slot="title">退货订单</template>
        <router-link to="/User/checkOrder?state=5">
          <el-menu-item index="2-3-1" @click="switchPage(5)">待退货</el-menu-item>
        </router-link>
        <router-link to="/User/checkOrder?state=6">
          <el-menu-item index="2-3-2" @click="switchPage(6)">退货中</el-menu-item>
        </router-link>
        <router-link to="/User/checkOrder?state=7">
          <el-menu-item index="2-3-3" @click="switchPage(7)">已退货</el-menu-item>
        </router-link>
      </el-submenu>
      <el-submenu index="2-4">
        <template slot="title">已取消订单</template>
        <router-link to="/User/checkOrder?state=8">
          <el-menu-item index="2-4-1" @click="switchPage(8)">已取消</el-menu-item>
        </router-link>
      </el-submenu>
    </el-submenu>
    <router-link to="personalInfo">
      <el-menu-item index="3">我的个人信息</el-menu-item>
    </router-link>
    <router-link to="shoppingCar">
      <el-menu-item index="4">我的购物车</el-menu-item>
    </router-link>
  </el-menu>
</template>

<script>
export default {
  name: 'SideBar',
  data () {
    return {
    }
  },
  methods: {
    switchPage (state) {
      this.$emit('checkOrderStateChanged', state)
    }
  }
}
</script>

<style scoped>

</style>
