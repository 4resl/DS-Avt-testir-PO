package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;

public class OrderPageTest extends CommonConditions{
    private static final String ERROR_MESSAGE_TEXT = "Заказ не найден. Проверьте правильность данныx.";

    @Test
    public void findOrderWithoutData(){
        HomePage homePage = new HomePage(driver);
        String errorMessageActual =
                homePage
                .openPage()
                .pressOrderButton()
                .pressFindButton()
                .getErrorMessage();

        Assert.assertEquals(errorMessageActual, ERROR_MESSAGE_TEXT);
    }
}
