<template>
  <div>
    <el-menu class="el-menu-demo" mode="horizontal" v-show="showStatus==='tourist'"
      background-color="#777777"
      text-color="#ffffff"
      :router="true">
      <el-menu-item index="/index/recommend">咕~，欢迎来咕咕商城</el-menu-item>
      <el-menu-item index="/login" style="float: right;">登录</el-menu-item>
      <el-menu-item index="/register" style="float: right;">注册</el-menu-item>
    </el-menu>
    <el-menu class="el-menu-demo" mode="horizontal" v-show="showStatus==='custom'"
       background-color="#777777"
      text-color="#ffffff"
      :router="true">
      <el-menu-item index="/index/recommend">咕~，欢迎来咕咕商城</el-menu-item>
<!--      <el-button style="float: right; background-color: #777; color: #fff; border: 0; height: 60px;">登出</el-button>-->
      <el-menu-item @click="logout" style="float: right;">
        <span>登出</span>
      </el-menu-item>
      <el-menu-item index="/User/PersonalInfo" style="float: right;">
        <span v-text="custom == null ? '' : custom.nickname"></span>
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
    logout () {
      let that = this
      that.axios.post('/custom/logout').then(res => {
        if (res.data.code === '0000') {
          that.$message({
            type: 'success',
            message: '登出成功！'
          })
          localStorage.removeItem('custom')
          that.custom = null
          that.showStatus = 'tourist'
          that.$router.push({
            name: 'recommend'
          })
        }
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
