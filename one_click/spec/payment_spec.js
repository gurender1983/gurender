// var page = requireHelper('page');
// var landing_page = requirePage('landing_page');
// var payment_page = requirePage('payment_page');
// var payment_details = page.read_from_excel('payment_success', 'payment');
// var transaction_page = requirePage('transaction_page');
// var savings_data = page.read_from_excel('savings_data', 'payment');
// var incorrect_mpin_savings = page.read_from_excel('incorrect_mpin_savings', 'payment');
// var incorrect_mpin_wallet = page.read_from_excel('incorrect_mpin_wallet', 'payment');
// var scw_mpin_auth = page.read_from_excel('scw_mpin_auth', 'payment');
// var restricted_end_mid_savings = page.read_from_excel('restricted_end_mid_savings', 'payment');

// describe('Payment', function() {

//   afterEach(() => {
//     browser.ignoreSynchronization = false;
//   });
  
//   savings_data.forEach(function(data, index) {
//     it('As a netbanking customer, I should be able to transact after mpin authentication', function() {
//       page.get_landing_page(data);
//       landing_page.authenticate(data.mobile);
//       expect(payment_page.btn_pay_now.isDisplayed()).toEqual(true);
//       payment_page.enter_mPin(data);
//       browser.ignoreSynchronization = true;
//       payment_page.btn_pay_now.click();
//       expect(page.wait_for_element_present(transaction_page.header1).getText()).toEqual('Transaction in progress');
//       expect(page.wait_for_element_present(transaction_page.header2).isDisplayed()).toEqual(true);
//       expect(browser.wait(transaction_page.url_changed("http://localhost:8080/renewal/api/Payment/airtelCallbacksuccess"), 10000)).toEqual(true);
//     })
//   })

//   scw_mpin_auth.forEach(function(data, index) {
//     it('As a wallet customer, I should be able to transact after mpin authentication', function() {
//       page.get_landing_page(data);
//       landing_page.authenticate(data.mobile);
//       expect(payment_page.btn_pay_now.isDisplayed()).toEqual(true);
//       payment_page.enter_mPin(data);
//       browser.ignoreSynchronization = true;
//       payment_page.btn_pay_now.click();
//       expect(page.wait_for_element_present(transaction_page.header1).getText()).toEqual('Transaction in progress');
//       expect(page.wait_for_element_present(transaction_page.header2).isDisplayed()).toEqual(true);
//       expect(browser.wait(transaction_page.url_changed("http://localhost:8080/renewal/api/Payment/airtelCallbacksuccess"), 10000)).toEqual(true);
//     })
//   })

//   incorrect_mpin_savings.forEach(function(data, index) {
//     it('As a savings customer, I enter incorrect mpin', function() {
//       page.get_landing_page(data);
//       landing_page.authenticate(data.mobile);
//       expect(payment_page.btn_pay_now.isDisplayed()).toEqual(true);
//       payment_page.enter_mPin(data);
//       payment_page.btn_pay_now.click();
//       expect(page.wait_for_element_present(payment_page.error).getText()).toEqual(data.message);
//     })
//   })

//   payment_details.forEach(function(data, index) {
//     it('As a wallet customer, I should be able to pay successfully', function() {
//       page.get_landing_page(data);
//       landing_page.authenticate(data.mobile_scw);
//       expect(payment_page.btn_pay_now.isDisplayed()).toEqual(true);
//       browser.ignoreSynchronization = true;
//       payment_page.btn_pay_now.click();
//       expect(page.wait_for_element_present(transaction_page.header1).getText()).toEqual('Transaction in progress');
//       expect(page.wait_for_element_present(transaction_page.header2).isDisplayed()).toEqual(true);
//       expect(browser.wait(transaction_page.url_changed("http://localhost:8080/renewal/api/Payment/airtelCallbacksuccess"), 10000)).toEqual(true);
//     })
//   })

//   incorrect_mpin_wallet.forEach(function(data, index) {
//     it('As as wallet customer, I enter incorrect mpin', function() {
//       page.get_landing_page(data);
//       landing_page.authenticate(data.mobile);
//       expect(payment_page.btn_pay_now.isDisplayed()).toEqual(true);
//       payment_page.enter_mPin(data);
//       payment_page.btn_pay_now.click();
//       expect(page.wait_for_element_present(payment_page.error).getText()).toEqual(data.message);
//     })
//   })

//   // it('Clicking cancel button should cancel the transaction and redirect to merchant site', function() {
//   //   page.get_landing_page(payment_details[0]);
//   //   landing_page.authenticate(payment_details[0].mobile_scw);
//   //   payment_page.click_cancel_link();
//   //   browser.ignoreSynchronization = true;
//   //   expect(page.wait_for_element_present(transaction_page.txn_cancelled_text).isDisplayed()).toEqual(true);
//   //   expect(browser.wait(transaction_page.url_changed("http://localhost:8080/renewal/api/Payment/airtelCallbackfailure"), 10000)).toEqual(true);
//   // })

//   // savings_data.forEach(function(data, index) {
//   //   it('I should redirect to merchant site after successful transaction', function() {
//   //     page.get_landing_page(data);
//   //     landing_page.authenticate(data.mobile);
//   //     expect(payment_page.btn_pay_now.isDisplayed()).toEqual(true);
//   //     payment_page.enter_mPin(data);
//   //     browser.ignoreSynchronization = true;
//   //     payment_page.btn_pay_now.click();
//   //     expect(page.wait_for_element_present(transaction_page.header1).getText()).toEqual('Transaction in progress');
//   //     expect(page.wait_for_element_present(transaction_page.header2).isDisplayed()).toEqual(true);
//   //     expect(browser.wait(transaction_page.url_changed("http://localhost:8080/renewal/api/Payment/airtelCallbacksuccess"), 10000)).toEqual(true);
//   //   })
//   // })

//   // it('I should redirect to Failure URL if my transaction is not successful', function() {
//   //   page.get_landing_page(payment_details[0]);
//   //   landing_page.authenticate(payment_details[0].mobile_scw);
//   //   payment_page.click_cancel_link();
//   //   browser.ignoreSynchronization = true;
//   //   expect(page.wait_for_element_present(transaction_page.txn_cancelled_text).isDisplayed()).toEqual(true);
//   //   expect(browser.wait(transaction_page.url_changed("http://localhost:8080/renewal/api/Payment/airtelCallbackfailure"), 10000)).toEqual(true);
//   // })

//   restricted_end_mid_savings.forEach(function(data, index) {
//     it('As a savings customer I should be able to successfully transact the blocked END MID', function() {
//       page.get_landing_page(data);
//       landing_page.authenticate(data.mobile);
//       expect(payment_page.btn_pay_now.isDisplayed()).toEqual(true);
//       payment_page.enter_mPin(data);
//       browser.ignoreSynchronization = true;
//       payment_page.btn_pay_now.click();
//       expect(page.wait_for_element_present(transaction_page.header1).getText()).toEqual('Transaction in progress');
//       expect(page.wait_for_element_present(transaction_page.header2).isDisplayed()).toEqual(true);
//       expect(browser.wait(transaction_page.url_changed("http://localhost:8080/renewal/api/Payment/airtelCallbacksuccess"), 10000)).toEqual(true);
//     })
//   })
// })