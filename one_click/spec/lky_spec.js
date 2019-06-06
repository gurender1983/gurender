'use strict';

var lky_page = require('../page/lky_page.js');
var login_page = require('../page/login_page.js');
var page = requireHelper('page');
var transaction_page = require('../page/transaction_page.js');

var lky_tc1 = page.read_from_excel('TC1_LKY', 'lky');
var lky_tc2 = page.read_from_excel('TC2_LKY', 'lky');

describe('Verify the Wallet LKY User details for KYC update', function () {
	var UrlSplit = browser.baseUrl.split('SU='); //Use for baseURL split up to Success URL
	var PartialUrlSplit = UrlSplit[1].split('FU='); //Split up to Failure URL

	beforeEach(function () {
		browser.get(browser.baseUrl);
		browser.sleep(1000);
		browser.manage().timeouts().implicitlyWait(5000);
	});

	//ECOM TC#11 - Update KYC doc for LKY users
	lky_tc1.forEach(function(data, index) {
		it('ECOM TC#11 : Verfiy that KYC details are required for LKU users', function () {
			login_page.login_with_otp(data.mobileNumber);	   
			//lky_page.KYCDropDown.element(by.cssContainingText('option', data.Kyc_Doc)).click();
			lky_page.KYCField.sendKeys(data.Kyc_Doc_value);
			browser.executeScript('window.scrollTo(0,10000);').then(function() {
				lky_page.KYCAuthorization.click();
				expect(lky_page.KYCProceedButton.isEnabled()).toBeTruthy();
				lky_page.KYCProceedButton.click();
				
				// To check after successful update KYC document user comes on page for PAYNOW or LOAD MONEY on Next screen
				transaction_page.UITextPath.getText().then(function(msg) {
						expect(msg).toBe(data.TxnMsg);
					});

					/*lky_page.TxnMsgPath.element(by.tagName('h2')).getText().then(function(msg) {
			   				 expect(msg).toBe(data.TxnSuccessMsg);
			    		});*/
			});
		});				 
	});


	//ECOM TC#12, 19 & 21 - After Updating KYC, user should be able to make payment and redirected to success URL
	lky_tc2.forEach(function(data, index) {
		it('should be able to pay the amount successfully', function () { 
			login_page.login_with_otp(data.mobileNumber);    	    
			expect(lky_page.PayNowButton.isEnabled()).toBeTruthy();
			lky_page.PayNowButton.click();
			browser.ignoreSynchronization = true;
			lky_page.TxnMsgHeaderPath.getText().then(function(msg) {
				expect(msg).toBe(data.TxnSuccessMsg);

				//Assertion for Pass URL redirection
				var SuccessUrl = PartialUrlSplit[0].split('&');
				browser.ignoreSynchronization = false;
				browser.driver.getCurrentUrl().then(function(passurl) {
					browser.sleep(6000);
					expect(passurl).toBe(SuccessUrl[0]);
				});
			});

		});				 
	});
});