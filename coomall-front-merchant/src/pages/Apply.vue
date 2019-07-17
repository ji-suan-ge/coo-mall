<template>
  <el-container>
    <el-header id="header">
      <h2>申请开店</h2>
    </el-header>
    <el-row id="header_bottom_row"></el-row>
    <el-main id="main">
      <el-form label-position="right" label-width="100px"
               ref="form" :model="form" :rules="rules">
        <el-row type="flex" justify="center">
          <el-form-item label="商铺名" prop="storeName">
            <el-input type="text" placeholder="请输入您的商铺名"
                      v-model="form.storeName" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row class="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="姓名" prop="name">
            <el-input type="text" placeholder="请输入您的真实姓名"
                      v-model="form.name" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row class="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="手机号" prop="phone">
            <el-input type="text" placeholder="请输入您的手机号"
                      v-model="form.phone" class="input_width"></el-input>
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
          <el-form-item label="邮箱" prop="mail">
            <el-input type="text" placeholder="请输入您的邮箱"
                      v-model="form.mail" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row class="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="验证码"  prop="verifyCode">
            <el-input type="text" placeholder="请输入验证码" class="verifyCode"
                      v-model="form.verifyCode"></el-input>
            <el-button type="success" @click="getVerifyCode()" size="mini">获取邮箱验证码</el-button>
          </el-form-item>
        </el-row>
        <el-row class="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="家庭住址" prop="address">
            <el-input type="text" placeholder="请输入您的家庭住址"
                      v-model="form.address" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row class="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="身份证号" prop="IDNumber">
            <el-input type="text" placeholder="请输入您的身份证号"
                      v-model="form.IDNumber" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row class="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="简介" prop="introduce">
            <el-input type="textarea" :rows="6" placeholder="请输入您的简介（选填）"
                      v-model="form.introduce" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row id="input_bottom"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item>
            <el-button type="primary" id="bt_submit"
                       @click="onSubmit('form')" round>申请</el-button>
          </el-form-item>
        </el-row>
      </el-form>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'apply',
  data () {
    return {
      form: {
        storeName: '',
        name: '',
        phone: '',
        password: '',
        mail: '',
        verifyCode: '',
        address: '',
        IDNumber: '',
        introduce: '',
        IDphoto: ''
      },
      rules: {
        storeName: [
          {required: true, message: '商铺名不为空', trigger: 'blur'},
          {required: true, message: '商铺名不为空', trigger: 'change'},
          {min: 2, max: 8, message: '商铺名长为2至10', trigger: 'blur'},
          {min: 2, max: 8, message: '商铺名长为2至10', trigger: 'change'}
        ],
        name: [
          {required: true, message: '姓名不为空', trigger: 'blur'},
          {required: true, message: '姓名不为空', trigger: 'change'},
          {pattern: /^[\u4e00-\u9fa5]{2,6}$/, message: '姓名需要符合规范，请输入真实姓名', trigger: 'blur'},
          {pattern: /^[\u4e00-\u9fa5]{2,6}$/, message: '姓名需要符合规范，请输入真实姓名', trigger: 'change'}
        ],
        phone: [
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
        mail: [
          {required: true, message: '邮箱不能为空', trigger: 'blur'},
          {required: true, message: '邮箱不能为空', trigger: 'change'},
          {type: 'email', message: '请输入有效的邮箱地址', trigger: 'blur'},
          {type: 'email', message: '请输入有效的邮箱地址', trigger: 'change'}
        ],
        verifyCode: [
          {required: true, message: '邮箱验证码不为空', trigger: 'blur'},
          {pattern: /^([0-9a-zA-Z]){4}$/, message: '邮箱验证码组成为4位,字母和数字的组合', trigger: 'blur'}
        ],
        address: [
          {required: true, message: '家庭住址不能为空', trigger: 'blur'},
          {required: true, message: '家庭住址不能为空', trigger: 'change'},
          {pattern: /^[\u4e00-\u9fa5]{5,30}$/, message: '请输入有效的地址，长度为5-30个汉字', trigger: 'blur'},
          {pattern: /^[\u4e00-\u9fa5]{5,30}$/, message: '请输入有效的地址，长度为5-30个汉字', trigger: 'change'}
        ],
        IDNumber: [
          {required: true, message: '身份证号不能为空', trigger: 'blur'},
          {required: true, message: '身份证号不能为空', trigger: 'change'},
          {pattern: /^([1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx]))$/,
            message: '请输入18位有效的身份证号',
            trigger: 'blur'},
          {pattern: /^([1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx]))$/,
            message: '请输入18位有效的身份证号',
            trigger: 'change'}
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
      that.axios.post('/custom/editPassword', {
        emailCode: that.form.verifyCode,
        newPassword: 'testtest'
      })
        .then(function (response) {
          if (response.data.code === '0000') {
            that.axios.post('/merchant/add', {
              shopName: that.form.storeName,
              ownerName: that.form.name,
              phoneNumber: that.form.phone,
              password: that.form.password,
              email: that.form.mail,
              address: that.form.address,
              identityNumber: that.form.IDNumber,
              intro: that.form.introduce,
              identityPhoto: 'test'
            })
              .then(function (response) {
                if (response.data.msg === '请求成功') {
                  that.$message({
                    type: 'success',
                    message: '申请成功，正在等待审批'
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
        email: that.form.mail
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
