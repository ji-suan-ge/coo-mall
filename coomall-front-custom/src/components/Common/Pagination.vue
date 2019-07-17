<template>
  <el-row id="paginationContainer"  type="flex" justify="center">
      <el-pagination
        background
        layout="prev, pager, next"
        :page-size=32
        :page-count="totalPage"
      @current-change="changeCurrent">
      </el-pagination>
  </el-row>
</template>

<script>
export default {
  name: 'Pagination',
  props: ['totalPage'],
  data: function () {
    return {
      currentPage: 1,
      limit: 32
    }
  },
  methods: {
    changeCurrent (currentPage) {
      this.currentPage = currentPage
    }
  },
  watch: {
    currentPage () {
      console.log('submit currentPage in pagination')
      this.$emit('submitData', this.currentPage)
    }
  }
}
</script>

<style scoped>
#paginationContainer {
  margin-top: 30px;
}
</style>
