package tests;

import org.junit.jupiter.api.Test;

public class RegistrationTestWithFaker extends TestBase{

    @Test
    void registrationTestSuccessful() {

        registrationPagewithfaker.openPage()
                .setFirstName()
                .setLastName()
                .setEmail()
                .setGender()
                .setPhone()
                .setUserBirth()
                .setSubjects()
                .setHobbies()
                .setImage()
                .setCurrentAddressInput()
                .setState()
                .setCity()
                .clickSubmitButton();
        // проверка
        registrationPagewithfaker.RegistrationResultsModal();
        registrationPagewithfaker.verifyTableValues();


    }

}
