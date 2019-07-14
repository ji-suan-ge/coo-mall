<template>
  <el-container>
    <el-header id="header">
          <h2>商家登录</h2>
    </el-header>
    <el-row id="header_bottom_row"></el-row>
    <el-main id="main">
      <el-form :model="form" ref="form"
               label-position="right" label-width="100px" :rules="rules" >
        <el-row type="flex" justify="center">
          <el-form-item label="用户名" prop="userName">
            <el-input type="text" placeholder="请输入您的用户名"
                      v-model="form.userName" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row id="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="密码"  prop="password">
            <el-input type="password" placeholder="请输入您的密码"
                      v-model="form.password" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row id="input_bottom"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item>
            <el-button type="primary" id="bt_submit"
                       @click="onSubmit('form')" round>登录</el-button>
            <router-link to="/apply"><el-button round>申请</el-button></router-link>
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
        userName: '',
        password: ''
      },
      rules: {
        userName: [
          {required: true, message: '用户名不为空', trigger: 'blur'},
          {min: 2, max: 8, message: '长度在 2 到 8 个字符', trigger: 'blur'}
        ],
        password: [
          {required: true, message: '密码不为空', trigger: 'blur'},
          {min: 8, max: 16, message: '长度在 8 到 16 个字符', trigger: 'blur'}
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
      this.axios.post('/login', {
        userName: that.form.userName,
        password: that.form.password
      })
        .then(function (response) {
          if (response) {
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
    height: 20px
  }
  .input_width {
    width: 250px
  }
  #input_interval {
    height: 35px
  }
  #input_bottom {
    height: 30px
  }
  #bt_submit {
    margin-right: 44px
  }

</style>
