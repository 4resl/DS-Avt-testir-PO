package model;

public class Passenger {
    private String surname;
    private String name;
    private String birthDate;
    private String documentNumber;
    private String phoneNumber;
    private String mail;

    public Passenger(String surname, String name, String birthDate, String documentNumber, String phoneNumber, String mail) {
        this.surname = surname;
        this.name = name;
        this.birthDate = birthDate;
        this.documentNumber = documentNumber;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMail() {
        return mail;
    }
}
