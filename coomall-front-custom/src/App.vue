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
body {
  margin: 0;
}
</style>
