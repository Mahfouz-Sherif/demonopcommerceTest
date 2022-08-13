package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.Color;
public class D02_loginStepDef {
    P02_login login = new P02_login();
    SoftAssert soft= new SoftAssert();

    @Given("user go to login page")
    public void login_page(){
        login.loginBtn.click();
    }

    @When("^user login with \"valid\" \"(.*)\" and \"(.*)\"$")
    public void enter_valid_email_and_pass(String email,String password){
        login.EmailField.sendKeys(email);
        login.PassField.sendKeys(password);
    }

    @When("^user login with \"invalid\" \"(.*)\" and \"(.*)\"$")
    public void enter_invalid_email_and_pass(String email,String password){
        login.EmailField.sendKeys(email);
        login.PassField.sendKeys(password);
    }

    @And("user press on login button")
    public void login_finish(){
        login.finishloginBtn.click();
    }

    @Then("user login to the system successfully")
    public void check_login_success(){
        soft.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/","First Assertion");

        soft.assertTrue(login.MyAccountTab.isEnabled(),"Second Assertion");

        soft.assertAll();
    }

    @Then("user could not login to the system")
    public void check_login_fail(){
        soft.assertTrue(login.FailMessage.getText().contains("Login was unsuccessful."),"First Assertion");

        String color=Color.fromString(login.FailMessage.getCssValue("color")).asHex();
        soft.assertTrue(color.equals("#e4434b"),"Second Assertion");

        soft.assertAll();
    }
}
