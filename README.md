# Swag Labs QA: Web Automated Testing with Selenium Java

This repository serves as a dedicated space for storing code and resources related to my quality assurance learning and development journey. This repository is specifically designed to provide a comprehensive overview that focusing on UI automation testing https://www.saucedemo.com/ website with Selenium WebDriver.


## Key Features Tested 🚀 
In this repository, I created test scripts for one of the testing websites, SauceDemo, focusing on the following five test cases:  
- Login Successful ✅
- Login Failed with Invalid Username and Password ❌
- Sorting Products from Low to High Prices 💲🔼
- Successful Open Detail Product 🔍
- Add to Cart and Checkout 🛒✅

## Detailed Overview of Test Cases 📝  

### Test 1: Successful Login ✅
**Objective:** Ensure that users with correct credentials can log into their accounts successfully.  
**Steps:**  
- Navigate to the login page.
- Enter a valid username and password.
- Click the login button.
- Verify that the homepage is displayed.

### Test 2: Login Failed with Invalid Username and Password ❌

**Objective:** Validate that the system correctly handles incorrect login attempts and displays an appropriate error message.  
**Steps:**  
- Navigate to the login page.
- Enter an invalid username and password.
- Click the login button.
- Verify that an error message is displayed.

### Test 3: Sorting Products from Low to High Prices 💲🔼

**Objective:** Confirm that the product sorting feature works correctly by arranging products from the lowest to the highest price.  
**Steps:**  
- Log in with valid credentials.
- Navigate to the products page.
- Select the sorting option to sort products from low to high price.
- Verify that the products are correctly sorted by comparing the first displayed price with the last displayed price.

### Test 4: Successful Open Detail Product 🔍
**Objective:** Ensure that users can successfully view the details of a selected product.  
**Steps:**  
- Log in with valid credentials.
- Navigate to the products page.
- Click on a product to open its detail page.
- Verify that the product detail page is displayed correctly, including the product name, description, and price.

### Test 5: Add to Cart 🛒
**Objective:** Ensure that users can successfully add products to their cart.  
**Steps:**  
- Log in with valid credentials.
- Add a product to the cart.
- Navigate to the cart and verify the added product.

### Test 6: Checkout 🛒✅
**Objective:** Ensure that users can successfully complete the checkout process after adding products to the cart.  
**Steps:**  
- Log in with valid credentials.
- Add a product to the cart.
- Navigate to the cart and verify the added product.
- Proceed to checkout.
- Enter necessary details and complete the purchase.
- Verify that the order confirmation page is displayed.

## Objectives 🎯
Through these test scripts, the main objectives are:  
- **Ensure accurate results in functional testing scenarios:** Confirm that the functionality works as intended for a variety of real-world use cases, from login to product selection and checkout.
- **Apply good testing practices with Selenium in a real-world scenario:** Learn to write maintainable and effective test scripts for different test cases using Selenium, gaining practical experience in a testing project setup.
- **Enhance debugging and troubleshooting skills in automated testing:** Gain experience in troubleshooting failures and debugging issues in automated test scripts when they do not pass the expected results.
