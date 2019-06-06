var page = requireHelper('page');
var login_page = require('../page/login_page.js');
var register = requirePage('customer_registration_page');
var payment_page = requirePage('payment_page');
var db = require('../database.js');
var base64 = require('base-64');


var customer_registration = page.read_from_excel( 'Reg_data', 'register');
var customer_reg_validation = page.read_from_excel( 'customer_reg_validations', 'data');

describe('customer registration', function() {

	beforeEach(() => {
		browser.get(browser.baseUrl);
		browser.sleep(1000);
	});

	customer_registration.forEach(function(registerdata, index) {
		it('should be able to register the user successfully', function () {
			register.RegisterLinkText.click();
			browser.sleep(2000);
			register.RegisterMobileNumberInputXpath.clear().sendKeys(registerdata.newMobileNumber);
			register.RegisterGOxpath.click();

			db.get_otp(registerdata.newMobileNumber).then(function(encodedOtp){
				var decodedOTP = base64.decode(encodedOtp)
				register.RegisterOTPxpath.sendKeys(decodedOTP);
				register.RegisterVerifyOtpButtonText.click();
				browser.wait(browser.ExpectedConditions.elementToBeClickable(register.FirstNamexpath), 10000) 
				.then(function(){
					register.populate_form(registerdata);
					browser.wait(browser.ExpectedConditions.elementToBeClickable(register.paymentPageLoadMoneyBtn), 10000) 
	        		.then(function(){
					register.paymentPageLoadMoneyBtn.isEnabled().then(function(isAvailable){
					expect(isAvailable).toBe(true);
					});		
				});});
			});});
	});

});

