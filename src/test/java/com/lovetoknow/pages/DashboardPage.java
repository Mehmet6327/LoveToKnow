package com.lovetoknow.pages;


import com.lovetoknow.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class DashboardPage extends  BasePage{
    public DashboardPage() {
        PageFactory.initElements(Driver.get(), this);

    }

    @FindBy(id = "blue_scrabble_search_input")
    public WebElement searchinputbox;

    @FindBy(xpath = "//div[@class='advanced-search-fields-wrapper--new-design']/following-sibling::div[1]")
      public WebElement searchButton;

    @FindBy(className = "results-heading")
    public  WebElement resultContainer;

    @FindBy(xpath = "//*[text(),'back to top']")
    public  WebElement backToTopButton;







    public void sendWords(String word){
        searchinputbox.click();
        searchinputbox.sendKeys(word);
        searchinputbox.sendKeys(Keys.ENTER);





        }
        public boolean isDisplayed(WebElement backToTopButton) {
            try {
                return backToTopButton.isDisplayed();
            } catch (NoSuchElementException e) {
                return false;
            }
        }


}

