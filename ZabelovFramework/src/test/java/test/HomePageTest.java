package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;

public class HomePageTest extends CommonConditions{

    private static final int PRESS_AMOUNT = 3;
    private static final String EXPECTED_FLY_TYPE = "бизнес";
    @Test
    public void checkBusinessClassButton(){
        String flyType = new HomePage(driver)
                .openPage()
                .pressPeopleInputButton()
                .pressBusinessClassButton()
                .getFlyType();
    }

    @Test
    public void checkAddKidButtonTest() {
        int actualPerson = new HomePage(driver)
                .openPage()
                .pressPeopleInputButton()
                .pressAddKidButton(PRESS_AMOUNT)
                .getPersonAmount();
        Assert.assertEquals(actualPerson, PRESS_AMOUNT + 1);
    }


    @Test
    public void findTripWithNoDataTest(){
        String message = "Укажите город прилета";
        String actualMessage = new HomePage(driver)
                .openPage()
                .pressFindButton()
                .getMessageInput();
        Assert.assertEquals(actualMessage, message);
    }


}
