package tests;

import org.junit.jupiter.api.Test;

public class RegistrationTestWithFaker extends TestBase{
    private TestData testData = new TestData();

    private String gender = "Female";
    private String phone = "1234567890";
    private String birthDay = "5";
    private String birthMonth = "March";
    private String birthYear = "2009";
    private String subjects = "Economics";
    private String hobbies = "Sports";
    private String adress = "Some address 1";
    private String state = "NCR";
    private String city = "Delhi";
    private String img = "1.png";

    @Test
    void registrationTestSuccessful() {

        registrationPagewithfaker.openPage()
                .setFirstName()
                .setLastName()
                .setEmail()
                .setGender(gender)
                .setPhone(phone)
                .setUserBirth(birthDay, birthMonth, birthYear)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setImage(img)
                .setCurrentAddressInput(adress)
                .setState(state)
                .setCity(city)
                .clickSubmitButton();
        // проверка
        registrationPagewithfaker.RegistrationResultsModal();
        registrationPagewithfaker
                .verifyTableValues("Student Name", testData.firstname + " " + testData.lastname)
                .verifyTableValues("Student Email", testData.email)
                .verifyTableValues("Gender", gender)
                .verifyTableValues("Mobile", phone)
                .verifyTableValues("Date of Birth", birthDay+" "+birthMonth+","+birthYear)
                .verifyTableValues("Address", adress)
                .verifyTableValues("Subjects", subjects)
                .verifyTableValues("Hobbies", hobbies)
                .verifyTableValues("Picture", img)
                .verifyTableValues("State and City", state);

    }

}
