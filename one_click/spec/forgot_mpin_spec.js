/*var page = requireHelper('page');
var valid_data = page.read_from_excel('valid_data', 'mpin');
var forgot_mpin_page = requirePage('forgot_mpin_page');
var landing_page = requirePage('landing_page');
var invalid_initial_details = page.read_from_excel('invalid_initial_details', 'mpin');
var payment_page = requirePage('payment_page');
var invalid_form2_details = page.read_from_excel('invalid_form2_details', 'mpin');

describe('forgot mpin', function() {

  // NOT POSSIBLE TO CHANGE MPIN AS DEFAULT MPIN IS NOT AVAILABLE WHICH IS MANDATORY IN FORM 2 OF CHANGE MPIN
  // valid_data.forEach(function(data, index) {
  //   it('change mpin successfully', function() {
  //     page.get_landing_page(data);
  //     landing_page.authenticate(data.mobile);
  //     browser.ignoreSynchronization = true;
  //     payment_page.click_forgot_mpin_link();
  //     forgot_mpin_page.populate_form1(data);
  //     forgot_mpin_page.click_continue_btn();
  //     forgot_mpin_page.populate_form2(data);
  //     browser.ignoreSynchronization = false;
  //   })
  // })

  invalid_initial_details.forEach(function(data, index) {
    it('incorrect initial details (form 1)', function() {
      page.get_landing_page(data);
      landing_page.authenticate(data.mobile);
      payment_page.click_forgot_mpin_link();
      forgot_mpin_page.populate_form1(data);
      forgot_mpin_page.click_continue_btn();
      expect(page.wait_for_element_present(forgot_mpin_page.error).getText()).toEqual(data.message);
    })
  })

  invalid_form2_details.forEach(function(data, index) {
    it('incorrect mpin (form 2)', function() {
      page.get_landing_page(data);
      landing_page.authenticate(data.mobile);
      payment_page.click_forgot_mpin_link();
      forgot_mpin_page.populate_form1(data);
      forgot_mpin_page.click_continue_btn();
      forgot_mpin_page.populate_form2(data);
      forgot_mpin_page.click_update_btn();
      expect(page.wait_for_element_present(forgot_mpin_page.error).getText()).toEqual(data.message);
    })
  })
})*/