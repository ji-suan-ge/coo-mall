<template>
  <el-table :data="productInfo" max-height="100%"
            :row-style="rowStyle" id="productInfo" stripe>
    <el-table-column class="table_row" label="商品编号">
      <template slot-scope="scope">
        <el-input type="text" v-model="productInfo[scope.$index].id" class="input_width" disabled></el-input>
      </template>
    </el-table-column>
    <el-table-column class="table_row" label="商品名称">
      <template slot-scope="scope">
        <el-input type="text" v-model="productInfo[scope.$index].name" class="input_width" disabled></el-input>
      </template>
    </el-table-column>
    <el-table-column class="table_row" label="商品款式">
      <template slot-scope="scope">
        <el-input type="textarea" rows="6" v-model="style" id="input_style"></el-input>
      </template>
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="150">
      <template slot-scope="scope">
        <el-button type="primary" size="small" @click="modify(scope.$index, scope.row)">保存修改</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>
<script>
export default {
  name: 'modifyStyle',
  props: ['productFromFather'],
  data () {
    return {
      productInfo: [{
        name: '',
        price: '',
        quantity: '',
        category: '',
        detail: '',
        avatar: ''
      }],
      rowStyle: {
        height: '200px'
      },
      style: ''
    }
  },
  created () {
    let that = this
    that.productInfo = [that.productFromFather]
  },
  methods: {
    modify (index, row) {
      let that = this
      that.axios.post('/product/addStyle', {
        productID: that.productInfo[index].id,
        style: that.style
      })
        .then(function (response) {
          if (response.data.msg === '请求成功') {
            that.$message({
              type: 'success',
              message: '保存成功'
            })
            that.$router.go(-1)
          } else {
            that.$message({
              type: 'error',
              message: '系统繁忙。稍后重试'
            })
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
  #productInfo {
    width: 100%;
    text-align: center;
  }
  .table_row {
    vertical-align: top;
  }
  .input_width {
    width: 180px;
  }
  #input_style {
    width: 200px;
  }
</style>
