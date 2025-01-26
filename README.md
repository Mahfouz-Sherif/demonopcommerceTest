# E-Commerce Application Test Automation Project  

## Overview  
This project automates the test plan for an e-commerce application, covering all major functionalities and possible test scenarios. The goal is to ensure that the application meets quality standards through automated testing, with detailed reporting on test case execution, statuses, and performance.  

## Project Description  
The e-commerce application is a B2C (Business to Customer) public web application that provides functionalities such as user registration, login, product browsing, shopping cart management, and checkout.  

This project involves automating the execution of test cases, validating key functionalities, and generating a comprehensive report containing:  
- Test scenario status (PASS/FAIL)  
- Execution time for each automated test  
- Detailed step-by-step results of test case execution  

## Features Tested  
### User Actions:  
- Customer Registration and Login  
- Password Reset  
- Product Search and Advanced Search  
- Currency Switching  
- Category Navigation and Sub-category Selection  
- Product Filtering (e.g., by color)  
- Shopping Cart Management  
- Wishlist Management  
- Product Comparison  
- Order Creation  

### Test Scenarios:  
| **Test Scenario ID** | **Description** |  
|-----------------------|-----------------|  
| SC1 | User can register with valid data |  
| SC2 | User can log in with valid email and password |  
| SC3 | User can reset password and see confirmation message ("Email with instructions has been sent to you.") |  
| SC4 | Logged-in user can search for products |  
| SC5 | Logged-in user can switch between currencies (USD/Euro) |  
| SC6 | Logged-in user can select categories and subcategories |  
| SC7 | Logged-in user can filter products by color (e.g., Apparel > Shoes) |  
| SC8 | Logged-in user can select different tags |  
| SC9 | Logged-in user can add products to the shopping cart |  
| SC10 | Logged-in user can add products to the wishlist |  
| SC11 | Logged-in user can add products to the comparison list |  
| SC12 | Logged-in user can successfully create an order |  

## Technologies Used  
- **Programming Language:** Java  
- **Test Automation Frameworks:** Selenium, TestNG, JUnit  
