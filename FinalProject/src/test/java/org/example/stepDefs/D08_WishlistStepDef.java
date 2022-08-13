package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.Color;

import java.time.Duration;

public class D08_WishlistStepDef {
    P03_homePage homePage = new P03_homePage();
    SoftAssert soft = new SoftAssert();
    @When("user clicks on wishlist button on product")
    public void click_wishlistBtn(){
        homePage.wishlistBtns.get(2).click();
    }

    @Then("user will see a green success message")
    public void check_successmsg() throws InterruptedException{
        Thread.sleep(3000);
        soft.assertTrue(homePage.successmsg.getText().contains("The product has been added to your wishlist"),"First Assertion");
        String color=Color.fromString(homePage.bg.getCssValue("background-color")).asHex();
        soft.assertEquals(color,"#4bb07a","Second Assertion");
        soft.assertAll();
    }

    @And("user clicks on wishlist")
    public void wait_and_click() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(homePage.bg));
        homePage.wishlistBtn.click();
    }

    @Then("user will see product in wishlist")
    public void verify_qty(){
            soft.assertNotEquals(homePage.wishlistQty.getText(),"0");
            soft.assertAll();
    }

}
