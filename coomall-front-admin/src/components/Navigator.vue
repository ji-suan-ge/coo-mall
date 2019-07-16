<template>
  <div>
      <el-menu
        class="el-menu"
        @open="handleOpen"
        @close="handleClose"
        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">
        <router-link to="/platform">
          <el-menu-item index="1">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>平台概览</span>
            </template>
          </el-menu-item>
        </router-link>
        <router-link to="/customer">
          <el-menu-item index="2">
            <template slot="title">
              <i class="el-icon-edit-outline"></i>
              <span>用户管理</span>
            </template>
          </el-menu-item>
        </router-link>
        <router-link to="/merchant">
          <el-menu-item index="3">
            <template slot="title">
              <i class="el-icon-edit-outline"></i>
              <span>商家管理</span>
            </template>
          </el-menu-item>
        </router-link>
<!--        <router-link to="/add">-->
<!--          <el-menu-item index="4">-->
<!--            <template slot="title">-->
<!--              <i class="el-icon-edit-outline"></i>-->
<!--              <span>添加管理员</span>-->
<!--            </template>-->
<!--          </el-menu-item>-->
<!--        </router-link>-->
        <router-link to="/my">
          <el-menu-item index="4">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>个人中心</span>
            </template>
          </el-menu-item>
        </router-link>
      </el-menu>
  </div>
</template>

<script>
export default {
  name: 'Navigator',
  data () {
    return {}
  },
  methods: {
    handleOpen () {},
    handleClose () {}
  }
}
</script>

<style scoped>
  a {
    text-decoration: none;
  }
</style>
