package com.sparta.rtwo.pom.pages;

import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
    WebDriver webDriver;
    public AccountCreatedPage(WebDriver webDriver) {
        this.webDriver=webDriver;
    }
    public String getUrl(){
        return webDriver.getCurrentUrl();
    }
}
