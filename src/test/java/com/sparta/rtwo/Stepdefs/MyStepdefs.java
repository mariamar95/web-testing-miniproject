package com.sparta.rtwo.Stepdefs;

import com.sparta.rtwo.pom.pages.HomePage;
import com.sparta.rtwo.pom.pages.LoginPage;
import com.sparta.rtwo.pom.pages.SignupPage;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class MyStepdefs {
    private HomePage homePage;
    private LoginPage loginPage;
    private SignupPage signupPage;


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
    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homePage = new HomePage(webDriver);
    }

    @When("I click on the signup_login button")
    public void iClickOnTheSignupLoginButton() {
        loginPage = homePage.goToLoginPage();
    }

    @Then("I will be directed to the login page")
    public void iWillBeDirectedToTheLoginPage() {
        Assertions.assertEquals("https://automationexercise.com/login", loginPage.getUrl());
    }

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
    }

    @When("I enter a name")
    public void iEnterAName() {
    }

    @And("email address")
    public void emailAddress() {
    }

    @And("click signup")
    public void clickSignup() {
    }

    @Then("I am directed to the signup page")
    public void iAmDirectedToTheSignupPage() {
    }

    @And("The name filed contain the name entered")
    public void theNameFiledContainTheNameEntered() {
    }

    @And("The email field contain the email entered")
    public void theEmailFieldContainTheEmailEntered() {
    }

    @Given("I am on the signup page")
    public void iAmOnTheSignupPage() {
    }

    @When("I select my title")
    public void iSelectMyTitle() {
    }

    @And("enter a password")
    public void enterAPassword() {
    }

    @And("select my date of birth")
    public void selectMyDateOfBirth() {
    }

    @And("enter my first name")
    public void enterMyFirstName() {
    }

    @And("enter my last name")
    public void enterMyLastName() {
    }

    @And("enter my address")
    public void enterMyAddress() {
    }

    @And("select my country")
    public void selectMyCountry() {
    }

    @And("enter my state")
    public void enterMyState() {
    }

    @And("enter my city")
    public void enterMyCity() {
    }

    @And("enter my zip code")
    public void enterMyZipCode() {
    }

    @And("enter my phone number")
    public void enterMyPhoneNumber() {
    }

    @And("click create account")
    public void clickCreateAccount() {
    }

    @Then("I will be  redirected to a page account created")
    public void iWillBeRedirectedToAPageAccountCreated() {
    }
}
