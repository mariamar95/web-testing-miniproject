package com.sparta.rtwo.Stepdefs;

import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class MyStepdefs {
    private  static ChromeDriverService service;
    private static WebDriver webDriver;
    @BeforeAll
    public static void setup() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();
        service.start();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        webDriver = new ChromeDriver(service, chromeOptions);
    }

}
