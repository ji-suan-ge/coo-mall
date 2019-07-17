<template>
  <div>
    <el-table :data="productInfo" max-height="100%"
              :fit="true" :row-style="rowStyle" id="productInfo" stripe>
      <el-table-column prop="id"
                       class="table_row" label="商品编号"></el-table-column>
      <el-table-column prop="name"
                       class="table_row" label="商品名称"></el-table-column>
      <el-table-column prop="price"
                       class="table_row" label="商品价格"></el-table-column>
      <el-table-column prop="quantity"
                       class="table_row" label="商品库存"></el-table-column>
      <el-table-column prop="sale"
                       class="table_row" label="月销量"></el-table-column>
      <el-table-column class="table_row" label="分类">
        <template slot-scope="scope">
          <el-select v-model="productInfo[scope.$index].category" placeholder="请选择" disabled>
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </template>
      </el-table-column>
      <el-table-column prop="state"
                       class="table_row" label="商品状态"></el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="140"
        class="button_row">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="modifyBasic(scope.$index, scope.row)">修改基本信息</el-button>
          <el-button type="text" size="small" @click="modifyStyle(scope.$index, scope.row)">添加商品款式</el-button>
          <el-button type="text" size="small" @click="modifyDetail(scope.$index, scope.row)">修改详细信息</el-button>
          <el-button type="text" size="small" @click="del(scope.$index, scope.row)">商品下架</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-row class="table_bottom"></el-row>
    <el-pagination
      @current-change="handleCurrentChange"
      :page-size="20"
      layout="prev, pager, next, jumper"
      :total="total">
    </el-pagination>
  </div>
</template>

<script>
export default {
  name: 'productsManage',
  data () {
    return {
      productInfo: [{
        id: '',
        name: '',
        price: '',
        quantity: '',
        sale: '',
        category: '',
        pattern: '',
        detail: '',
        state: ''
      }],
      rowStyle: {
        height: '50px'
      },
      merchant: JSON.parse(localStorage.getItem('merchant')),
      total: 1,
      options: [{
        value: 1,
        label: '电子产品'
      }, {
        value: 2,
        label: '食品'
      }, {
        value: 3,
        label: '服饰'
      }, {
        value: 4,
        label: '化妆品'
      }, {
        value: 5,
        label: '家电'
      }, {
        value: 6,
        label: '图书'
      }, {
        value: 7,
        label: '百货'
      }]
    }
  },
  created () {
    let that = this
    that.axios.post('/product/getByMerchantID', {
      merchantID: that.merchant.id,
      currentPage: 1,
      limit: 20
    })
      .then(function (response) {
        if (response.data.msg === '请求成功') {
          that.total = parseInt(response.data.data.totalPage) * 20
          that.productInfo = response.data.data.productList
          for (var p in that.productInfo) {
            that.productInfo[p].state = '已上架'
          }
        } else {
          that.$message({
            type: 'error',
            message: '系统繁忙，请求数据失败！'
          })
        }
      })
      .catch(function (error) {
        console.log(error)
      })
  },
  methods: {
    handleCurrentChange (cur) {
      let that = this
      that.axios.post('/product/getByMerchantID', {
        merchantID: that.merchant.id,
        currentPage: cur,
        limit: 20
      })
        .then(function (response) {
          if (response.data.msg === '请求成功') {
            that.total = parseInt(response.data.data.totalPage) * 20
            that.productInfo = response.data.data.productList
            for (var p in that.productInfo) {
              that.productInfo[p].state = '已上架'
            }
          } else {
            that.$message({
              type: 'error',
              message: '系统繁忙，请求数据失败！'
            })
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    del (index, row) {
      let that = this
      that.axios.post('/product/remove', {
        productID: row.id
      })
        .then(function (response) {
          if (response.data.msg === '请求成功') {
            that.$message({
              type: 'success',
              message: '下架成功！'
            })
            that.$router.go(0)
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    modifyBasic (index, row) {
      let that = this
      that.productInfo = row
      this.$emit('submitData', row)
      that.$router.push('/homePage/modifyProduct')
    },
    modifyStyle (index, row) {
      let that = this
      that.productInfo = row
      this.$emit('submitData', row)
      that.$router.push('/homePage/modifyStyle')
    },
    modifyDetail (index, row) {
      let that = this
      that.productInfo = row
      this.$emit('submitData', row)
      that.$router.push('/homePage/modifyDetail')
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
  }
  .table_bottom {
    height: 40px;
  }
  .el-button {
    margin-left: 0;
  }
</style>
