var login_page = require('../page/login_page.js');
var page = requireHelper('page');
var db = require('../database.js');
var base64 = require('base-64');
//var isbase64 = require('is-base64');

var login_data1 = page.read_from_excel('TC1_data', 'login');
var login_data2 = page.read_from_excel('TC2_data', 'login');
var login_data3 = page.read_from_excel('TC3_data', 'login');
var login_data4 = page.read_from_excel('TC4_data', 'login');
var login_data5 = page.read_from_excel('TC5_data', 'login');
var login_data6 = page.read_from_excel('TC6_data', 'login');
var login_data7 = page.read_from_excel('TC7_data', 'login');
var login_data10 = page.read_from_excel('TC10_data', 'login');
var login_data13 = page.read_from_excel('TC13_data', 'login');
var login_data18 = page.read_from_excel('TC18_data', 'login');
var login_data19 = page.read_from_excel('TC19_data','login');
var login_data23 = page.read_from_excel('TC23_data', 'login');
var login_data24 = page.read_from_excel('TC24_data', 'login');


describe('Login Page Test Cases', function(){		
	
	 beforeEach(() => {
		console.log("@@@@@@@@@@@@@@@@@@");
		console.log("@@@@@@@@@@@@@@@@@@");
		console.log(browser.baseUrl);
		 browser.get(browser.baseUrl);
		 //browser.ignoreSynchronization = false;
		 //browser.waitForAngularEnabled = true;
		 browser.sleep(1000);
	 });
	 
	/* fit('Google dot com', function() {
		    browser.get('https://www.google.com');
		  })*/
	 
		
	//TC#1 - Check that entering incorrect number displays error message
	 login_data1.forEach(function(data, index) {
	it('TC#1 - validate phone number', function(){	
			login_page.enter_mobile_number(data.mobileNumber);
			login_page.click_login_with_mpin();	

			login_page.error_msg.isPresent().then(function(isErrorDisplayed){
				if(data.ErrorDisplayed==true){
					login_page.error_msg.getText().then(function(uiErrMsg){
						expect(data.errorMsg).toBe(uiErrMsg);
					})	
				}					
			})
		})
	 })

	
	//TC#2 - Verifying the enter mPin box is displayed only when mPin is of 4 digit
     login_data2.forEach(function(data, index) {
     it('TC#2 - validate mPin - Check length', function(){
    	login_page.enter_mobile_number(data.mobilenumber);
        login_page.click_login_with_mpin();
        login_page.enter_mPin(data.mpin);        
        login_page.login_btn.isEnabled().then(function(isLoginEnabledStatus){
      	  if(data.mpin.length<4){
      		  expect(data.errorMsg).toContain(isLoginEnabledStatus);
      		  }
      	  else{
      		  // expect(data.errorMsg).toContain(isLoginEnabledStatus);
      		  expect(data.errorMsg).toContain(true);
      		 }
        })       
     	})
     })
     
	
	//TC#3 - Verify mPin on SBA page
	 login_data3.forEach(function(data, index) {
		it('TC#3 - Verify Mpin', function(){
			login_page.login_with_otp(data.mobileNumber);
			browser.wait(browser.ExpectedConditions.elementToBeClickable(login_page.enter_mpin_sba), 10000) 
	        .then(function(){
			login_page.enter_mpin_sba.sendKeys(data.mPin); 
			login_page.payNow_btn_sba.click();
			browser.wait(browser.ExpectedConditions.elementToBeClickable(login_page.toast_msg), 10000) 
	        .then(function(){
	        	login_page.toast_msg.isPresent().then(function(msgStatus){
				if(msgStatus=true){
					login_page.get_toast_msg().then(function(toastMsg){
						console.log(toastMsg);
						expect(toastMsg).toBe(data.msg);
					})
				}
				else{
				login_page.TxnMsgPath_sba.getText().then(function(msg){			 
					 console.log(msg);
					 expect(msg).toContain(data.txnSuccessMsg);
				 })
				 }
				})
	       })
	      })
	 })})	
		
		
		//TC#4 -Login with OTP-Wallet - Check the 'OTP sent' msg and lengths of OTP digits	 	
	 	// Verify (1) - 'OTP Sent!' message should be visible on the front end.
	 	// Verify (2) - If 6 digits are entered ,then only Login button should get enabled.	
	  login_data4.forEach(function(data, index) {
		it('TC#4 - Login with OTP-Wallet', function(){	
			login_page.enter_mobile_number(data.mobileNumber);
			login_page.click_login_with_OTP();
			
			//Verification - 1
			login_page.get_toast_msg().then(function(value){
				expect(value).toBe(data.sentOtpMsg);
				});
			
			//verification -2
				login_page.enter_Otp(data.otp);
				login_page.login_btn.isEnabled().then(function(isLoginEnabledStatus){
              	  if(data.otp.length<6){
              		  expect(isLoginEnabledStatus).toBe(false);
              		  }
              	  else{
              		  expect(isLoginEnabledStatus).toBe(true);
              		 }
                })		    			
		   })
	 })
	
	 
		//TC#5 - Login with incorrect OTP -- Check the comment after entering incorrect OTP
	 login_data5.forEach(function(data, index) {
		it('TC#5 - Login with Incorrect OTP - Verify error msg', function(){
			login_page.enter_mobile_number(data.mobileNumber);
			login_page.click_login_with_OTP();
			login_page.enter_Otp(data.otp);
			login_page.login();
			login_page.get_toast_msg().then(function(value){
				expect(value).toBe(data.incorrectErrorMsgContent);
			})
		})
	 })
	 
	

	//TC#6 - verify OTP -- Check that the OTP length is of 6 digits
	 login_data6.forEach(function(data, index) {
		it('TC#6 - verify OTP - Check that OTP is valid and of 6 digits', function(){
			login_page.enter_mobile_number(data.mobileNumber);
			login_page.click_login_with_OTP();
			db.get_otp(data.mobileNumber).then(function(otpValue){
				var decodedOTP = base64.decode(otpValue)
				
				//verification 1 - Check the OTP length
				expect(decodedOTP.length).toBe(6);
				
				//verification 2 - Check the login success
				login_page.enter_Otp(decodedOTP);
				login_page.login();
				browser.wait(browser.ExpectedConditions.visibilityOf(login_page.payNow_btn_sba), 20000) //wait until OTP sent message box is displayed
	        	.then(function(){
				 expect(login_page.payNow_btn_sba.isDisplayed()).toBe(true);	 
	       		 })			
			});			
		});
	 });
		
	  
	  
	 //TC# 7, 8 & 9 - Login with otp-SBA
	 login_data7.forEach(function(data, index) {
	 it('TC# 7, 8 & 9 - SBA - Login with OTP, Login with mPin & Sufficient balance', function () {
		 login_page.login_with_otp(data.mobileNumber);
		 browser.wait(browser.ExpectedConditions.visibilityOf(login_page.LoginSuccessMsgHolder_sba), 10000) //wait until OTP sent message box is displayed
	        .then(function(){
	         login_page.LoginSuccessMsgHolder_sba.getText().then(function(successMsg){
			 expect(successMsg).toBe(data.SBAUsermsg);
			 
			 //login with mpin as dual factor authentication
			 login_page.enter_mpin_sba.sendKeys(data.mpin);
			 login_page.payNow_btn_sba.click();
			 browser.wait(browser.ExpectedConditions.visibilityOf(login_page.LoginSuccessMsgHolder_sba), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
		        	login_page.TxnMsgPath_sba.getText().then(function(msg){			 
		        	console.log(msg);
		        	expect(msg).toBe(data.txnSuccessMsg);
			 })})			 
		 })})
	})})
	

	//TC# 19 - Login SBA - load cash and PayNow
	login_data19.forEach(function(data, index) {
		it('TC# 19 - SBA - Load cash and Paynow', function () {
			login_page.login_with_otp(data.mobileNumber);
			browser.wait(browser.ExpectedConditions.elementToBeClickable(login_page.enter_mpin_sba), 10000) 
	        		.then(function(){
			login_page.enter_mpin_sba.sendKeys(data.mpin);
			login_page.LoadMoneyBtn.click();
			browser.wait(browser.ExpectedConditions.visibilityOf(login_page.cardNumber_inputBox), 10000) //wait until OTP sent message box is displayed
		        .then(function(){
					expect(login_page.payNow_Btn_loadCash.isDisabled()).toBe(true);
					loadCash_form(data);
					expect(login_page.payNow_Btn_loadCash.isDisabled()).toBe(false);
					login_page.payNow_Btn_loadCash.click();
				});
		});
	});
	});

	
	
	 
	 //TC# 10 & 20 - Login SBA - Validate Insufficient balance
	 login_data10.forEach(function(data, index){
	 it('TC# 10 - Login SBA with Insufficient balance', function(){
		 login_page.login_with_otp(data.mobileNumber);
		 browser.wait(browser.ExpectedConditions.visibilityOf(login_page.LoadMoneyBtn), 20000) //wait until OTP sent message box is displayed
	        .then(function(){
			 expect(login_page.LoadMoneyBtn.isEnabled()).toBe(false);
			 login_page.enter_mpin_sba.sendKeys(data.mpin);
			 expect(login_page.LoadMoneyBtn.isEnabled()).toBe(true);	 
	        })
	 	})
	})

	
	 //TC# 13 - Check that Double click is disabled
	 login_data13.forEach(function(data, index){
	 it('TC# 13 - disabled double click', function(){
		 login_page.login_with_otp(data.mobileNumber);
		 browser.ignoreSynchronization = true;
		 login_page.login_btn.isEnabled().then(function(btnStatus){
			 console.log(btnStatus);
			 expect(btnStatus).toBe(false);
		 })
	 	})
	})
	
	
	 //TC#18 - send otp maximum 3 attempts
	 login_data18.forEach(function(data, index){
	 it('TC#18 - Resend otp - 3tries', function () {
		 login_page.enter_mobile_number(data.mobileNumber);
		 login_page.loginWithOtp_linkText.click();
		 for(var i=1; i<=3; i++){
			browser.ignoreSynchronization = false;
			 login_page.ResendOTPLink.click();
		 }
		 browser.ignoreSynchronization = true;
		 browser.wait(browser.ExpectedConditions.presenceOf(login_page.toast_msg), 10000) //wait until OTP sent message box is displayed
	        .then(function(){
	        	login_page.get_toast_msg().then(function(toastMsg){
	        		expect(toastMsg).toBe(data.OTPExhaustLimitMsg);
	        	})
	        })
	 	})
	 })
	 

	 
	  //TC# 23 - check if OTP is encoded
	 login_data23.forEach(function(data, index){
	 it('TC# 23 - check if OTP is encoded', function(){
		 login_page.enter_mobile_number(data.mobileNumber);
		 login_page.loginWithOtp_linkText.click();
		 db.get_otp(data.mobileNumber).then(function(encodedOtp){
			 expect(isbase64(encodedOtp)).toBe(true);
		 })
	 	})
	})
	
	//TC#24 - mPin Attempts
	 login_data24.forEach(function(data, index) {
		it('TC#24 - mPin Attempts', function(){
			login_page.login_with_otp(data.mobileNumber);
			browser.wait(browser.ExpectedConditions.elementToBeClickable(login_page.enter_mpin_sba), 10000) 
	        .then(function(){
			login_page.enter_mpin_sba.sendKeys(data.mPin); // entering incorrect OTP first to validate the error msg
			login_page.payNow_btn_sba.click();
			browser.wait(browser.ExpectedConditions.elementToBeClickable(login_page.toast_msg), 10000) 
	        .then(function(){
	        	login_page.toast_msg.isPresent().then(function(msgStatus){
	        		console.log(data.validation_Required);
				if(data.validation_Required='YES'){
					login_page.get_toast_msg().then(function(toastMsg){
						expect(toastMsg).toBe(data.msg);
					})
				}
				})
	       })
	      })
	 })}) 
	   
})

