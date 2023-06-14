package com.sparta.rtwo.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final By usernameBy = new By.ByXPath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
    private final By passwordBy = new By.ByName("password");
    private final By loginButtonBy = new By.ByClassName("btn btn-default");
    private final By name = new By.ByName("name");
    private final By email = new By.ByXPath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
    //    private final By signUpButton = new By.ByLinkText("Signup");
    private final By signUpButton = new By.ByXPath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");

    WebDriver webDriver;
    public LoginPage(WebDriver webdriver){
        this.webDriver = webdriver;
    }
    public String getUrl(){
        return webDriver.getCurrentUrl();
    }
    public void enterName(String nameInput){
        webDriver.findElement(name).sendKeys(nameInput);
    }
    public void enterEmail(String emailInput){
        webDriver.findElement(email).sendKeys(emailInput);
    }
    public SignupPage clickSignUp(){
        webDriver.findElement(signUpButton).click();
        return new SignupPage(webDriver);
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
