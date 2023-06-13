package com.sparta.rtwo;


import com.sparta.rtwo.pom.pages.HomePage;
import com.sparta.rtwo.pom.pages.SignupPage;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

import static org.hamcrest.Matchers.*;

public class CarlynJUnitTests {
    private static ChromeDriverService service;
    private static WebDriver webDriver;
    private HomePage homePage;
    private SignupPage signUp;

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

    @BeforeEach
    public void setupEach() {
        signUp = new SignupPage (webDriver);

    }
    @Test
    @DisplayName("test signup 1")
    public void testSignupOne() {
        var username = "test";
        signUp.enterInitialDetails(username, "ttttt@ttttt.com");
        signUp.selectTitle();
        signUp.enterPassword("testpassword");
        signUp.dateDropDownSelect("2", "March", "2014");
        signUp.enterFirstName("firstname");
        signUp.enterLastName("lastname");
        signUp.enterAddress("123 fake road");
        signUp.countryDropDownSelect("Singapore");
        signUp.enterState("fakestate");
        signUp.enterCity("faketown");
        signUp.enterZipcode("12345");
        signUp.enterPhone("0123435354");
        signUp.clickCreateAccount();
        signUp.createAccountContinue();
        var test = webDriver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b")).getText();
        MatcherAssert.assertThat(test, containsString(username));
    }



    @AfterEach
    public void teardown() {
        webDriver.get("https://automationexercise.com/delete_account");
        webDriver.close();

    }

    @AfterAll
    public static void tearDownAll() {
        webDriver.quit();
        service.stop();
    }
}