<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
  data: function () {
    return {}
  },
  methods: {
  },
  created () {
    let that = this
    that.axios.post('/admin/login', {
      phoneNumber: '18226331573',
      password: 'gxw'
    })
      .then(function (response) {
        console.log(response)
      })
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
