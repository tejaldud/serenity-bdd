package fitflop.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

@DefaultUrl("http://www.fitflop.com/uk/en/")
public class HomePage extends PageObject {
    @FindBy(xpath = ".//div[@id='UmaThurmanBarComponent']")
    private WebElement header;

    @FindBy(xpath = "//div[@class='menu']/ul/li")
    private WebElement menuBar;

    @FindBy(className = "product-list__slider-image")
    private List<WebElement> products;

    @FindBy(xpath = "//ul[@class='menu-level-three']/li")
    List<WebElement> umaCategary;
    private List<WebElementFacade> webElementFacades;

    @FindBy(id="email")
    WebElement email;

    @FindBy(css = "span.form-checkbox__checkbox")
    WebElement choiceWomen;

    @FindBy(css="button.button--stretch")
    WebElement btnContinue;

    public void getAllTabs(List<String> categories)
    {
        List<String> categaries= new ArrayList<>();
        webElementFacades = findAll(By.cssSelector("ul.menu-level-one>li>a"));
        webElementFacades.forEach(
                webElementFacade -> {
                    System.out.println("cate"+webElementFacade.getText());
                    categaries.add( webElementFacade.getText());
                }
        );

    }
    public void clickOnCategory()
    {
        webElementFacades.get(0).click();
    }
    public void clickOnSubCategory()
    {
        umaCategary.get(0).click();
    }
    public void clickOnProduct()
    {
        clickOn(products.get(1));
        List<WebElementFacade> all = findAll(By.cssSelector("a[title='Black']"));
    }
    public void selectColorAndSizeAndAddProduct(String color,String size)
    {
        WebElement webElementColor = find(By.cssSelector("a[title='"+color+"']"));
        webElementColor.click();
        List<WebElementFacade> sizes= findAll(By.cssSelector("li.pdp__size-selector-item"));
        for (WebElementFacade webElementFacadeSize:sizes
                ) {
            if(webElementFacadeSize.getText().equalsIgnoreCase(size)) {
                webElementFacadeSize.click();
                break;
            }
        }
        clickOn(find(By.cssSelector("span.pdp__add-to-bag-button-text")));
    }

    public void goToCart() throws InterruptedException {
        WebElementFacade button=find(By.xpath("//button[@class='nav-btn nav-btn__bag ']"));
       // WebElementFacade webElementFacades = find(By.xpath("//span[@class='nav-btn__label-inner']/span[text()='Bag']"));
        button.click();
        button.click();
        Thread.sleep(2000);
    }
    public void goToCheckout()
    {
        find(By.cssSelector("button.cart-order-summary__cta-btn")).click();
    }

    public void selectGuestCheckout()
    {
        find(By.cssSelector("div.section-option__content")).click();
    }
    public void enterDetailsAndContinue() throws InterruptedException {
        email.sendKeys("tejal.dud88@gmail.com");
        choiceWomen.click();
        btnContinue.click();

    }
}
