package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D01_registerStepDef {

    // create new object from register page
    P01_register register = new P01_register();
    @Given("user go to register page")
    public void register_page()
    {register.registerBtn.click();}

    @When("user select gender type")
    public void gender_male_select(){
        register.maleCheckBox.click();
    }

    @And("user enter first name \"automation\" and last name \"tester\"")
    public void enter_names(){
        register.fNameField.sendKeys("automation");
        register.lNameField.sendKeys("tester");
    }
    @And("user enter date of birth")
    public void enter_dob(){
        register.DList.click();
        Select dSelect =new Select(register.DList);
        dSelect.selectByVisibleText("15");

        register.MList.click();
        Select mSelect =new Select(register.MList);
        mSelect.selectByVisibleText("January");


        register.YList.click();
        Select ySelect =new Select(register.YList);
        ySelect.selectByVisibleText("2004");
    }

    @And("user enter email \"test@example.com\" field")
    public void enter_email(){
        register.EmailField.sendKeys("test@example1.com"); // this email was used as the original was registered
    }

    @And("user fills Password fields \"P@ssw0rd\" \"P@ssw0rd\"")
    public void enter_passwords(){
        register.PassField.sendKeys("P@ssw0rd");
        register.ConfirmField.sendKeys("P@ssw0rd");
    }

    @And("user clicks on register button")
    public void click_register_button(){
        register.finishregisterBtn.click();
    }

    @Then("success message is displayed")
    public void check_success_message(){
        Assert.assertTrue(register.registermessage.getText().contains("Your registration completed"),"The register feature functions properly");
    }
}
