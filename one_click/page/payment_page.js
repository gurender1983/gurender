var page = requireHelper('page');

class PaymentPage {
  constructor() {
    this.btn_pay_now = element(by.buttonText('Pay Now'));
    this.txt_mPin1 = element(by.model('mpin.mpin1'));
    this.txt_mPin2 = element(by.model('mpin.mpin2'));
    this.txt_mPin3 = element(by.model('mpin.mpin3'));
    this.txt_mPin4 = element(by.model('mpin.mpin4'));
    this.lnk_forgot_mpin = element(by.linkText('Forgot mPin'));
    this.error = element(by.xpath('//div[contains(@class, "show-error")]'));
    this.lnk_cancel = element(by.linkText('Cancel'));
  }

  enter_mPin(data) {
  	if (data.mpin) {
	  	this.txt_mPin1.sendKeys(data.mpin[0]);
	  	this.txt_mPin2.sendKeys(data.mpin[1]);
	  	this.txt_mPin3.sendKeys(data.mpin[2]);
	  	this.txt_mPin4.sendKeys(data.mpin[3]);
  	}
  }

  click_cancel_link() {
    this.lnk_cancel.click();
  }

  click_forgot_mpin_link() {
  	page.wait_for_element_present(this.lnk_forgot_mpin).click();
  }


}

module.exports = new PaymentPage();