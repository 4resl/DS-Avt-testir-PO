package service;

import model.Travel;

public class TravelCreator {
    private static final String TEST_DATA_SEARCH_FORM_DEPARTURE = "testdata.travelForm.departure";
    private static final String TEST_DATA_SEARCH_FORM_ARRIVAL = "testdata.travelForm.arrival";
    private static final String TEST_DATA_SEARCH_FORM_DISTANT_ARRIVAL = "testdata.travelForm.distantArrival";

    public static Travel createFormWithoutData(){
        return new Travel("","");
    }

    public static Travel createFormWithSamePoints(){
        return new Travel(TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_DEPARTURE),
                TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_DEPARTURE));
    }

    public static Travel createFormWithData(){
        return new Travel(TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_DEPARTURE),
                TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_ARRIVAL));
    }

    public static Travel createFormWithDistantTown(){
        return new Travel(TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_DEPARTURE),
                TestDataReader.getTestData(TEST_DATA_SEARCH_FORM_DISTANT_ARRIVAL));
    }

}
