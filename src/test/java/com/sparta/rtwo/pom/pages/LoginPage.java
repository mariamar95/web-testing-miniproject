package com.sparta.rtwo.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final By usernameBy = new By.ByName("email");
    private final By passwordBy = new By.ByName("password");
    private final By loginButtonBy = new By. ByLinkText("Login");

    WebDriver webDriver;
    public LoginPage(WebDriver webdriver){
        this.webDriver = webdriver;
    }
    public String getUrl(){
        return webDriver.getCurrentUrl();
    }
    public void enterUserName(String username) {
        var userNameBox = webDriver.findElement(usernameBy);
        userNameBox.sendKeys(username);
    }
    public void enterUserPassword(String password){
        var passwordBox = webDriver.findElement(passwordBy);
        passwordBox.sendKeys(password);

    }
    public void clickLogin(){
        var loginButton = webDriver.findElement(loginButtonBy);
        loginButton.click();
    }



}
