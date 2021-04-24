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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class UnscrambleStepDefs {

    UnscramblePage unscramblePage = new UnscramblePage();

    @Then("the number of words in the title and in the table should be equal")
    public void the_number_of_words_in_the_title_and_in_the_table_should_be_equal() {

        BrowserUtils.waitFor(3);
        String resultContainerText = new DashboardPage().resultContainer.getText();
        int value = Integer.parseInt(resultContainerText.replaceAll("[^0-9]", ""));
        int actualNumber = value - 1;
        System.out.println(actualNumber);


        int expectedNumber = new UnscramblePage().NumberOfWords.size();
        System.out.println(expectedNumber);

        Assert.assertEquals(expectedNumber, actualNumber);


    }

    @Given("the user is in the given page")
    public void the_user_is_in_the_given_page() {
        Driver.get().get(ConfigurationReader.get("url2"));
        BrowserUtils.waitFor(6);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security");
        System.out.println("*");
    }

    @When("the user sorts all words")
    public void the_user_sorts_all_words() {

        unscramblePage.sortButton.click();
        BrowserUtils.waitFor(3);
        unscramblePage.acceptButton.click();
        unscramblePage.sortButton.click();
        BrowserUtils.waitFor(4);
        unscramblePage.sortAllButton.click();
    }

    @Then("the user should see the word with the LEAST points")
    public void the_user_should_see_the_word_with_the_LEAST_points() {
        BrowserUtils.waitFor(3);
        unscramblePage.seeMore.click();
        BrowserUtils.waitFor(3);
        unscramblePage.seeAllWords.click();
        BrowserUtils.waitFor(2);
        System.out.println("Found the word is " + unscramblePage.leastPoints.getText());


    }

    @When("the user sort result by {string}")
    public void the_user_sort_result_by(String string) {
        BrowserUtils.waitFor(2);
        unscramblePage.sortButton.click();
        BrowserUtils.waitFor(4);
        unscramblePage.sortAZ.click();
        BrowserUtils.waitFor(3);
        unscramblePage.seeMore.click();
        BrowserUtils.waitFor(3);
        unscramblePage.seeAllWords.click();
        BrowserUtils.waitFor(2);


    }

    @Then("the user should see the sorted result")
    public void the_user_should_see_the_sorted_result() {
        //This list provided by page
        List<String> wordList = new ArrayList<String>();
        for (WebElement webElement : unscramblePage.tableOfWord) {
            wordList.add(webElement.getText());
        }
        System.out.println(wordList);

        List<String> sortedList = new ArrayList<>(wordList);
        Collections.sort(sortedList);
        System.out.println(sortedList);

        Assert.assertEquals(sortedList, wordList);
    }

    /**
     * This step is failed as the short functionality didn't work as expected
     */

    @When("the user sort results by {string}")
    public void the_user_sort_results_by(String string) {
        BrowserUtils.waitFor(2);
        unscramblePage.sortButton.click();
        BrowserUtils.waitFor(4);
        unscramblePage.sortZA.click();
        BrowserUtils.waitFor(3);
        unscramblePage.seeMore.click();
        BrowserUtils.waitFor(3);
        unscramblePage.seeAllWords.click();
        BrowserUtils.waitFor(2);
    }

    @Then("the user should see the sorted results")
    public void the_user_should_see_the_sorted_results() {
        BrowserUtils.waitFor(2);
        List<String> wordList = new ArrayList<String>();
        for (WebElement webElement : unscramblePage.tableOfWord) {
            wordList.add(webElement.getText());
        }

        System.out.println(wordList);
        List<String> sortedList = new ArrayList<>();

        for (int i = wordList.size() - 1; i >= 0; i--) {
            Collections.sort(wordList);
            sortedList.add(wordList.get(i));

        }
        System.out.println(wordList);
        System.out.println(sortedList);
        Assert.assertEquals(sortedList, wordList);

        /**
         * This step is failed as the short functionality didn't work as expected
         */
    }

}
