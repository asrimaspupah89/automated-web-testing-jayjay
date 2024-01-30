package pages;

import helper.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DashboardPage {
    @FindBy(xpath = "(//div[@class='app_logo'])[1]")
    private WebElement headerPageTitle;

    @FindBy(xpath = "(//span[@class='title'])[1]")
    private WebElement homePageTitle;

    @FindBy(xpath = "(//button[@id='add-to-cart-sauce-labs-backpack'])[1]")
    private WebElement addToCartButtonBackpack;

    @FindBy(xpath = "(//a[@class='shopping_cart_link'])[1]")
    private WebElement iconCart;

    @FindBy(xpath = "(//*[text()='Add to cart'])[1]")
    private WebElement addToCartButton;

    @FindBy(xpath = "(//*[text()='Remove'])[1]")
    private WebElement removeItemButton;


    public DashboardPage(){
        PageFactory.initElements(Utility.getDriver(), this);
    }

    public void verifyLoginSuccessfull(){
        String expectedTittleHeaderPage ="Swag Labs";
        String expectedTittlePage = "Products";

        System.out.println("Actual header title : " + headerPageTitle.getText());
        System.out.println("Actual page title : " + homePageTitle.getText());

        //verify current page is home page
        assertEquals(expectedTittleHeaderPage, headerPageTitle.getText()); // header page tittle is Products
        assertEquals(expectedTittlePage, homePageTitle.getText()); // page tittle is Products
        assertTrue(iconCart.isDisplayed()); // cart icon is displayed
    }

    public void addItemToCart(){
        addToCartButton.click();
    }

    public void removeItemFromCart(){
        removeItemButton.click();
    }

    public void verifyNumberOfItemCartDisplayed(String numrberItemExpected){
        System.out.println("Actual numberItemExpected : " + iconCart.getText());

        // verify number of cart
        assertEquals(numrberItemExpected, iconCart.getText());
    }
}
