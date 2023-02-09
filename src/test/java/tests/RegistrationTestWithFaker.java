package tests;

import org.junit.jupiter.api.Test;

public class RegistrationTestWithFaker extends TestBase{
    private TestData testData = new TestData();
    @Test
    void registrationTestSuccessful() {

        registrationPagewithfaker.openPage()
                .setFirstName(testData.firstname)
                .setLastName(testData.lastname)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setPhone(testData.phone)
                .setUserBirth(testData.birthDay, testData.birthMonth, testData.birthYear)
                .setSubjects(testData.subjects)
                .setHobbies(testData.hobbies)
                .setImage(testData.img)
                .setCurrentAddressInput(testData.adress)
                .setState(testData.state)
                .setCity(testData.city)
                .clickSubmitButton();
        // проверка
        registrationPagewithfaker.RegistrationResultsModal();
        registrationPagewithfaker
                .verifyTableValues("Student Name", testData.firstname + " " + testData.lastname)
                .verifyTableValues("Student Email", testData.email)
                .verifyTableValues("Gender", testData.gender)
                .verifyTableValues("Mobile", testData.phone)
                .verifyTableValues("Date of Birth", testData.birthDay+" "+testData.birthMonth+","+testData.birthYear)
                .verifyTableValues("Address", testData.adress)
                .verifyTableValues("Subjects", testData.subjects[0])
                .verifyTableValues("Hobbies", testData.hobbies[0])
                .verifyTableValues("Picture", testData.img)
                .verifyTableValues("State and City", testData.state);


    }

}
