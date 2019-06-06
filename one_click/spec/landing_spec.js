// var landing_page = requirePage('landing_page');
// var transaction_page = requirePage('transaction_page');
// var database = require('../database.js');
// var flow = browser.controlFlow();
// var page = requireHelper('page');
// var invalid_url = page.read_from_excel( 'invalid_url', 'data');
// var txn_details = page.read_from_excel( 'txn_details', 'data');
// var scw_customers = page.read_from_excel('scw_customers', 'data');
// var savings_customers = page.read_from_excel('savings_customers', 'data');
// var invalid_otp = page.read_from_excel('invalid_otp', 'data');
// var payment_page = requirePage('payment_page');
// var wallet_customer = page.read_from_excel('wallet_customer', 'data')[0];
// var restricted_end_mid = page.read_from_excel('restricted_end_mid', 'data');
// var savings_restricted_end_mid = page.read_from_excel('savings_restricted_end_mid', 'data');


// describe('Landing Page', function() {

//   afterEach(() => {
//     browser.ignoreSynchronization = false;
//   });

//   fit('Google dot com', function() {
//     browser.get('https://www.google.com');
//   })

//   scw_customers.forEach(function(customer, index) {
//     it('As a wallet customer, I should be able to proceed to payment page', function() {
//       page.get_landing_page(customer);
//       landing_page.txt_mobile.sendKeys(customer.mobile);
//       landing_page.click_get_otp_button();
//       landing_page.enter_otp(customer.mobile);
//       landing_page.btn_verify.click();
//       expect(payment_page.btn_pay_now.isDisplayed()).toEqual(true);
//     })
//   })

//   // NOW BOTH WALLET AND SAVINGS CUSTOMERRS WILL ACCESS THE SAME URL
//   it('I enter wallet customers mobile number instead of savings customer', function() {
//     page.get_landing_page(wallet_customer);
//     landing_page.txt_mobile.sendKeys(wallet_customer.mobile);
//     landing_page.click_get_otp_button();
//     landing_page.enter_otp(wallet_customer.mobile);
//     landing_page.btn_verify.click();
//     expect(landing_page.error_msg.getText()).toEqual(wallet_customer.message);
//   })
  
//   scw_customers.forEach(function(customer, index) {
//     it('As a wallet customer I enter invalid otp', function() {
//       page.get_landing_page(customer);
//       landing_page.txt_mobile.sendKeys(customer.mobile);
//       landing_page.click_get_otp_button();
//       landing_page.txt_otp.sendKeys('123456');
//       landing_page.btn_verify.click();
//       expect(landing_page.error_msg.getText()).toEqual(invalid_otp[0].message);
//     })
//   })
    
//   // NOW BOTH WALLET AND SAVINGS CUSTOMERS WILL ACCESS THE SAME URL
//   savings_customers.forEach(function(customer, index) {
//     it('I enter savings customers mobile number instead of wallet customer', function() {
//       page.get_landing_page(customer);
//       landing_page.txt_mobile.sendKeys(customer.mobile);
//       landing_page.click_get_otp_button();
//       landing_page.enter_otp(customer.mobile);
//       landing_page.btn_verify.click();
//       expect(payment_page.btn_pay_now.isDisplayed()).toEqual(true);
//     })
//   })
    
//   it('As a wallet customer, I click on resend otp', function() {
//     page.get_landing_page(scw_customers[0]);
//     landing_page.txt_mobile.sendKeys(scw_customers[0].mobile);
//     landing_page.click_get_otp_button();
//     landing_page.click_resend_otp_link();
//     landing_page.enter_otp(scw_customers[0].mobile);
//     landing_page.btn_verify.click();
//     expect(payment_page.btn_pay_now.isDisplayed()).toEqual(true);
//   })

//   invalid_url.forEach(function(data, index) {
//     it('As a customer I followed invalid url', function() {
//       page.get_landing_page(data);
//       expect(landing_page.invalid_url_error.getText()).toEqual(data.message);
//     })
//   })

//   txn_details.forEach(function(row, index) {
//     it('As a wallet customer I should be able to validate my transaction details from right panel', function() {
//       page.get_landing_page(row);
//       browser.getCurrentUrl().then(function(url) {
//         var url_txn_details = page.parse_parameters(url);
//         database.get_merchant_name(url_txn_details.mid).then(function(data) {
//           if (data[0]) {
//             var merchant_name = data.rows[0][0];
//             expect(landing_page.merchant.getText()).toEqual(merchant_name);
//           }
//         })
//         expect(landing_page.ref_number.getText()).toEqual(url_txn_details.txn_ref_no);
//         expect(landing_page.order_amount.getText()).toEqual('₹ ' + url_txn_details.amt);
//         expect(landing_page.convenience_charge.getText()).toEqual('₹ ' + row.convenience_charge);
//         expect(landing_page.total_amount.getText()).toEqual(url_txn_details.amt);
//       });
      
//     })
//   })

//   it('Clicking cancel button should cancel the transaction and redirect to merchant site', function() {
//     page.get_landing_page(scw_customers[0]);
//     landing_page.click_cancel_link();
//     browser.ignoreSynchronization = true;
//     expect(page.wait_for_element_present(transaction_page.txn_cancelled_text).isDisplayed()).toEqual(true);
//   })

//   restricted_end_mid.forEach(function(customer, index) {
//     it('As a wallet customer I should be blocked to access some of the End Mid', function() {
//       page.get_landing_page(customer);
//       landing_page.txt_mobile.sendKeys(customer.mobile);
//       landing_page.click_get_otp_button();
//       landing_page.enter_otp(customer.mobile);
//       landing_page.btn_verify.click();
//       expect(landing_page.error_msg.getText()).toEqual(customer.message);
//     })
//   })

//   savings_restricted_end_mid.forEach(function(customer, index){
//     it('As a savings customer, I should be able to access the end MID that is restricted for airtel money customer', function() {
//       page.get_landing_page(customer);
//       landing_page.txt_mobile.sendKeys(customer.mobile);
//       landing_page.click_get_otp_button();
//       landing_page.enter_otp(customer.mobile);
//       landing_page.btn_verify.click();
//       expect(payment_page.btn_pay_now.isDisplayed()).toEqual(true);
//     })
//   })

//   // DELETE ME : CREATED FOR TESTING
//   // xit("testing", function() {
//   //   home_page.call_timeout().then(function(a) {
//   //     console.log(a);
//   //   });
//   //   home_page.display_hello().then(function(otp) {
//   //     browser.sleep(5000);
//   //     flow.execute(function() {
//   //       console.log("!!!!!!!!!!!!!");
//   //       console.log("!!!!!!!!!!!!!");
//   //       console.log(otp);
        
//   //     })
//   //   });
//   //   // flow.execute(() => console.log('I am last'));
//   //   flow.execute(function() {
//   //     console.log('1');
//   //     console.log('2');
//   //   })
    
//   // })


// })