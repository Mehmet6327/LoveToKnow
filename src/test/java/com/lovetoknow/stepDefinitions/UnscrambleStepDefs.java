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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UnscrambleStepDefs {


    @Then("the number of words in the title and in the table should be equal")
    public void the_number_of_words_in_the_title_and_in_the_table_should_be_equal() {

        BrowserUtils.waitFor(3);
        String resultContainerText = new DashboardPage().resultContainer.getText();
        int value = Integer.parseInt(resultContainerText.replaceAll("[^0-9]", ""));
        int actualNumber = value-1;
        System.out.println(actualNumber);



        int expectedNumber = new UnscramblePage().NumberOfWords.size();
        System.out.println(expectedNumber);

        Assert.assertEquals(expectedNumber,actualNumber);


    }
    @Given("the user is in the given page")
    public void the_user_is_in_the_given_page() {
        Driver.get().get(ConfigurationReader.get("url2"));
        BrowserUtils.waitFor(6);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        ChromeDriver driver = new ChromeDriver(options);
        System.out.println("*");
    }

    @When("the user sorts all words")
    public void the_user_sorts_all_words() {

    }

    @Then("the user should see the word with the LEAST points")
    public void the_user_should_see_the_word_with_the_LEAST_points() {

    }



}
