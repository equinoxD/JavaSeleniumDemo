package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.assertj.core.api.Assertions.*;

import java.sql.Struct;
import java.util.ArrayList;

public class PhoneModelPage {
    public WebDriver driver;
    public PhoneModelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//h1[text()='Смартфон Xiaomi Redmi Note 8 Pro 6/64GB']")
    private WebElement redmiNoteHeader;

    @FindBy(xpath = "//span[text()='Характеристики']")
    private WebElement tabSpecifications;

    @FindBy(xpath = "//span[text()='Тип']")
    private WebElement fieldPhoneType;

    @FindBy(xpath = "//span[text()='Тип']/ancestor::dl//dd")
    private WebElement fieldPhoneTypeValue;

    public void moveToOpenedTab() {
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        int lastTabIndex = tabs.size() - 1;
        driver.switchTo().window((String) tabs.get(lastTabIndex));
    }

    public void loaded(String modelName) {
        WebElement header;

        switch (modelName) {
            case "Redmi Note 8 Pro 6/64GB":
                header = redmiNoteHeader;
                break;
            default:
                header = null;
                break;
        }

        header.isDisplayed();
    }

    public void containsTab(String tabName) {
        tabSpecifications.isDisplayed();
    }

    public void openTab(String tabName) {
        tabSpecifications.click();
    }

    public void assertFieldValue(String fieldName, String fieldValue) {
        WebElement valueElement;

        switch (fieldName) {
            case "Тип":
                valueElement = fieldPhoneTypeValue; break;
            default:
                valueElement = null; break;
        }

        assertThat(valueElement.getText())
                .isEqualTo(fieldValue);
    }
}