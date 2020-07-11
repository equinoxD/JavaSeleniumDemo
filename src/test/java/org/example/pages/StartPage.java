package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage{
    public WebDriver driver;
    public StartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div//span[text()='Электроника']")
    private WebElement catalogElectronic;

    public void selectCatalog(String catalogName) {
        catalogElectronic.click();
    }
}
