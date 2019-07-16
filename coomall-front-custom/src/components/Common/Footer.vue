<template>
  <el-col id="footerContainer">
    <el-col :offset="0" class="footer section text-center">
      <el-col class="footer" :span="16" :offset="4">
        <el-row>
          <el-col><hr></el-col>
        </el-row>
        <el-row class="footer_con">
          <el-col class="footer_con_wrap" :span="15" :offset="2">
            <el-row type="flex" justify="space-around">
              <el-col class="footer_attention" :span="2">
                <h4 class="title">关注我们</h4>
                <ul class="link_list">
                  <li><a href="#" title=""><i class="ico_wx"></i>微信</a></li>
                  <li><a href="#" title=""><i class="ico_sina"></i>新浪微博</a></li>
                </ul>
              </el-col>
              <el-col class="footer_joinus" :span="2">
                <h4 class="title">加入我们</h4>
                <ul class="link_list">
                  <li><a href="#" title="">社会招聘</a></li>
                </ul>
              </el-col>
              <el-col class="footer_contact" :span="2">
                <h4 class="title">联系我们</h4>
                <ul class="link_list">
                  <li><a href="#" title="">客户服务</a></li>
                  <li><a href="#" title="">合作洽谈</a></li>
                  <li><a href="#" title="">服务采购</a></li>
                </ul>
              </el-col>
              <el-col class="footer_legal" :span="2">
                <h4 class="title">法律信息</h4>
                <ul class="link_list">
                  <li><a href="#" title="">服务协议</a></li>
                  <li><a href="#">隐私政策</a></li>
                  <li><a href="#" title="">知识产权</a></li>
                </ul>
              </el-col>
            </el-row>
          </el-col>
        </el-row>
      </el-col>
    </el-col>
  </el-col>
</template>

<script>
export default {
  name: 'Footer'
}
</script>

<style scoped>
  #footerContainer {
    margin-top: 50px;
  }
  a {
    text-decoration: none;
  }
  li {
    text-decoration: none;
  }
  footer {
    padding: 0;
  }
  .footer_con {
    margin: 0;
    min-height: 275px;
    /** background: url(../images/global/footer_logo.png) right 100px no-repeat; **/
    position: relative;
  }

  .footer .footer_con_wrap {
    position: relative;
    padding-top: 35px;
    overflow: hidden;
  }
  .footer_attention, .footer_contact, .footer_joinus, .footer_more {
    float: left;
    min-height: 130px;
    padding-bottom: 24px;
  }
  .footer_attention, .footer_contact, .footer_joinus, .footer_more {
    float: left;
    min-height: 130px;
    padding-bottom: 24px;
  }
  .footer_contact {
    border-right: none;
  }

</style>
