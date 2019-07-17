<template>
  <el-container>
    <el-header id="header">
      <h2>修改密码</h2>
    </el-header>
    <el-row id="header_bottom_row"></el-row>
    <el-main id="main">
      <el-form :model="form" ref="form"
               label-position="right" label-width="100px" :rules="rules" >
        <el-row type="flex" justify="center">
          <el-form-item label="邮箱" prop="email">
            <el-input type="email" placeholder="请输入您的注册邮箱"
                      v-model="form.email" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="新密码"  prop="password">
            <el-input type="password" placeholder="请输入您的新密码"
                      v-model="form.password" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="确认密码"  prop="password2">
            <el-input type="password" placeholder="请再次输入您的密码"
                      v-model="form.password2" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="验证码"  prop="verifyCode">
            <el-input type="text" placeholder="请输入验证码" class="verifyCode"
                      v-model="form.verifyCode"></el-input>
            <el-button type="success" @click="getVerifyCode()" size="mini">获取邮箱验证码</el-button>
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
    var validatePass2 = (rule, value, callback) => {
      if (value !== this.form.password) {
        callback(new Error('两次密码不一致'))
      }
    }
    return {
      form: {
        email: '',
        password: '',
        password2: '',
        verifyCode: ''
      },
      rules: {
        email: [
          {required: true, message: '邮箱不为空', trigger: 'blur'},
          {type: 'email', message: '邮箱格式错误，请输入有效的邮箱', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '密码不为空', trigger: 'blur'},
          {min: 8, max: 16, message: '密码长度在 8 到 16 个字符', trigger: 'blur'}
        ],
        password2: [
          {required: true, message: '密码不为空', trigger: 'blur'},
          {min: 8, max: 16, message: '密码长度在 8 到 16 个字符', trigger: 'blur'},
          {validator: validatePass2, trigger: 'blur'}
        ],
        verifyCode: [
          {required: true, message: '邮箱验证码不为空', trigger: 'blur'},
          {pattern: /^([0-9a-zA-Z]){4}$/, message: '邮箱验证码组成为4位,字母和数字的组合', trigger: 'blur'}
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
          that.$message({
            type: 'error',
            message: '信息输入不正确，请按提示输入信息',
            center: true}
          )
          return false
        }
      })
      that.axios.post('/merchant/editPassword', {
        emailCode: that.form.verifyCode,
        newPassword: that.form.password
      })
        .then(function (response) {
          if (response.data.code === '0000') {
            that.$message(
              {
                type: 'success',
                message: '修改成功，请使用新密码登录'
              }
            )
            that.$router.push('/login')
          } else {
            that.$message(
              {
                type: 'error',
                message: response.data.msg
              }
            )
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    getVerifyCode () {
      let that = this
      that.axios.post('/getEmailCode', {
        email: that.form.email
      })
        .then(function (response) {
          if (response.data.code === '4501') {
            that.$message(
              {
                type: 'error',
                message: '邮箱不存在'
              })
          } else if (response.data.code === '0000') {
            that.$message(
              {
                type: 'success',
                message: '验证码已发送，请查看邮箱'
              }
            )
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
    margin-top: 50px;
    height: 200px;
    text-align: center
  }
  #header_bottom_row {
    height: 40px
  }
  .input_width {
    width: 250px;
    margin-bottom: 10px;
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
    width: 135px;
  }
</style>
