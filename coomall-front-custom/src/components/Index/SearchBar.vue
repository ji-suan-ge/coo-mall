<template>
  <el-row>
    <el-row id="searchBar">
      <el-col :span="1" :offset="8">
        <el-dropdown @command="selectSearchType">
          <span class="el-dropdown-link">
            <span v-text="searchTypeStr"></span>
<!--            <i class="el-icon-arrow-down el-icon&#45;&#45;right"></i>-->
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="0">搜索商品</el-dropdown-item>
<!--            <el-dropdown-item command="1">店铺</el-dropdown-item>-->
<!--            <el-dropdown-item command="2">用户</el-dropdown-item>-->
          </el-dropdown-menu>
        </el-dropdown>
      </el-col>
      <el-col :span="6">
        <el-input placeholder="请输入关键词" v-model="keyword"></el-input>
      </el-col>
      <el-col :span="3">
        <el-button @click="search()">搜索</el-button>
      </el-col>
    </el-row>
  </el-row>
</template>

<script>
export default {
  name: 'Search',
  props: ['currentPage'],
  data: function () {
    return {
      resultList: [],
      searchType: '0',
      keyword: '',
      limit: 28
    }
  },
  methods: {
    selectSearchType (command) {
      console.log(command)
      this.searchType = command
    },
    search () {
      let that = this
      this.axios.post('/product/search', {
        keyword: that.keyword,
        currentPage: that.currentPage,
        limit: that.limit
      }).then(res => {
        console.log('submit productLst in searchBar')
        this.$emit('submitData', {
          productList: res.data.data.productList,
          totalPage: res.data.data.totalPage
        })
        this.$router.push({
          path: `/index/result`
        })
      })
    }
  },
  computed: {
    searchTypeStr () {
      switch (this.searchType) {
        case '0':
          return '搜索商品'
        case '1':
          return '店铺'
        case '2':
          return '用户'
      }
    }
  },
  watch: {
    keyword () {
      console.log('keyword in searchBar changed')
      this.search()
    },
    currentPage () {
      console.log('currentPage in searchBar changed')
      this.search()
    }
  },
  created () {
  }
}
</script>

<style scoped>
  #searchBar {
    display: flex;
    align-items: center;
    padding-top: 50px;
  }
</style>
