package org.example.pages;

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

    @FindBy(xpath = "//h1[text()='Смартфон Xiaomi Redmi 8 4/64GB']")
    private WebElement redmiHeader;

    @FindBy(xpath = "//span[text()='Характеристики']")
    private WebElement tabSpecifications;

    @FindBy(xpath = "//span[text()='Вес']/ancestor::dl//dd")
    private WebElement fieldPhoneWeightValue;

    @FindBy(xpath = "//span[text()='Размеры (ШxВxТ)']/ancestor::dl//dd")
    private WebElement fieldPhoneSizeValue;

    public void moveToOpenedTab() {
        ArrayList tabs = new ArrayList (driver.getWindowHandles());
        int lastTabIndex = tabs.size() - 1;
        driver.switchTo().window((String) tabs.get(lastTabIndex));
    }

    public void loaded(String modelName) {
        WebElement headerElement = null;

        switch (modelName) {
            case "Смартфон Xiaomi Redmi Note 8 Pro 6/64GB":
                headerElement = redmiNoteHeader;
                break;
            case "Смартфон Xiaomi Redmi 8 4/64GB":
                headerElement = redmiHeader;
                break;
        }

        assertThat(headerElement)
                .isNotNull();

        headerElement.isDisplayed();
    }

    public void containsTab(String tabName) {
        tabSpecifications.isDisplayed();
    }

    public void openTab(String tabName) {
        tabSpecifications.click();
    }

    public void assertFieldValue(String fieldName, String fieldValue) {
        WebElement valueElement = null;

        switch (fieldName) {
            case "Вес":
                valueElement = fieldPhoneWeightValue;
                break;
            case "Размеры (ШxВxТ)":
                valueElement = fieldPhoneSizeValue;
                break;
        }

        assertThat(valueElement)
                .isNotNull();

        assertThat(valueElement.getText())
                .isEqualTo(fieldValue);
    }
}