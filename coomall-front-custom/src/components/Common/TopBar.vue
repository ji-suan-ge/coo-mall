<template>
  <div>
    <el-menu class="el-menu-demo" mode="horizontal" v-show="showStatus==='tourist'"
      background-color="#777777"
      text-color="#ffffff">
      <el-menu-item index="1">咕~，欢迎来咕咕商城</el-menu-item>
      <el-menu-item index="2">
        <span @click="toIndex">咕咕首页</span>
      </el-menu-item>
      <el-menu-item index="3" style="float: right;">
        <router-link to="/login" style="text-decoration: none">登录</router-link>
      </el-menu-item>
      <el-menu-item index="4" style="float: right;">
        <router-link to="/register" style="text-decoration: none">注册</router-link>
      </el-menu-item>
    </el-menu>
    <el-menu class="el-menu-demo" mode="horizontal" v-show="showStatus==='custom'"
       background-color="#777777"
      text-color="#ffffff">
      <el-menu-item index="1">咕~，欢迎来咕咕商城</el-menu-item>
      <el-menu-item index="2">
        <span @click="toIndex">咕咕首页</span>
      </el-menu-item>
      <el-menu-item index="3" style="float: right;">
        <router-link to="/user" style="text-decoration: none" v-text="custom!=null&&custom.nickname"></router-link>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: 'topBar',
  data () {
    return {
      showStatus: null,
      custom: null
    }
  },
  methods: {
    toIndex () {
      this.$router.replace({
        path: '/'
      })
    }
  },
  created () {
    let tmp = localStorage.getItem('custom')
    if (tmp === null) {
      this.showStatus = 'tourist'
    } else {
      this.custom = JSON.parse(tmp)
      this.showStatus = 'custom'
    }
    console.log('当前TabBar状态:' + this.showStatus + '\n当前登录用户:' + this.custom.toString())
  }
}
</script>

<style scoped>

</style>
