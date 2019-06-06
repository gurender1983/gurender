var db = require('../database.js');
var base64 = require('base-64');

class login_page {
	
	//Initializing login page web elements
	constructor() {
	  this.mobileNumber_inputBox = element(by.id("usernameInput"));
	  this.loginWithMpin_linkText= element(by.linkText("LOGIN WITH mPIN"));
	  this.enter_mPin_Box = element(by.id("mpinInput"));
	  this.LoginSuccessMsgHolder_wallet =  element(by.xpath("//*[@class='red-color ng-binding']"));
	  this.error_msg = element(by.xpath("//div[@class='ff-wrapper alert-msg']/p"));
	  this.loginWithOtp_linkText = element(by.linkText("LOGIN WITH OTP"));	  
	  this.enter_OTP_box = element(by.model("user.otp"));
	  this.login_btn = element(by.buttonText("LOGIN"));
	  this.toast_msg = $(".toast-message");	  
	  this.ResendOTPLink = element(by.xpath('//button[@ng-click="resendOTP()"]'));
	  
	  //SBA
	  this.LoginSuccessMsgHolder_sba =  element(by.xpath("//*[@class='sub-heading-text']"));
	  this.enter_mpin_sba = element(by.model("user.mpin"));
	  this.payNow_btn_sba = element(by.buttonText("Pay Now"));
	  this.TxnMsgPath_sba = element(by.xpath('//div[@class="thankyou-panel"]'));
	  this.LoadMoneyBtn = element(by.xpath("//button[@ng-click='verifyMpin()']"));

	  //loadCash
	  this.cardNumber_inputBox = element(by.model('debitData.cardNumber'));
	  this.cardName_inputBox = element(by.name('debitData.name'));
	  this.expiryMonth_inputBox = element(by.model('debitData.expiryMonth'));
	  this.expiryYear_inputBox = element(by.model('debitData.expiryYear'));
	  this.cvv_inputBox = element(by.model('debitData.cvv'));
	  this.payNow_Btn_loadCash = element(by.buttonText('Pay Now'));
	}
	
	//Login page - common methods
	
	login_with_MPIN(mobileNumber, mPin){
		this.enter_mobile_number(mobileNumber);
		this.loginWithMpin_linkText.click();
		this.enter_mPin_Box.sendKeys(mPin);
		this.login_btn.click();		
	}
	
	login_with_otp(mobileNumber){
		this.enter_mobile_number(mobileNumber);
		this.click_login_with_OTP();
		//browser.sleep(2000);
		db.get_otp(mobileNumber).then(function(otpValue){
			var decodedOTP = base64.decode(otpValue)
			element(by.model("user.otp")).sendKeys(decodedOTP);
			element(by.buttonText("LOGIN")).click();
			//browser.sleep(2000);			
		});	
	}
	
	
	clear_mobile_number(){
		this.mobileNumber_inputBox.clear();
	}
	enter_mobile_number(mobile){
		//this.enter_mobile_number_field.clear();
		this.mobileNumber_inputBox.clear().sendKeys(mobile);
	}
	is_error_msg_displayed(){
		return this.error_msg.isDisplayed();
	}
	
	
	click_login_with_mpin(){
		this.loginWithMpin_linkText.click();
	}
	enter_mPin(mpin){
		this.enter_mPin_Box.sendKeys(mpin);
	}
	
	
	click_login_with_OTP(){
		this.loginWithOtp_linkText.click();
	}
	enter_Otp(otp){
		this.enter_OTP_box.sendKeys(otp);
	}
	
	login(){
		this.login_btn.click();
	}
	
	get_toast_msg(){
		browser.sleep(1000);
		return this.toast_msg.getText();		
	}

	loadCash_form(data){
		this.cardNumber_inputBox.sendKeys(data.cardNumber);
		this.cardName_inputBox.sendKeys(data.cardName);
		this.expiryMonth_inputBox.sendKeys(data.expiryMonth);
		this.expiryYear_inputBox.sendKeys(data.expiryYear);
		this.cvv_inputBox.sendKeys(data.cvv);
	}

}

module.exports = new login_page();