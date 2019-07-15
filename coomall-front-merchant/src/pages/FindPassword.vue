<template>
  <el-container>
    <el-header id="header">
      <h2>找回密码</h2>
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
        <el-row type="flex" justify="center">
          <el-form-item label="新密码"  prop="password">
            <el-input type="password" placeholder="请输入您的密码"
                      v-model="form.password" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="确认密码"  prop="password2">
            <el-input type="password" placeholder="请再次输入您的密码"
                      v-model="form.password" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="验证码"  prop="verifyCode">
            <el-input type="text" placeholder="请输入验证码" class="verifyCode"
                      v-model="form.verifyCode"></el-input>
            <el-button type="success" size="mini">获取验证码</el-button>
          </el-form-item>
        </el-row>
        <el-row type="flex" justify="center">
          <el-form-item>
            <el-button type="primary" id="bt_submit"
                       @click="onSubmit('form')" round>确认</el-button>
          </el-form-item>
        </el-row>
      </el-form>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'findPassword',
  data () {
    return {
      form: {
        phone: '',
        password: '',
        password2: '',
        verifyCode: ''
      },
      rules: {
        phone: [
          {required: true, message: '手机号不为空', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '密码不为空', trigger: 'blur'},
          {min: 8, max: 16, message: '长度在 8 到 16 个字符', trigger: 'blur'}
        ],
        password2: [
          {required: true, message: '密码不为空', trigger: 'blur'},
          {min: 8, max: 16, message: '长度在 8 到 16 个字符', trigger: 'blur'}
        ],
        verifyCode: [
          {required: true, message: '验证码不为空', trigger: 'blur'},
          {min: 6, max: 6, message: '组成为6个数字', trigger: 'blur'}
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
          alert('用户名或密码格式不正确')
          return false
        }
      })
      this.axios.post('/merchant/login', {
        phoneNumber: that.form.phone,
        password: that.form.password
      })
        .then(function (response) {
          if (response.data != null) {
            this.$router.push('/homePage')
          } else {
            alert('用户名或密码错误')
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  }
}
</script>

<style>
  #header {
    margin-top: 100px;
    height: 200px;
    text-align: center
  }
  #header_bottom_row {
    height: 40px
  }
  .input_width {
    width: 250px;
    margin-bottom: 20px;
  }
  #bt_submit {
    margin-right: 44px;
    width: 150px;
    margin-top: 20px;
  }
  a {
    text-decoration: none;
  }
  .verifyCode {
    width: 153px;
  }
</style>
