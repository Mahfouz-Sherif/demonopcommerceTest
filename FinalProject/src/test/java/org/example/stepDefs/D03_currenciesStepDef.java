package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class D03_currenciesStepDef {

    P03_homePage homePage =new P03_homePage();

    SoftAssert soft= new SoftAssert();

    @When("Select Euro currency from the dropdown list on the top left of home page")
    public void select_euro_currency(){
        homePage.currencyList.click();
        Select dSelect =new Select(homePage.currencyList);
        dSelect.selectByVisibleText("Euro");
    }

    @Then("verify Euro Symbol \\(€) is shown on the 4 products displayed in Home page")
    public void verify_euro_symbol(){
        for (int i=0;i<4;i++) {
          String price=homePage.prices.get(i).getText();
          soft.assertTrue(price.contains("€"));
        }
        soft.assertAll();
    }
}
