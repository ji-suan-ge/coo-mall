<template>
  <el-container>
    <el-header style="padding: 0; background-color: #545c64;">
      <Header></Header>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <Navigator></Navigator>
      </el-aside>
      <el-main>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import Navigator from '../components/Navigator'
import Header from '../components/Header'
export default {
  components: {
    Header,
    Navigator: Navigator
  },
  methods: {
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>

<style scoped>
</style>
