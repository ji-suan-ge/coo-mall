<template>
<el-container>
  <el-header style="padding: 0"><TopBar></TopBar></el-header>
  <el-container>
    <el-aside width="200px"><SideBar v-on:checkOrderStateChanged="getStateFromSideBar"></SideBar></el-aside>
    <el-main><router-view v-bind:state="checkOrderState"></router-view></el-main>
  </el-container>
  <el-footer><Footer></Footer></el-footer>
</el-container>
</template>

<script>
import SideBar from '../components/User/SideBar'
import TopBar from '../components/Common/TopBar'
import Footer from '../components/Common/Footer'
export default {
  name: 'User',
  components: {Footer, TopBar, SideBar},
  data () {
    return {
      checkOrderState: null
    }
  },
  methods: {
    getStateFromSideBar (state) {
      this.checkOrderState = state
    }
  }
}
</script>

<style scoped>

</style>
