package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage {
    public WebDriver driver;
    public CatalogPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//ul//a[text()='Мобильные телефоны']")
    private WebElement blockMobilePhones;

    public void selectBlock(String blockName) {
        blockMobilePhones.click();
    }
}