package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPageWithFaker;

public class RegistrationTestWithFaker extends TestBase{

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
        registrationPage.RegistrationResultsModal();
        registrationPage
                .verifyTableValues("Student Name", "Alexandra" + " " + "Saveleva")
                .verifyTableValues("Student Email", "alex@gmail.com")
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
