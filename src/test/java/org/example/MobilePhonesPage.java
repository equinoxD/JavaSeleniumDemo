package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.assertj.core.api.Assertions.*;

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

    @FindBy(xpath = "//a[@title='Смартфон Xiaomi Redmi 8 4/64GB']")
    private WebElement redmiModel;

    public void selectMobileCompany(String blockName) {
        xiaomiCheckbox.click();
    }

    public void selectModel(String modelName) {
        WebElement modelElement = null;

        switch (modelName) {
            case "Смартфон Xiaomi Redmi Note 8 Pro 6/64GB":
                modelElement = redmiNoteModel;
                break;
            case "Смартфон Xiaomi Redmi 8 4/64GB":
                modelElement = redmiModel;
                break;
        }

        assertThat(modelElement)
                .isNotNull();

        modelElement.click();
    }
}