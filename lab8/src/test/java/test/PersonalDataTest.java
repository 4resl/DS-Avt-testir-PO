package test;

import model.Passenger;
import model.Travel;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import service.PassengerCreator;
import service.TravelCreator;

public class PersonalDataTest extends CommonConditions{

    private static final String ERROR_INPUT_NAME = "Введите имя";
    private static final String ERROR_INPUT_DATA = "Некорректные данные пассажира.";
    private static final String MESSAGE_FOR_PAY = "Способы оплаты";

    @Test
    public void registrationWithoutDataTest()  {

        Travel travelForm = TravelCreator.createFormWithData();
        HomePage homePage = new HomePage(driver);
        String actualError = homePage
                .openPage()
                .fillSearchForm(travelForm)
                .pressFindButton()
                .selectResult()
                .pressPayButton()
                .getErrorNameMessage();

        Assert.assertEquals(ERROR_INPUT_NAME, actualError);
    }

    @Test
    public void registrationWithIncorrectDataTest() {
        Travel travel = TravelCreator.createFormWithData();
        Passenger passenger = PassengerCreator.createPassengerWithIncorrectData();
        HomePage homePage = new HomePage(driver);
        String actualError = homePage
                .openPage()
                .fillSearchForm(travel)
                .pressFindButton()
                .selectResult()
                .fillPassengerForm(passenger)
                .pressPayButton()
                .getErrorDataMessage();

        Assert.assertEquals(actualError, ERROR_INPUT_DATA);
    }

    @Test
    public void registrationWithСorrectDataTest() {
        Travel travel = TravelCreator.createFormWithData();
        Passenger passenger = PassengerCreator.createPassengerWithCorrectData();
        HomePage homePage = new HomePage(driver);
        String actualMessage = homePage
                .openPage()
                .fillSearchForm(travel)
                .pressFindButton()
                .selectResult()
                .fillPassengerForm(passenger)
                .pressPayButton()
                .getMessageForPay();

        Assert.assertEquals(actualMessage, MESSAGE_FOR_PAY);
    }


}
