var flow = browser.controlFlow();
var page = requireHelper('page');
var database = require('../database.js');

class LandingPage {
  constructor() {
    this.txt_mobile = element(by.model('username'));
    this.btn_get_otp = element(by.buttonText('Get Otp'));
    this.txt_otp = element(by.model('user.otp'));
    this.lnk_resend_otp = element(by.linkText('Re-Send OTP'));
    this.btn_verify = element(by.buttonText('Verify'));
    this.spinner = element(by.xpath('//span[@spinner-key="myspinner"]'));
    this.error_msg = element(by.binding('errorMsg'));
    this.invalid_url_error = element(by.xpath('//div[contains(@class,"text-danger")]/div'));
    this.merchant = element(by.xpath('//div[@class="transaction-details"]//p[1]/span'));
    this.ref_number = element(by.xpath('//div[@class="transaction-details"]//p[2]/span'));
    this.order_amount = element(by.xpath('//div[@class="transaction-details"]//p[3]/span'));
    this.convenience_charge = element(by.xpath('//div[@class="transaction-details"]//p[4]/span'));
    this.total_amount = element(by.xpath('//div[@class="transaction-details"]//p[5]/span'));
    this.lnk_cancel = element(by.linkText('Cancel'));
  }

  click_cancel_link() {
    this.lnk_cancel.click();
  }

  enter_otp(mobile) {
    var that = this;
    database.get_otp(mobile).then(function(result) {
      var otp = page.decode_base64(result.rows[0][0]);
      that.txt_otp.sendKeys(otp);
    })
  }

  click_get_otp_button() {
    this.btn_get_otp.click();
    page.wait_for_invisibility_of(this.spinner);
  }

  click_resend_otp_link() {
    this.lnk_resend_otp.click();
    page.wait_for_invisibility_of(this.spinner); 
  }

  authenticate(mobile) {
    this.txt_mobile.sendKeys(mobile);
    this.click_get_otp_button();
    this.enter_otp(mobile);
    this.btn_verify.click();
  }

  // DELETE ME : TEST FUNCTION
  call_timeout() {
    return flow.execute(function() {
      var deferred = protractor.promise.defer()
      setTimeout(function(){
        var a = "In am a!!"; 
        console.log("Hello");
        deferred.fulfill(a);
      }, 200);
      return deferred.promise;
    })
  }

  // DELETE ME : TEST FUNCTION
  display_hello() {
    return flow.execute(function() {
      var deferred = protractor.promise.defer()
      console.log("After Hello!!!");
      var otp = 123456789;
      deferred.fulfill(otp);
      return deferred.promise;
    })
  }
}

module.exports = new LandingPage();