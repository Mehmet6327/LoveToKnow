package com.lovetoknow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UnscramblePage extends BasePage{

    @FindBy(xpath = "//div[@class='table__cell table__cell--first']")

    public List<WebElement> NumberOfWords;


}
