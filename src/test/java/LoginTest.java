import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class LoginTest {
    WebDriver driver;
    @Before
    public void setupDriver() {
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void login() {
        // entering username
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        // entering password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        // clicking login
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }
    @Test
    public void cartCheckout() {
        login();

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        addToCartButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        Assert.assertEquals("Remove", addToCartButton.getText());

        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals("1", cartBadge.getText());

        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();
        Assert.assertEquals("https://www.saucedemo.com/cart.html", driver.getCurrentUrl());

        WebElement backPackItem = driver.findElement(By.className("inventory_item_name"));
        Assert.assertEquals("Sauce Labs Backpack",backPackItem.getText());

        WebElement backPackPrice = driver.findElement(By.className("inventory_item_price"));
        Assert.assertEquals("$29.99",backPackPrice.getText());
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}
