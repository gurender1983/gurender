var page = requireHelper('page');

class ForgotMpin {
  constructor() {
    this.fname = element(by.model('userData.fname'));
    this.lname = element(by.model('userData.lname'));
    this.dob = element(by.model('userData.dob'));
    this.btn_continue = element(by.buttonText('Continue'));
    this.dwn_month = element(by.xpath('//select[contains(@class, "ui-datepicker-month")]'));
    this.dwn_year = element(by.xpath('//select[contains(@class, "ui-datepicker-year")]'));
    this.default_mpin1 = element(by.model('mpin.mpin11'));
    this.default_mpin2 = element(by.model('mpin.mpin22'));
    this.default_mpin3 = element(by.model('mpin.mpin33'));
    this.default_mpin4 = element(by.model('mpin.mpin44'));
    this.new_mpin1 = element(by.id('np'));
    this.new_mpin2 = element(by.id('a'));
    this.new_mpin3 = element(by.id('b'));
    this.new_mpin4 = element(by.id('c'));
    this.confirm_mpin1 = element(by.model('mpin.mpin5'));
    this.confirm_mpin2 = element(by.model('mpin.mpin6'));
    this.confirm_mpin3 = element(by.model('mpin.mpin7'));
    this.confirm_mpin4 = element(by.model('mpin.mpin8'));
    this.btn_update = element(by.buttonText('Update'));
    this.error = element(by.xpath('//div[contains(@class, "show-error")]'));
  }

  click_update_btn() {
    this.btn_update.click();
  }

  populate_form2(data) {
    if (data.default_mpin) {
      page.wait_for_element_present(this.default_mpin1).sendKeys(data.default_mpin[0]);
      this.default_mpin2.sendKeys(data.default_mpin[1]);
      this.default_mpin3.sendKeys(data.default_mpin[2]);
      this.default_mpin4.sendKeys(data.default_mpin[3]);
    }

    if (data.new_mpin) {
      page.wait_for_element_present(this.new_mpin1).sendKeys(data.new_mpin[0]);
      this.new_mpin2.sendKeys(data.new_mpin[1]);
      this.new_mpin3.sendKeys(data.new_mpin[2]);
      this.new_mpin4.sendKeys(data.new_mpin[3]);
    }

    if (data.confirm_mpin) {
      this.confirm_mpin1.sendKeys(data.confirm_mpin[0]);
      this.confirm_mpin2.sendKeys(data.confirm_mpin[1]);
      this.confirm_mpin3.sendKeys(data.confirm_mpin[2]);
      this.confirm_mpin4.sendKeys(data.confirm_mpin[3]);
    }
  }

  populate_dob(dob) {
    var dob_array = dob.split('/');
    this.dob.click();
    this.select_year(dob_array[2]);
    this.select_month(dob_array[1]);
    this.select_date(dob_array[0]);
  }

  select_month(month) {
    this.dwn_month.click();
    this.dwn_month.element(by.xpath('//option[text()="' + month + '"]')).click();
  }

  select_date(date) {
    element(by.xpath('//table[contains(@class, "ui-datepicker-calendar")]//td/a[text()=' + date + ']')).click();
  }

  select_year(year) {
    this.dwn_year.click();
    this.dwn_year.element(by.xpath('//option[@value=' + year + ']')).click();
  }

  populate_form1(data) {
    if (data.fname) { page.wait_for_element_present(this.fname).sendKeys(data.fname) };
    if (data.lname) { this.lname.sendKeys(data.lname)};
    if (data.dob) { this.populate_dob(data.dob)} ;
  }

  click_continue_btn() {
    this.btn_continue.click();
  }
}

module.exports = new ForgotMpin();