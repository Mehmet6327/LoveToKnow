package com.lovetoknow.pages;

import org.jsoup.select.Evaluator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UnscramblePage extends BasePage{

    @FindBy(xpath = "//div[@class='table__cell table__cell--first']")
    public List<WebElement> NumberOfWords;


    @FindBy(xpath = "//span[text()[normalize-space()='Sort by']]")
    public WebElement sortButton;


    @FindBy(xpath = "//*[contains(text(),'All words')]")
    public WebElement sortAllButton;


    @FindBy(id = "onetrust-accept-btn-handler")
    public WebElement acceptButton;

    @FindBy(xpath = "//button[text()[normalize-space()='See More Words']]")
    public WebElement seeMore;

    @FindBy(xpath = "//button[text()[normalize-space()='See All Words']]")
    public WebElement seeAllWords;

    @FindBy(xpath = "//div[@id='table_container_36']/div[1]/div[2]/div[108]")
    public WebElement leastPoints;

    @FindBy(xpath = "//*[contains(text(),'A to Z')]")
    public WebElement sortAZ;

    @FindBy(xpath = "//*[@*='table__cell table__cell--first']")
    public List<WebElement> tableOfWord;

    @FindBy(xpath = "//*[contains(text(),'Z to A')]")
    public WebElement sortZA;





}
