package com.sparta.rtwo.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {

    //   https://automationexercise.com/signup
    // https://automationexercise.com/account_created
    private WebDriver webDriver;
    private Select select;
    private final By name = new By.ByName("name");
    private final By email = new By.ByXPath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
    //    private final By signUpButton = new By.ByLinkText("Signup");
    private final By signUpButton = new By.ByXPath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
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
    private final By createAccountButton = new By.ByXPath("//*[@id=\"form\"]/div/div/div/div/form/button");
    private final By continueButton = new By.ByXPath("//*[@id=\"form\"]/div/div/div/div/a");
    private final By getName = new By.ByXPath("//*[@id=\"name\"]");
    private final By getEmail = new By.ByXPath("//*[@id=\"email\"]");



    public SignupPage(WebDriver webDriver){
        this.webDriver = webDriver;
//        webDriver.get("https://automationexercise.com/signup");

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
    public void enterPassword(String passwordInput){
        webDriver.findElement(password).sendKeys(passwordInput);
    }
    public void enterFirstName(String firstNameInput){
        webDriver.findElement(firstName).sendKeys(firstNameInput);
    }
    public void enterLastName(String lastNameInput){
        webDriver.findElement(lastName).sendKeys(lastNameInput);
    }
    public void enterAddress(String addressInput){
        webDriver.findElement(address).sendKeys(addressInput);
    }
    public void enterState(String stateInput){
        webDriver.findElement(state).sendKeys(stateInput);
    }
    public void enterCity(String cityInput){
        webDriver.findElement(city).sendKeys(cityInput);
    }
    public void enterZipcode(String zipcodeInput){
        webDriver.findElement(zipcode).sendKeys(zipcodeInput);
    }
    public void enterPhone(String phoneInput){
        webDriver.findElement(phone).sendKeys(phoneInput);
    }
    public AccountCreatedPage clickCreateAccount(){
        webDriver.findElement(createAccountButton).click();
        return new AccountCreatedPage(webDriver);
    }

    public void enterInitialDetails(String name, String email){
        enterName(name);
        enterEmail(email);
        clickSignIn();
    }
    public void dateDropDownSelect(String day, String month, String year){
        new Select (webDriver.findElement(dobDayDropDown)).selectByVisibleText(day);
        new Select (webDriver.findElement(dobMonthDropDown)).selectByVisibleText(month);
        new Select (webDriver.findElement(dobYearDropDown)).selectByVisibleText(year);
    }
    public void countryDropDownSelect(String country){
        new Select (webDriver.findElement(countryDropDown)).selectByVisibleText(country);

    }
    public void createAccountContinue(){
        webDriver.findElement(continueButton).click();
    }
    public String getName(){
        return webDriver.findElement(getName).getAttribute("value");
    }
    public String getEmail(){
        return webDriver.findElement(getEmail).getAttribute("value");
    }




}
