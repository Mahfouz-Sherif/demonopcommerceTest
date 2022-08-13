package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.plugin.event.Node;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class D04_searchStepDef {
    P03_homePage homePage =new P03_homePage();

    SoftAssert soft= new SoftAssert();
    @Given("^user types (.*) in search box and presses the search button$")
    public void search_by_name(String name){
        homePage.searchbox.sendKeys(name);
        homePage.searchBtn.click();
    }

    @And("the url contains search url")
    public void check_search_url(){
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
    }

    @Then("^search shows relevant results that contain (.*)$")
    public void check_results_by_name(String name){
        List<WebElement> results = Hooks.driver.findElements(By.className("product-title"));
        int count = results.size();
        for(int i=0;i<count;i++){
            soft.assertTrue(results.get(i).getText().toLowerCase().contains(name));
        }
        soft.assertAll();
    }


    @Given("^user typed (.*) in search box and pressed search$")
    public void search_by_sku(String sku){
        homePage.searchbox.sendKeys(sku);
        homePage.searchBtn.click();
    }

    @When("user clicks on the product in search result")
    public void click_on_result(){
        homePage.product.click();
    }

    @Then("^the sku shown in this page contains the (.*) that was used in search$")
    public void check_sku(String sku){
        Assert.assertTrue(homePage.productsku.getText().contains(sku));
    }

}