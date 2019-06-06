var page = requireHelper('page');
var landing_page = requirePage('landing_page');
var valid_url = page.read_from_excel( 'valid_url', 'data');

class CustomerRegistractionPage {
  constructor() {

	  this.RegisterLinkText = element(by.linkText('REGISTER NOW'));
      this.RegisterMobileNumberInputXpath = element(by.xpath('//input[@ng-model="user.customerId"]'));
      this.RegisterGOxpath = element(by.xpath('//button[@ng-click="sendOTP()"]'));
      this.RegisterOTPxpath = element(by.xpath('//input[@ng-model="user.otp"]'));
      this.RegisterVerifyOtpButtonText = element(by.buttonText('verify otp'));
      this.FirstNamexpath = element(by.xpath('//input[@ng-model="user.fname"]'));
      this.LastNamexpath = element(by.xpath('//input[@ng-model="user.lname"]'));
      this.DOB = element(by.xpath('//input[@ng-model="user.dob"]'));
      this.PinCodepath = element(by.xpath('//input[@ng-model="user.pinCode"]'));
      this.mPINxpath = element(by.model("user.mpin"));
      this.ConfirmMPINxpath = element(by.model("user.confirmMpin"));
      this.DocType = element(by.model('user.doctType'));
      this.Aadhaarxpath = element(by.xpath('//input[@ng-model="user.poiNumber"]')),
      this.Emailxpath = element(by.xpath('//input[@ng-model="user.email"]'));
      this.tncAcceptCheckBox = element(by.xpath("//input[@ng-model='tncAccepted']/following-sibling::label"));
      this.authorizeAirtelCheckBox =element(by.xpath("//input[@ng-model='tncAccepted1']/following-sibling::label"));
      this.Registerxpath = element(by.xpath('//button[@ng-click="signUp()"]'));
      this.CreateWalletButton = element(by.buttonText('Create Wallet'));  
      this.paymentPageLoadMoneyBtn = element(by.buttonText("Load Money"));
  }

  populate_form(registerdata){
        
    this.FirstNamexpath.clear().sendKeys(registerdata.FirstName);
    this.LastNamexpath.clear().sendKeys(registerdata.LastName);
    this.DOB.clear().sendKeys(registerdata.DOB);
    this.PinCodepath.click();
    this.PinCodepath.clear().sendKeys(registerdata.PinCode);
    this.mPINxpath.sendKeys("3056");
    this.ConfirmMPINxpath.sendKeys("3056");
    this.DocType.element(by.cssContainingText('option', registerdata.DocValue)).click();
    this.Aadhaarxpath.sendKeys(registerdata.AadhaarCard);
    this.Emailxpath.sendKeys(registerdata.Email);
    browser.executeScript('window.scrollTo(0,1000);');			 	    
    this.tncAcceptCheckBox.click();
    this.authorizeAirtelCheckBox.click();
    this.CreateWalletButton.click();
         
}
}

module.exports = new CustomerRegistractionPage();