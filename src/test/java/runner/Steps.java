package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Steps {
    WebDriver driver;
    @Before
    public void createDriver() {
        driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
    }
    @Given("I enter {string} as username")
    public void  enterUsername(String username) {
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys(username);
    }
    @And("I enter {string} as password")
    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);
    }

    @When("I click the login button")
    public void clickLogin() {
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @Then("I should see the homepage")
    public void checkHomepage() {
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Then("I should see the error {string}")
    public void checkError(String error) {
        WebElement errorField = driver.findElement(By.xpath("//h3[@data-test='error']"));
        Assert.assertEquals(error, errorField.getText());
    }

    @Given("I am logged in")
    public void iAmLoggedIn() {
        enterUsername("standard_user");
        enterPassword("secret_sauce");
        clickLogin();
    }

    String addToCartItem;
    @When("I click add to cart on the item {string}")
    public void iClickAddToCart(String item) {
        addToCartItem = item;
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-"+item));
        addToCartButton.click();
    }

    @Then("the add to cart button should change to {string}")
    public void checkRemoveButton(String text) {
        WebElement addToCartButton = driver.findElement(By.id("remove-"+addToCartItem));
        Assert.assertEquals(text, addToCartButton.getText());
    }
    @And("the cart icon should have a badge {string}")
    public void badgeShouldHaveBadge(String count) {
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(count, cartBadge.getText());
    }

    @And("the cart page should have the item {string}")
    public void checkItemAdded(String itemName) {
        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();
        Assert.assertEquals("https://www.saucedemo.com/cart.html", driver.getCurrentUrl());

        WebElement backPackItem = driver.findElement(By.className("inventory_item_name"));
        Assert.assertEquals(itemName,backPackItem.getText());
    }

    @And("the price of the item should be {string}")
    public void checkItemPrice(String price) {
        WebElement backPackPrice = driver.findElement(By.className("inventory_item_price"));
        Assert.assertEquals(price,backPackPrice.getText());
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }

}
