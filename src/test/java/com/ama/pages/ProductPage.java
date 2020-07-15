package com.ama.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ProductPage extends BasePage{

    private static final Logger logger = LogManager.getLogger(ProductPage.class);

    @AndroidFindBy(xpath = "//android.webkit.WebView//android.view.View[contains(text(), '65 inch')]")
    private WebElement productTitle;

    @AndroidFindBy(xpath = "//android.webkit.WebView//android.widget.EditText[contains(text(), 'rupee')]")
    private WebElement price;

    @AndroidFindBy(className = "android.webkit.WebView")
    private WebElement productsDetails;

    @AndroidFindBy(id = "add-to-cart-button")
    private WebElement addToCart;

    public ProductPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    /**
     *
     * @return Product details with title and price
     */
    public Product getSelectedProductDetails() {
        logger.info(productsDetails.getText());
        Product product = new Product();
        product.setAmount(Integer.parseInt(price.getText().replaceAll("[^\\d.]", "")));
        product.setTitle(productTitle.getText());
        return product;
    }

    /**
     * Adds the product to cart
     */
    public void addToCart() {
        addToCart.click();
    }


}
