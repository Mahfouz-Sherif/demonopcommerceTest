package org.example.pages;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class P02_login {
    public P02_login()
    {
        PageFactory.initElements(Hooks.driver,this);
    }
    @FindBy(className = "ico-login")
    public WebElement loginBtn;

    @FindBy(id = "Email")
    public WebElement EmailField;

    @FindBy(id="Password")
    public WebElement PassField;

    @FindBy(xpath = "//button[@class=\"button-1 login-button\"]")
    public WebElement finishloginBtn;

    @FindBy(className ="ico-account")
    public WebElement MyAccountTab;

    @FindBy(className = "message-error")
    public WebElement FailMessage;
}