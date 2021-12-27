package page;

import model.Passenger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Waits;

import java.nio.charset.StandardCharsets;

public class PersonalDataPage extends AbstractPage{

    private static final String PAGE_PAYMENT_URL = "https://biletix.ru/payment/";
    private static final String PAY_BUTTON_XPATH = "//*[@id=\"btnGoToPayment\"]";
    private static final String ERROR_NAME_XPATH = "//div[@class=\"passenger__error\"]";
    private static final String ERROR_PASSENGER_DATA_XPATH = "//div[@class=\"popup-error__description\"]";
    private static final String SURNAME_INPUT_XPATH = "//*[@id=\"surname_adult_1\"]";
    private static final String NAME_INPUT_XPATH = "//*[@id=\"name_adult_1\"]";
    private static final String BIRTH_INPUT_XPATH = "//*[@id=\"birthdate_adult_1\"]";
    private static final String DOCUMENT_TYPE_XPATH = "//*[@id=\"doctype_adult_1\"]/a";
    private static final String DOCUMENT_TYPE_PASSPORT_XPATH = "//*[@id=\"doctype_adult_1\"]//div[@class=\"item\"]";
    private static final String DOCUMENT_INPUT_XPATH = "//*[@id=\"docnumber_adult_1\"]";
    private static final String PHONE_INPUT_XPATH = "//*[@id=\"number\"]";
    private static final String MAIL_INPUT_XPATH = "//*[@id=\"letter\"]";
    private static final String MESSAGE_FOR_PAY = "//*[@id=\"app_wl_avia_breadcrumbs\"]/div[@class=\"active\"]";

    private JavascriptExecutor js;


    @FindBy(xpath = PAY_BUTTON_XPATH)
    private WebElement payButton;

    @FindBy(xpath = SURNAME_INPUT_XPATH)
    private WebElement surnameInput;

    @FindBy(xpath = NAME_INPUT_XPATH)
    private WebElement nameInput;

    @FindBy(xpath = BIRTH_INPUT_XPATH)
    private WebElement birthInput;

    @FindBy(xpath = DOCUMENT_TYPE_XPATH)
    private WebElement docType;

    @FindBy(xpath = DOCUMENT_TYPE_PASSPORT_XPATH)
    private WebElement docTypePassport;

    @FindBy(xpath = DOCUMENT_INPUT_XPATH)
    private WebElement documentInput;

    @FindBy(xpath = PHONE_INPUT_XPATH)
    private WebElement phoneInput;

    @FindBy(xpath = MAIL_INPUT_XPATH)
    private WebElement mailInput;


    public PersonalDataPage(WebDriver driver){
        super(driver);
        js = (JavascriptExecutor) driver;
    }

    public PersonalDataPage fillPassengerForm(Passenger passenger){
        surnameInput.sendKeys(passenger.getSurname());
        nameInput.sendKeys(passenger.getName());
        birthInput.sendKeys(passenger.getBirthDate());
        js.executeScript("arguments[0].click();",docType);
        js.executeScript("arguments[0].click();",docTypePassport);
        documentInput.sendKeys(passenger.getDocumentNumber());
        phoneInput.sendKeys(passenger.getPhoneNumber());
        mailInput.sendKeys(passenger.getMail());
        return this;
    }

    public PersonalDataPage pressPayButton() {
        js.executeScript("arguments[0].click();",payButton);
        return this;
    }

    public String getMessageForPay() {
        Waits.isPageUrlToBe(driver, PAGE_PAYMENT_URL);
        return new String(Waits.getWebElementUntilWait(driver,MESSAGE_FOR_PAY)
                .getText()
                .getBytes(StandardCharsets.UTF_8));
    }

    public String getErrorDataMessage(){
        return new String(Waits.getWebElementUntilWait(driver,ERROR_PASSENGER_DATA_XPATH)
                .getText()
                .getBytes(StandardCharsets.UTF_8));
    }

    public String getErrorNameMessage(){
        return new String(Waits.getWebElementUntilWait(driver,ERROR_NAME_XPATH)
                .getText()
                .getBytes(StandardCharsets.UTF_8));
    }


}
