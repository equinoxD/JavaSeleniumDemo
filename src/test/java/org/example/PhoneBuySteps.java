package org.example;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PhoneBuySteps {
    public static WebDriver driver;
    public static WebDriverWait wait;

    StartPage startPage;
    CatalogPage catalogPage;
    MobilePhonesPage mobilePhonesPage;
    PhoneModelPage phoneModelPage;

    @Before
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,30);
        driver.manage().window().maximize();
    }

    @Дано("^Открыта стартовая страница Яндекс-Маркета$")
    public void ОткрытаСтартоваяСтраницаЯндекса() throws Throwable {
        driver.get("https://market.yandex.ru/");
    }

    @Когда("^Пользователь выбирает каталог \"(.*)\"$")
    public void ПользовательВыбираетКаталог(String catalogName) throws Throwable {
        startPage = new StartPage(driver);
        startPage.selectCatalog(catalogName);
    }

    @Когда("^Пользователь выбирает раздел \"(.*)\"$")
    public void ПользовательВыбираетРаздел(String blockName) throws Throwable {
        catalogPage = new CatalogPage(driver);
        catalogPage.selectBlock(blockName);
    }

    @Когда("^Пользователь фильтрует телефоны по производителю \"(.*)\"$")
    public void ПользовательВыбираетТелефон(String mobileCompany) throws Throwable {
        mobilePhonesPage = new MobilePhonesPage(driver);
        mobilePhonesPage.selectMobileCompany(mobileCompany);
    }

    @Когда("^Пользователь выбирает модель телефона \"(.*)\"$")
    public void ПользовательВыбираетМодель(String modelName) throws Throwable {
        mobilePhonesPage.selectModel(modelName);
    }

    @Тогда("^В новом окне открывается страница модели телефона \"(.*)\"$")
    public void ОткрываетсяСтарницаМоделиТелефона(String modelName) throws Throwable {
        phoneModelPage = new PhoneModelPage(driver);
        phoneModelPage.moveToOpenedTab();
        phoneModelPage.loaded(modelName);
    }

    @Тогда("^Страница модели телефона содержит вкладку \"(.*)\"$")
    public void СтраницаМоделиТелефонаСодержитВкладку(String tabName) throws Throwable {
        phoneModelPage.containsTab(tabName);
    }

    @Когда("^Пользователь переходит на вкладку \"(.*)\"$")
    public void ПользовательПереходитНаВкладку(String tabName) throws Throwable {
        phoneModelPage.openTab(tabName);
    }

    @Тогда("^Пользователь видит характеристику \"(.*)\" со значением \"(.*)\"$")
    public void ПользовательВидитХарактеристикуСоЗначением(String specName, String specValue) throws Throwable {
        phoneModelPage.assertFieldValue(specName, specValue);
    }

    @After
    public void embedScreenshot(Scenario scenario) {
        if(scenario.isFailed()) {
        }

        driver.quit();
    }
}
