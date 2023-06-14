package com.sparta.rtwo.Stepdefs;

import com.sparta.rtwo.pom.pages.AccountCreatedPage;
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
    private AccountCreatedPage accountCreatedPage;


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
        homePage = new HomePage(webDriver);
        loginPage = homePage.goToLoginPage();
    }

    @When("I enter a name")
    public void iEnterAName() {
        loginPage.enterName("name");
    }

    @And("email address")
    public void emailAddress() {
        loginPage.enterEmail("name@domain.com");
    }

    @And("click signup")
    public void clickSignup() {
        signupPage = loginPage.clickSignUp();
    }

    @Then("I am directed to the signup page")
    public void iAmDirectedToTheSignupPage() {
        Assertions.assertEquals("https://automationexercise.com/signup", signupPage.getUrl());
    }

    @And("The name filed contain the name entered")
    public void theNameFiledContainTheNameEntered() {
        Assertions.assertEquals("name",signupPage.getName());

    }

    @And("The email field contain the email entered")
    public void theEmailFieldContainTheEmailEntered() {
        Assertions.assertEquals("name@domain.com", signupPage.getEmail());
    }

    @Given("I am on the signup page")
    public void iAmOnTheSignupPage() {
        homePage = new HomePage(webDriver);
        loginPage = homePage.goToLoginPage();
        loginPage.enterName("name");
<<<<<<< HEAD
        loginPage.enterEmail("name@domain.com");
=======
        loginPage.enterEmail("name@domafin.com");
>>>>>>> b8ac5951ac9fccd74e76411d8643c7eb3e0dd96a
        signupPage = loginPage.clickSignUp();
    }

    @When("I select my title")
    public void iSelectMyTitle() {
        signupPage.selectTitle();
    }

    @And("enter a password")
    public void enterAPassword() {
        signupPage.enterPassword("password");
    }

    @And("select my date of birth")
    public void selectMyDateOfBirth() {
        signupPage.dateDropDownSelect("1","January","2000");
    }

    @And("enter my first name")
    public void enterMyFirstName() {
        signupPage.enterFirstName("firstname");
    }

    @And("enter my last name")
    public void enterMyLastName() {
        signupPage.enterLastName("lastname");
    }

    @And("enter my address")
    public void enterMyAddress() {
        signupPage.enterAddress("123 lane");
    }

    @And("select my country")
    public void selectMyCountry() {
        signupPage.countryDropDownSelect("Singapore");
    }

    @And("enter my state")
    public void enterMyState() {
        signupPage.enterState("State");
    }

    @And("enter my city")
    public void enterMyCity() {
        signupPage.enterCity("London");
    }

    @And("enter my zip code")
    public void enterMyZipCode() {
        signupPage.enterZipcode("123");
    }

    @And("enter my phone number")
    public void enterMyPhoneNumber() {
        signupPage.enterPhone("123456");
    }

    @And("click create account")
    public void clickCreateAccount() {
        signupPage.clickCreateAccount();
    }

    @Then("I will be  redirected to a page account created")
    public void iWillBeRedirectedToAPageAccountCreated() {

        Assertions.assertEquals("https://automationexercise.com/account_created",webDriver.getCurrentUrl());

    }
}
