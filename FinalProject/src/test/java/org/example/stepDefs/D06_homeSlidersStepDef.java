package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class D06_homeSlidersStepDef {
    P03_homePage homePage = new P03_homePage();

    @When("user clicks on first slider")
    public void click_on_first_slider(){
        homePage.slider.get(0).click();
    }


    @Then("check if url is nokia url")
    public void check_nokia_url() {
        //I didn't use explicit wait because the loading is done before this method is even invoked
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/nokia-lumia-1020");
    }

    @When("user clicks on second slider")
    public void click_on_second_slider() {
        homePage.slider.get(1).click();
    }

    @Then("check if url is iphone url")
    public void check_iphone_url(){
        //I didn't use explicit wait because the loading is done before this method is even invoked
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/iphone-6");
    }
}
