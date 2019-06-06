'use strict';

class lkyPage{
	
	constructor() {
		this.UITextPath = element(by.xpath('//div[@ng-init="upgradeCheckEligibility()"]'));
		this.KYCDropDown = element(by.xpath('//select[@ng-model="user.doctType"]'));
		this.KYCField = element(by.xpath('//input[@ng-model="user.poiNumber"]'));
		this.KYCFieldErrorXpath = element(by.xpath('//div[@ng-if="user.doctType"]'));
		this.KYCAuthorization = element(by.xpath('//div[@class="login-otp"]/span[1]/label'));
		this.KYCProceedButton = element(by.buttonText('Proceed'));
		this.KYCSkipLink = element(by.linkText('Skip'));
		this.TxnMsgPath = element(by.xpath('//div[@class="thankyou-panel"]'));	
		this.TxnMsgHeaderPath = element(by.xpath('//div[@class="thankyou-panel//h2"]'));	
		this.UITextPath2 = element(by.xpath('//div[@class="balance-wrapper"]/p[2]'));
		this.PayNowButton = element(by.xpath('//button[@ng-click="onContinue()"]'));
		this.TxnCancel = element(by.xpath('//button[@ng-click="cancel(\'PAY_NOAUTH\') "]'));
		
	}	
}

module.exports = new lkyPage();