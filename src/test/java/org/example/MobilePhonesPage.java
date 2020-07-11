package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobilePhonesPage {
    public WebDriver driver;
    public MobilePhonesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//span[text()='Xiaomi']")
    private WebElement xiaomiCheckbox;

    @FindBy(xpath = "//a[@title='Смартфон Xiaomi Redmi Note 8 Pro 6/64GB']")
    private WebElement redmiNoteModel;

    public void selectMobileCompany(String blockName) {
        xiaomiCheckbox.click();
    }

    public void selectModel(String modelName) {
        WebElement model;

        switch (modelName) {
            case "Redmi Note 8 Pro 6/64GB":
                model = redmiNoteModel;
                break;
            default:
                model = null;
                break;
        }

        model.click();
    }
}