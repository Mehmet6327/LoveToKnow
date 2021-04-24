package com.lovetoknow.stepDefinitions;

import com.lovetoknow.pages.DashboardPage;
import com.lovetoknow.pages.UnscramblePage;
import com.lovetoknow.utilities.BrowserUtils;
import com.lovetoknow.utilities.ConfigurationReader;
import com.lovetoknow.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainStepDefs {

    DashboardPage dashboardPage = new DashboardPage();
    String validationMessage;


    @Given("the user is in the main page")
    public void the_user_is_in_the_main_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        System.out.println("*");

    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String word) {
        dashboardPage.sendWords(word);
        System.out.println("**");
    }

    @Then("the page title should contains {string}")
    public void the_page_title_should_contains(String word) {
        BrowserUtils.waitForPageToLoad(10);
        String pageTitle = Driver.get().getTitle();
        System.out.println(pageTitle);
        System.out.println(word);
        Assert.assertTrue(pageTitle.toLowerCase().contains(word.toLowerCase()));
        System.out.println("***");

    }

    @Then("the {string} should be visible on the page")
    public void the_should_be_visible_on_the_page(String word) {
        String actualHeading = dashboardPage.resultContainer.getText();
        Assert.assertTrue(actualHeading.toLowerCase().contains(word.toLowerCase()));
        System.out.println("****");
    }


    @When("the user scroll down to the bottom")
    public void the_user_scroll_down_to_the_bottom() {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");


    }

    @Then("“back to top”button is not shown in the browser")
    public void back_to_top_button_is_not_shown_in_the_browser() {

        Boolean isPresent = Driver.get().findElements(By.id("back to top")).size() > 0;
        Assert.assertFalse(isPresent);


    }

    @When("the user enters {string}")
    public void the_user_enters(String string) {
        dashboardPage.length.click();
        BrowserUtils.waitFor(4);
        UnscramblePage unscramblePage = new UnscramblePage();
        List<WebElement> button = Driver.get().findElements(By.id("onetrust-accept-btn-handler"));


        if (button.size() >0 ){
            unscramblePage.acceptButton.click();

        }


        System.out.println(string);
        dashboardPage.length.sendKeys(string, Keys.ENTER);
        BrowserUtils.waitFor(2);
        validationMessage = dashboardPage.length.getAttribute("validationMessage");

    }


    @Then("the user should be asked to correct the input")
    public void the_user_should_be_asked_to_correct_the_input() {
        Assert.assertTrue(validationMessage.contains("Value must be"));

    }


}
