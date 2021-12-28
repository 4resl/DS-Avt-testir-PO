package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
    protected final static long WAIT_TIMEOUT_SECONDS = 1000;


    public static WebElement getWebElementUntilWait(WebDriver driver, String elementPath){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                        .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath(elementPath)));
    }

    public static boolean isElementAttributeNotEmpty(WebDriver driver, String attribute, WebElement element){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions
                .attributeToBeNotEmpty(element,attribute));
    }

    public static boolean isPageUrlToBe(WebDriver driver, String url){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.urlToBe(url));
    }

}
