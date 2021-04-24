package com.lovetoknow.pages;

import com.lovetoknow.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);

    }

}

