package service;

import model.Passenger;

public class PassengerCreator {
    private static final String TEST_DATA_SURNAME = "testdata.passenger.surname";
    private static final String TEST_DATA_NAME_INCORRECT = "testdata.passenger.nameIncorrect";
    private static final String TEST_DATA_NAME_CORRECT = "testdata.passenger.nameCorrect";
    private static final String TEST_DATA_BIRTH = "testdata.passenger.dateBirth";
    private static final String TEST_DATA_DOCUMENT_NUMBER = "testdata.passenger.documnentNumber";
    private static final String TEST_DATA_PHONE = "testdata.passenger.phoneNumber";
    private static final String TEST_DATA_MAIL = "testdata.passenger.mail";

    public static Passenger createPassengerWithIncorrectData(){
        return new Passenger(
                TestDataReader.getTestData(TEST_DATA_SURNAME),
                TestDataReader.getTestData(TEST_DATA_NAME_INCORRECT),
                TestDataReader.getTestData(TEST_DATA_BIRTH),
                TestDataReader.getTestData(TEST_DATA_DOCUMENT_NUMBER),
                TestDataReader.getTestData(TEST_DATA_PHONE),
                TestDataReader.getTestData(TEST_DATA_MAIL)
        );
    }

    public static Passenger createPassengerWithCorrectData(){
        return new Passenger(
                TestDataReader.getTestData(TEST_DATA_SURNAME),
                TestDataReader.getTestData(TEST_DATA_NAME_CORRECT),
                TestDataReader.getTestData(TEST_DATA_BIRTH),
                TestDataReader.getTestData(TEST_DATA_DOCUMENT_NUMBER),
                TestDataReader.getTestData(TEST_DATA_PHONE),
                TestDataReader.getTestData(TEST_DATA_MAIL)
        );
    }
}
