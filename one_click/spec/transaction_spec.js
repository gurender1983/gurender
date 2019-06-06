var login_page = require('../page/login_page.js');
var page = requireHelper('page');
var db = require('../database.js');
var base64 = require('base-64');
var transaction_page = require('../page/transaction_page.js');

var transaction_cancel = page.read_from_excel('Cancel_Transaction', 'transaction');

describe('Transaction Test Cases', function(){
	var UrlSplit = browser.baseUrl.split('SU='); //Use for baseURL split up to Success URL
	var PartialUrlSplit = UrlSplit[1].split('FU='); //Split up to Failure URL
	 
	 beforeEach(() => {
		 //browser.waitForAngular();
		 browser.get(browser.baseUrl);
		 browser.manage().timeouts().implicitlyWait(5000);
		 //browser.sleep(1000);
	 });
	 
	 
	//TC# 17 & 22 - Cancel transaction and Failure URL check 
	transaction_cancel.forEach(function(data, index) {
	 it('Cancel transaction', function(){
		 browser.ignoreSynchronization = false;
		 login_page.login_with_otp(data.mobileNumber)
		 browser.wait(browser.ExpectedConditions.elementToBeClickable(transaction_page.TxnCancel), 10000) 
	     .then(function(){
		 transaction_page.TxnCancel.click();		 
		 browser.ignoreSynchronization = true;
		 browser.wait(browser.ExpectedConditions.elementToBeClickable(transaction_page.TxnFailureMsg), 10000) 
	     .then(function(){
	    		 transaction_page.TxnFailureMsg.getText().then(function(transactionFailMsg){
	    			 expect(transactionFailMsg).toBe(data.failure_reason);
	    			//Assertion for fail URL redirection
		            	var FailureUrl1 = PartialUrlSplit[1].split('&');
		        	    var FailureUrl = FailureUrl1[0];
		        		browser.ignoreSynchronization = false;
		            	browser.driver.getCurrentUrl().then(function(failUrl){
		            		failUrl = failUrl.split('?');
		            		expect(FailureUrl).toContain(data.transaction_fail_Url);
		            	})
	    	 })
	    	})
	      })
	     })
	 })
})

