package test;

import model.Travel;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import service.TravelCreator;

public class HomePageTest extends CommonConditions{

    private static final String ERROR_FORM_WITHOUT_DATA = "Укажите город вылета";
    private static final String ERROR_TICKETS_NOT_FOUND = "Упс! А билетов и нет";

    @Test
    public void findTicketsWithoutData(){

        Travel travelForm = TravelCreator.createFormWithoutData();
        String errorMessageActual = new HomePage(driver)
                .openPage()
                .fillSearchForm(travelForm)
                .pressFindButton()
                .getHintMessageForDeparture();

        Assert.assertEquals(ERROR_FORM_WITHOUT_DATA, errorMessageActual);
    }

    @Test
    public void findTicketsWithSameDepartureAndArrivalTest() {

        Travel travelForm = TravelCreator.createFormWithSamePoints();
        String errorMessageActual = new HomePage(driver)
                .openPage()
                .fillSearchForm(travelForm)
                .pressFindButton()
                .getErrorMessage();
        Assert.assertEquals(ERROR_TICKETS_NOT_FOUND, errorMessageActual);

    }

    @Test
    public void findTicketsForSpecifiedCity() {

        Travel travelForm = TravelCreator.createFormWithData();
        boolean isContainsResults = new HomePage(driver)
                .openPage()
                .fillSearchForm(travelForm)
                .pressFindButton()
                .isPageContainsAtLeastOneFindResult();
        Assert.assertTrue(isContainsResults);
    }

    @Test
    public void findTicketsToDistantTown() {

        Travel travelForm = TravelCreator.createFormWithDistantTown();
        String errorMessageActual = new HomePage(driver)
                .openPage()
                .fillSearchForm(travelForm)
                .pressFindButton()
                .getErrorMessage();
        Assert.assertEquals(ERROR_TICKETS_NOT_FOUND, errorMessageActual);

    }



}

