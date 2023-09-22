package proyecto.Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    static {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        // chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    public static void driverClose() {
        driver.close();
    }

    public WebElement find(String locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        } catch (StaleElementReferenceException r) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        }
    }

    public void clickElement(String locator) {
        try {
            find(locator).click();
        } catch (org.openqa.selenium.StaleElementReferenceException j) {
            WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            button.click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void write(String locator, String textWrite) {
        find(locator).clear();
        find(locator).sendKeys(textWrite);
    }

    public String textFromElement(String locator) {
        try {
            return find(locator).getText();
        } catch (StaleElementReferenceException j) {
            WebElement element = driver.findElement(By.xpath(locator));
            return element.getText();
        }
    }

    public boolean elementIsDisplayed(String locator) {
        try {
            return find(locator).isDisplayed();
        } catch (org.openqa.selenium.StaleElementReferenceException j) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            return find(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        } catch (TimeoutException x) {
            return false;
        }
    }

    public boolean elementIsEnabled(String locator) {
        return find(locator).isEnabled();
    }

    public List<WebElement> bringMeAElements(String locator) {
        return driver.findElements(By.className(locator));
    }

    public List<String> getAllList(String clase) {
        List<WebElement> list = bringMeAElements(clase);
        List<String> stringsFromList = new ArrayList<String>();
        for (WebElement e : list) {
            stringsFromList.add(e.getText());
        }
        return stringsFromList;
    }

}
