class TransactionPage {
  constructor() {
	  	
	    this.UITextPath = element(by.xpath('//div[@ng-init="upgradeCheckEligibility()"]'));
		this.KYCDropDown = element(by.xpath('//select[@ng-model="user.doctType"]'));
		this.KYCField = element(by.xpath('//input[@ng-model="user.poiNumber"]'));
		this.KYCFieldErrorXpath = element(by.xpath('//div[@ng-if="user.doctType"]'));
		this.KYCAuthorization = element(by.xpath('//div[@class="login-otp"]/span[1]/label'));
		this.KYCProceedButton = element(by.buttonText('Proceed'));
		this.KYCSkipLink = element(by.linkText('Skip'));
		this.TxnMsgPath = element(by.xpath('//div[@class="thankyou-panel"]//h2'));	
		this.TxnFailureMsg = element(by.xpath('//div[@class="thankyou-panel"]//p'));
		
		this.UITextPath2 = element(by.xpath('//div[@class="balance-wrapper"]/p[2]'));
		this.PayNowButton = element(by.xpath('//button[@ng-click="onContinue()"]'));  
		this.TxnCancel = element(by.buttonText("Cancel"));  
	    this.header1 = element(by.xpath('//h3[contains(@class, "modal-title")][1]'));
	    this.header2 = element(by.xpath('//h3[contains(text(), "Transaction Successful")]'));
	    this.txn_cancelled_text = element(by.xpath('//div[contains(text(), "Transaction cancelled by user.")]'))
    
  }

  url_changed(url) {
    return function () {
      return browser.getCurrentUrl().then(function(actualUrl) {
        return actualUrl.includes(url);
      });
    };
  }
}

module.exports = new TransactionPage();