package tests;

import org.junit.jupiter.api.Test;

public class RegistrationTestWithFaker extends TestBase{
    private TestData testData = new TestData();
    @Test
    void registrationTestSuccessful() {

        registrationPagewithfaker.openPage()
                .setFirstName()
                .setLastName()
                .setEmail()
                .setGender("Female")
                .setPhone("1234567890")
                .setUserBirth("5", "March", "2009")
                .setSubjects("Economics")
                .setHobbies("Sports")
                .setImage("1.png")
                .setCurrentAddressInput("Some address 1")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmitButton();
        // проверка
        registrationPagewithfaker.RegistrationResultsModal();
        registrationPagewithfaker
                .verifyTableValues("Student Name", testData.firstname + " " + testData.lastname)
                .verifyTableValues("Student Email", testData.email)
                .verifyTableValues("Gender", "Female")
                .verifyTableValues("Mobile", "1234567890")
                .verifyTableValues("Date of Birth", "05 March,2009")
                .verifyTableValues("Address", "Some address 1")
                .verifyTableValues("Subjects", "Economics")
                .verifyTableValues("Hobbies", "Sports")
                .verifyTableValues("Picture", "1.png")
                .verifyTableValues("State and City", "Delhi");

    }

}
