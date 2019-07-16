<template>
  <el-container>
    <el-header class="login-header">
      <el-row>
        <el-col :span="4" :push="11">
          <img src="../assets/coo.png" />
        </el-col>
      </el-row>
    </el-header>
    <el-row id="header_bottom_row"></el-row>
    <el-main id="main">
      <el-form :model="form" ref="form"
               label-position="right" label-width="100px" :rules="rules" >
        <el-row type="flex" justify="center">
          <el-form-item label="手机号" prop="phone">
            <el-input type="text" placeholder="请输入您的手机号"
                      v-model="form.phone" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row id="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="密码"  prop="password">
            <el-input type="password" placeholder="请输入您的密码"
                      v-model="form.password" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row id="input_bottom" class="find">
          <el-col :span="3" :push="11">
            <router-link to="/register">注册账户</router-link>
          </el-col>
          <el-col :span="3" :push="10">
            <router-link to="/findPassword">找回密码？</router-link>
          </el-col>
        </el-row>
        <el-row type="flex" justify="center">
          <el-form-item>
            <el-button type="primary" id="bt_submit"
                       @click="onSubmit('form')" round>登录</el-button>
          </el-form-item>
        </el-row>
      </el-form>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'login',
  data () {
    return {
      form: {
        phone: '',
        password: ''
      },
      rules: {
        phone: [
          {required: true, message: '手机号不为空', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '密码不为空', trigger: 'blur'},
          {min: 1, max: 16, message: '长度在 1 到 16 个字符', trigger: 'blur'}
        ]
      }
    }
  },
  methods: {
    onSubmit: function (formName) {
      let that = this
      that.$refs[formName].validate((valid) => {
        if (valid) {
        } else {
          that.loginFailed()
          return false
        }
      })
      that.axios.post('/custom/login', {
        phoneNumber: that.form.phone,
        password: that.form.password
      })
        .then(function (response) {
          if (response.data.msg === '请求成功') {
            localStorage.setItem('custom', JSON.stringify(response.data.data))
            that.$message({
              type: 'success',
              message: '登陆成功！'
            })
            that.$router.push('/index')
          } else {
            that.loginFailed()
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    loginFailed () {
      this.$message.error('账号或密码错误！')
    }
  }
}
</script>

<style scoped>
  .login-header {
    margin-top: 200px;
    height: 200px;
    text-align: center
  }
  #header_bottom_row {
    height: 60px
  }
  .input_width {
    width: 250px
  }
  #input_interval {
    height: 35px
  }
  #input_bottom {
    height: 30px;
    margin-bottom: 10px;
  }
  #bt_submit {
    margin-right: 44px;
    width: 150px;
  }
  a {
    text-decoration: none;
  }
</style>
