package com.sparta.rtwo.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private final WebDriver webDriver;

    private By loginLink = new By.ByXPath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private By productLink = new By.ByLinkText(" Products");
    private By cartLink = new By.ByLinkText(" Cart");
    private By addToCartButton = new By.ByLinkText("Add to cart");
    public HomePage(WebDriver webDriver){
     this.webDriver = webDriver;
     goToHomePage();
    }

    private void goToHomePage(){
        webDriver.get("https://automationexercise.com/");
    }

    public LoginPage goToLoginPage(){
        webDriver.findElement(loginLink).click();
        return new LoginPage(webDriver);
    }

    public void goToProductPage(){
        webDriver.findElement(productLink).click();
        // write return
    }

    public void goToCartPage(){
        webDriver.findElement(cartLink).click();
        // write return
    }

    public void addToCart(){
        webDriver.findElement(addToCartButton).click();
        // write return
    }



}
