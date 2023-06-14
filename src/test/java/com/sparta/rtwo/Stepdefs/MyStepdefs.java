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
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

import static org.hamcrest.Matchers.containsString;

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
        loginPage.enterEmail("name@dtomain.com");
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
        Assertions.assertEquals("name@dtomain.com", signupPage.getEmail());
    }

    @Given("I am on the signup page")
    public void iAmOnTheSignupPage() {
        homePage = new HomePage(webDriver);
        loginPage = homePage.goToLoginPage();
        loginPage.enterName("name");
        loginPage.enterEmail("name@domaifffffn.com");
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

    @And("I enter my valid email address")
    public void iEnterMyValidEmailAddress() {
        loginPage.enterUserName("name@domain.com");
    }

    @And("the correct password")
    public void theCorrectPassword() {
        loginPage.enterUserPassword("password");
    }
    @And("click login")
    public void clickLogin() {
    }

    @Then("I can see that I am logged in")
    public void iCanSeeThatIAmLoggedIn() {
        var test = webDriver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a/b")).getText();
        MatcherAssert.assertThat(test, containsString("name"));
    }

    @And("an incorrect password")
    public void anIncorrectPassword() {
        loginPage.enterUserPassword("bad");
    }

    @Then("I will see the error message - your email or password is incorrect")
    public void iWillSeeTheErrorMessageYourEmailOrPasswordIsIncorrect() {
        var result = webDriver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p")).getText();
        MatcherAssert.assertThat(result, containsString("Your email or password is incorrect!"));
    }



}