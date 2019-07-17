<template>
  <el-container>
    <el-header style="padding: 0;"><TopBar></TopBar></el-header>
    <el-main><router-view></router-view></el-main>
    <el-footer><Footer></Footer></el-footer>
  </el-container>
</template>

<script>
import TopBar from '../components/Common/TopBar'
import Footer from '../components/Common/Footer'
export default {
  name: 'Product',
  components: {Footer, TopBar}
}
</script>

<style scoped>

</style>
