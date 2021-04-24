package com.lovetoknow.stepDefinitions;

import com.lovetoknow.pages.DashboardPage;
import com.lovetoknow.utilities.BrowserUtils;
import com.lovetoknow.utilities.ConfigurationReader;
import com.lovetoknow.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MainStepDefs {

    DashboardPage dashboardPage = new DashboardPage();


    @Given("the user is in the main page")
    public void the_user_is_in_the_main_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(6);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        System.out.println("*");

    }

    @When("the user searches for {string}")
    public void the_user_searches_for(String word) {
        dashboardPage.sendWords(word);
        System.out.println("**");
    }

    @Then("the page title should contains {string}")
    public void the_page_title_should_contains(String word) {
        String pageTitle = Driver.get().getTitle();
        BrowserUtils.waitFor(3);
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


}
