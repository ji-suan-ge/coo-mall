<template>
  <footer class="footer section text-center">
    <div class="footer">
      <div class="footer_con">
        <div class="footer_con_wrap">
          <div class="footer_attention">
            <h4 class="title">关注我们</h4>
            <ul class="link_list">
              <li><a href="#" title=""><i class="ico_wx"></i>微信</a></li>
              <li><a href="#" title=""><i class="ico_sina"></i>新浪微博</a></li>
            </ul>
          </div>
          <div class="footer_joinus">
            <h4 class="title">加入我们</h4>
            <ul class="link_list">
              <li><a href="#" title="">社会招聘</a></li>
            </ul>
          </div>
          <div class="footer_contact">
            <h4 class="title">联系我们</h4>
            <ul class="link_list">
              <li><a href="#" title="">客户服务</a></li>
              <li><a href="#" title="">合作洽谈</a></li>
              <li><a href="#" title="">服务采购</a></li>
            </ul>
          </div>
          <div class="footer_legal">
            <h4 class="title">法律信息</h4>
            <ul class="link_list">
              <li><a href="#" title="">服务协议</a></li>
              <li><a href="#">隐私政策</a></li>
              <li><a href="#" title="">知识产权</a></li>
            </ul>
          </div>
        </div>
        <div class="footer_wx_layer">
          <div class="wx_account">
            <div class="account_image">
            </div>
            <div class="account_close">
            </div>
          </div>
        </div>
        <div class="footer_copyright">
          Copyright
        </div>
      </div>
    </div>
  </footer>
</template>

<script>
export default {
  name: 'Footer'
}
</script>

<style scoped>
  footer {
    width: 100%;
    background: #ecf0f1;
    padding: 0;
  }
  .footer_con {
    margin: 0 auto;
    width: 1200px;
    min-height: 275px;
    _height: 275px;
    /** background: url(../images/global/footer_logo.png) right 100px no-repeat; **/
    position: relative;
  }

  .footer .footer_con_wrap {
    position: relative;
    padding-top: 35px;
    overflow: hidden;
  }
  .footer_attention, .footer_more {
    width: 168px;
  }
  .footer_attention, .footer_contact, .footer_joinus, .footer_more {
    float: left;
    min-height: 130px;
    padding-bottom: 24px;
    padding-left: 15px;
  }
  .footer_contact, .footer_joinus {
    width: 168px;
    padding-left: 5px;
  }
  .footer_attention, .footer_contact, .footer_joinus, .footer_more {
    float: left;
    min-height: 130px;
    padding-bottom: 24px;
    padding-left: 15px;
  }
  .footer_contact {
    border-right: none;
  }
  .footer_copyright {
    float: right;
    padding-left: 20px;
    margin-left: 150px;
    color: #747b81;
  }
  .footer_copyright, .footer_links {
    padding-top: 18px;
    font-size: 14px;
  }
  .footer_links {
    float: left;
    padding-left: 15px;
    color: #747b81;
  }
  .footer_copyright, .footer_links {
    padding-top: 18px;
    font-size: 14px;
  }
</style>
