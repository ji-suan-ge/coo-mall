<template>
  <el-container class="container">
    <el-header class="header">
      <el-row>
        <el-col>
          <h3>我的信息</h3>
        </el-col>
      </el-row>
    </el-header>
    <el-main class="main">
      <el-row >
        <div class="row">
          <el-col :span="3">昵称:</el-col>
          <el-col :span="6">
            <el-input v-model="custom.nickname"
                      class="inputEmail"></el-input>
          </el-col>
        </div>
      </el-row>

      <el-row>
        <div class="row">
          <el-col :span="3">性别:</el-col>
          <el-col :span="6">
            <el-radio-group v-model="state">
              <el-radio class="radioGender" label="0" @change="test(0)">男</el-radio>
              <el-radio class="radioGender" label="1" @change="test(1)">女</el-radio>
            </el-radio-group>
          </el-col>
        </div>
      </el-row>

      <el-row>
        <div class="row">
          <el-col :span="3">手机号:</el-col>
          <el-col :span="6">
            <el-input v-model="custom.phoneNumber"
                      class="inputEmail"></el-input>
          </el-col>
        </div>
      </el-row>

      <el-row>
        <div class="row">
          <el-col :span="3">电子邮箱:</el-col>
          <el-col :span="6">
            <el-input v-model="custom.email"
                      class="inputEmail"></el-input>
          </el-col>
        </div>
      </el-row>

    </el-main>
    <el-row>
      <el-col :span="6" :offset="3">
        <el-button style="background-color: #777777; color: #ffffff" @click="modify" round>保存</el-button>
      </el-col>
    </el-row>
  </el-container>
</template>

<script>
export default {
  name: 'personalInfo',
  data () {
    return {
      custom: JSON.parse(localStorage.getItem('custom')),
      state: null
    }
  },
  methods: {
    modify () {
      let that = this
      that.custom.gender = parseInt(this.state)
      that.axios.post('/custom/edit', that.custom)
        .then(function (response) {
          if (response.data.code === '0000') {
            localStorage.setItem('custom', JSON.stringify(that.custom))
            that.$message({message: '信息修改成功', type: 'success'})
          } else {
            that.$message.error('系统繁忙，稍后重试')
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    test (val) {
      // this.custom.gender = parseInt(val)
      // this.state = val
      console.log(this.state)
    }
  },
  created () {
    this.state = this.custom.gender.toString()
  }
}
</script>

<style scoped>
  hr {
    color: gray;
  }
  .row {
    height: 40px;
    color: gray;
    margin-top: 10px;
    vertical-align: middle;
  }
  .header {
    height: 100px;
  }
  .container {
    height: 100%;
    width: 100%;
  }
  .inputEmail {
    height: 30px;
    width: 180px;
    margin-bottom: 10px;
  }
  .inputAddress {
    height: 30px;
    width: 300px;
    margin-bottom: 10px;
  }
  .main {
    text-align: left;
  }
  .inputIntroduce {
    width: 400px;
  }
</style>
