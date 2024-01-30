package pages;

import helper.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;

public class LoginPage {
    @FindBy(name = "user-name")
    private WebElement userName;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    private  WebElement errorMessage;

    public LoginPage(){
        PageFactory.initElements(Utility.getDriver(), this);
    }
    public void fillUsername(String value) {
        userName.sendKeys(value);
    }

    public void fillPassword(String value) {
        password.sendKeys(value);
    }

    public void buttonLoginClicked() {
        loginButton.click();
    }

    public void verifyErrorMessageLoginFailed(String expectedErrorMessage){
        System.out.println("Expected error message : " + expectedErrorMessage);
        System.out.println("Actual error message : " + errorMessage.getText());

        //verify current page is home page
        assertEquals(expectedErrorMessage, errorMessage.getText()); // error message expected displayed correctly
    }
}
