package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_followUsStepDef {
    P03_homePage homePage = new P03_homePage();
    
    @When("user opens facebook link")
    public void open_facebook(){
        homePage.facebookBtn.click();
    }

    @When("user opens twitter link")
    public void open_twitter(){
        homePage.twitterBtn.click();
    }

    @When("user opens rss link")
    public void open_rss(){
        homePage.rssBtn.click();
    }

    @When("user opens youtube link")
    public void open_youtube(){
        homePage.youtubeBtn.click();
    }

    @Then("{string} is opened in new tab")
    public void check_link(String link) throws InterruptedException{
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(tabs.get(1));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),link);
       Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));
    }
}
