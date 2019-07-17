<template>
  <el-container>
    <el-header id="header">
      <h2>申请开店</h2>
    </el-header>
    <el-row id="header_bottom_row"></el-row>
    <el-main id="main">
      <el-form label-position="right" label-width="100px"
               ref="form" :model="form" :rules="rules">
        <el-row class="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="用户名" prop="nickname">
            <el-input type="text" placeholder="请输入您的用户名"
                      v-model="form.nickname" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row type="flex" justify="center">
            <el-form-item label="性别" prop="gender">
            <el-radio-group v-model="form.gender" class="myRadio">
              <el-radio label="男"></el-radio>
              <el-radio label="女"></el-radio>
            </el-radio-group>
          </el-form-item>
        </el-row>
        <el-row class="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="手机号" prop="phoneNumber">
            <el-input type="text" placeholder="请输入您的手机号"
                      v-model="form.phoneNumber" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row class="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="密码" prop="password">
            <el-input type="password" placeholder="请输入您的密码"
                      v-model="form.password" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row class="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="邮箱" prop="email">
            <el-input type="text" placeholder="请输入您的邮箱"
                      v-model="form.email" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="验证码"  prop="verifyCode">
            <el-input type="text" placeholder="请输入验证码" class="verifyCode"
                      v-model="form.verifyCode"></el-input>
            <el-button type="success" @click="getVerifyCode()" size="mini">获取邮箱验证码</el-button>
          </el-form-item>
        </el-row>
        <el-row class="input_interval"></el-row>
        <el-row id="input_bottom"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item>
            <el-button type="primary" id="bt_submit"
                       @click="onSubmit('form')" round>注册</el-button>
          </el-form-item>
        </el-row>
      </el-form>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'Register',
  data () {
    return {
      form: {
        nickname: '',
        gender: '',
        phoneNumber: '',
        avatar: '',
        password: '',
        email: ''
      },
      rules: {
        nickname: [
          {required: true, message: '用户名不为空', trigger: 'blur'},
          {required: true, message: '用户名不为空', trigger: 'change'}
        ],
        gender: [
          {required: true, message: '请选择性别', trigger: 'change'}
        ],
        phoneNumber: [
          {required: true, message: '手机号不能为空', trigger: 'blur'},
          {required: true, message: '手机号不能为空', trigger: 'change'},
          {pattern: /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/, message: '手机号不存在，请输入有效的手机号', trigger: 'blur'},
          {pattern: /^1([38][0-9]|4[579]|5[0-3,5-9]|6[6]|7[0135678]|9[89])\d{8}$/, message: '手机号不存在，请输入有效的手机号', trigger: 'change'}
        ],
        password: [
          {required: true, message: '密码不能为空', trigger: 'blur'},
          {required: true, message: '密码不能为空', trigger: 'change'},
          {min: 8, max: 16, message: '密码长度在 8 到 16 个字符', trigger: 'blur'},
          {min: 8, max: 16, message: '密码长度在 8 到 16 个字符', trigger: 'change'}
        ],
        email: [
          {required: true, message: '邮箱不能为空', trigger: 'blur'},
          {required: true, message: '邮箱不能为空', trigger: 'change'},
          {type: 'email', message: '请输入有效的邮箱地址', trigger: 'blur'},
          {type: 'email', message: '请输入有效的邮箱地址', trigger: 'change'}
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
            message: '信息未正确输入'
          })
          return false
        }
      })
      if (that.form.gender === '男') {
        that.form.gender = 0
      } else if (that.form.gender === '女') {
        that.form.gender = 1
      }
      that.axios.post('/custom/editPassword', {
        emailCode: that.form.verifyCode,
        newPassword: 'testtest'
      })
        .then(function (response) {
          if (response.data.code === '0000') {
            that.axios.post('/custom/add', {
              nickname: that.form.nickname,
              gender: that.form.gender,
              phoneNumber: that.form.phoneNumber,
              avatar: that.form.avatar,
              password: that.form.password,
              email: 'hello'
            })
              .then(function (response) {
                if (response.data.msg === '请求成功') {
                  that.$message({
                    type: 'success',
                    message: '注册成功，请登录'
                  })
                  that.$router.push('/login')
                } else {
                  that.$message({
                    type: 'error',
                    message: '系统繁忙，稍后重试'
                  })
                }
              })
              .catch(function (error) {
                console.log(error)
              })
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

<style scoped>
  #header {
    margin-top: 20px;
    height: 100px;
    text-align: center
  }
  #header_bottom_row {
    height: 20px
  }
  #main {
    text-align: center
  }
  .input_width {
    width: 250px;
    margin-left: 20px
  }
  .input_interval {
    height: 15px
  }
  #input_bottom {
    height: 30px
  }
  #bt_submit {
    margin-right: 44px
  }
  .verifyCode {
    width: 130px;
    margin-left: 20px
  }
</style>
