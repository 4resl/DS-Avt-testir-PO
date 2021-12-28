package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waits;

import java.nio.charset.StandardCharsets;

public class HomePage extends AbstractPage{

    private static final String PAGE_URL = "https://www.kupibilet.ru/";
    private static final String LANGUAGE_BUTTON = "//*[@id=\"app-wrap\"]//span[@class=\"Link__StyledLink-sc-11oz7j-0 styled__StyledLink-sc-109fpwc-4 iKjYbO\"]";
    private static final String TO_INPUT = "//*[@id=\"app-wrap\"]//input[@class=\"AutosuggestInput__StyledInput-mg4g1v-0 crftZb react-autosuggest__input\"]";
    private static final String FIND_BUTTON = "//*[@id=\"app-wrap\"]//button[@class=\"styled__StyledButton-sc-1c07g7v-0 gcwxqw styled__StyledButton-bhjwqp-0 kECTBX\"]";
    private static final String PEOPLE_INPUT = "//*[@id=\"app-wrap\"]//div[@class=\"styled__Wrapper-sc-1odhm9o-0 iPLCdl\"]";
    private static final String ADD_KID_BUTTON = "//*[@id=\"app-wrap\"]//div[@class=\"styled__InlineFlexBoxContainer-sc-1h5s2t7-5 kyWRfn\"]/button[2]";
    private static final String TOTAL_PEOPLE = "//*[@id=\"app-wrap\"]//span[@class=\"Text-sc-1gcz4xx-0 FormTypography__FormBoldText-sc-1ybzmlc-0 hmjYvF\"]";
    private static final String BUSINESS_CLASS_POINT = "//*[@id=\"app-wrap\"]//label[@class=\"styled__CheckboxLabel-wgrbkn-4 coYlIF\"]";
    private static final String FLY_TYPE = "//*[@id=\"app-wrap\"]//span[@class=\"Text-sc-1gcz4xx-0 FormTypography__FormSecondaryText-sc-1ybzmlc-1 fxfvZn\"]";
    private static final String CHANGE_LANGUAGE_BUTTON = "//*[@id=\"app-wrap\"]//div[@class=\"styled__StyledSuggestion-sc-109fpwc-1 hwRPmx\"]";

    @FindBy(xpath = FIND_BUTTON)
    private WebElement findButton;


    @FindBy(xpath = ADD_KID_BUTTON)
    private WebElement addKidButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public HomePage openPage(){
        driver.get(PAGE_URL);
        return this;
    }

    public HomePage pressFindButton(){
        findButton.click();
        return this;
    }

    public HomePage pressPeopleInputButton(){
        Waits.getWebElementUntilWait(driver,PEOPLE_INPUT).click();
        Waits.getWebElementUntilWait(driver,PEOPLE_INPUT).click();
        return this;
    }

    public HomePage pressAddKidButton(int amountPress) {
        for(int i = 0; i < amountPress; i++){
            addKidButton.click();
        }

        return this;
    }

    public HomePage pressBusinessClassButton(){
        Waits.getWebElementUntilWait(driver, BUSINESS_CLASS_POINT).click();
        return this;
    }

    public String getFlyType(){
        return new String(Waits.getWebElementUntilWait(driver,FLY_TYPE).getText()
                    .getBytes(StandardCharsets.UTF_8));
    }

    public int getPersonAmount(){
        return Integer.parseInt(Waits.getWebElementUntilWait(driver, TOTAL_PEOPLE).getText().substring(0,1));
    }

    public String getMessageInput(){

        return new String(Waits.getWebElementUntilWait(driver,TO_INPUT).getAttribute("placeholder").getBytes(StandardCharsets.UTF_8));
    }
}
