package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @After()
    public void closeBrowser() {
        driver.quit();
    }

}
