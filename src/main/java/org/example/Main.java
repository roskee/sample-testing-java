package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       // opening browser
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.saucedemo.com/");
        // entering username
        WebElement userNameField = driver.findElement(By.id("user-name"));
        userNameField.sendKeys("standard_user");
        // entering password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        // clicking login
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        // checking if login was successful
        String url = driver.getCurrentUrl();
        if (url.equals("https://www.saucedemo.com/inventory.html")) {
            System.out.println("Login is Okay!");
        } else {
            System.out.println("Login was not successful!");
        }
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        addToCartButton = driver.findElement(By.id("remove-sauce-labs-backpack"));
        String removeText = addToCartButton.getText();
        if (removeText.equals("Remove")) {
            System.out.println("Remove did come");
        } else {
            System.out.println("Remove did not come");
        }

        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        String cartBadgeText = cartBadge.getText();
        if (cartBadgeText.equals("1")) {
            System.out.println("item added successfully!");
        } else {
            System.out.println("item was not added!");
        }

        WebElement cartButton = driver.findElement(By.className("shopping_cart_link"));
        cartButton.click();
        String cartCheckoutUrl = driver.getCurrentUrl();
        if (cartCheckoutUrl.equals("https://www.saucedemo.com/cart.html")) {
            System.out.println("checkout page did come");
        } else {
            System.out.println("checkout page did not come");
        }
        WebElement backPackItem = driver.findElement(By.className("inventory_item_name"));
        String backPackName = backPackItem.getText();
        if (backPackName.equals("Sauce Labs Backpack")) {
            System.out.println("item was found in cart");
        } else {
            System.out.println("item was not found in cart");
        }

        WebElement backPackPrice = driver.findElement(By.className("inventory_item_price"));
        String backPackPriceText = backPackPrice.getText();

        if (backPackPriceText.equals("$29.99")) {
            System.out.println("the price was correct");
        } else {
            System.out.println("The price was not correct");
        }
    }
}