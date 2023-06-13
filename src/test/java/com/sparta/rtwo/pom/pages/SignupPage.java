package com.sparta.rtwo.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {

    //   https://automationexercise.com/signup
    private WebDriver webDriver;
    private final By name = new By.ByName("name");
    private final By email = new By.ByName("email");
    private final By signUpButton = new By.ByLinkText("Signup");
    private final By title = new By.ById("id_gender2");
    private final By password = new By.ById("password");
    private final By dobDayDropDown = new By.ById("days");
    private final By dobMonthDropDown = new By.ById("months");
    private final By dobYearDropDown = new By.ById("years");
    private final By firstName = new By.ById("first_name");
    private final By lastName = new By.ById("last_name");
    private final By address = new By.ById("address1");
    private final By countryDropDown = new By.ById("country");
    private final By state =  new By.ById("state");
    private final By city = new By.ById("city");
    private final By zipcode = new By.ById("zipcode");
    private final By phone = new By.ById("mobile_number");
    private final By createAccountButton = new By.ByXPath("[@id=\"form\"]");

    private SignupPage(WebDriver webDriver){
        this.webDriver = webDriver;
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
    public void clickSignIn(){
        webDriver.findElement(signUpButton).click();
    }
    public void selectTitle(){
        webDriver.findElement(title).click();
    }
}
