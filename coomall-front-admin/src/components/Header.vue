<template>
  <div class="homepage-header">
    <span style="font-size: 30px">咕咕商城管理系统</span>
    <el-button style="font-size: 15px; float: right; margin: 10px 25px" @click="logout">退出登录</el-button>
    <span style="font-size: 16px; float: right;margin: 20px 25px">管理员： {{ admin.name }}</span>
  </div>
</template>

<script>
export default {
  name: 'Header',
  data () {
    return {
      admin: null
    }
  },
  created () {
    this.admin = JSON.parse(localStorage.getItem('admin'))
    console.log(this.admin)
  },
  methods: {
    logout () {
      let that = this
      this.axios.post('/admin/logout').then(
        res => {
          if (res.data.code === '0000') {
            that.$message({
              type: 'success',
              message: '登出成功！'
            })
            localStorage.removeItem('admin')
            that.$router.push('/login')
          }
        }
      )
    }
  }
}
</script>

<style scoped>
  .homepage-header {
    background-color: #545c64;
    text-align: center;
  }
</style>
