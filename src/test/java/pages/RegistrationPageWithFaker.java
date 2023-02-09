package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import tests.TestData;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageWithFaker {
    private final String TITLE_TEXT = "Student Registration Form";
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private TestData testData = new TestData();

    public String fname = testData.firstname;
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderSection = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            calendarSection = $("#dateOfBirthInput"),
            subjectsContainerInput = $("#subjectsContainer input"),
            subjectsContainerAutoCompleteList = $(".subjects-auto-complete__menu"),
            hobbiesSection = $("#hobbiesWrapper"),
            imageUpdateField = $("input#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateField = $(byText("Select State")),
            cityField = $("#city"),
            submitButton = $("button#submit");

    public RegistrationPageWithFaker openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPageWithFaker setFirstName() {
        firstNameInput.setValue(fname);
        return this;
    }

    public RegistrationPageWithFaker setLastName() {
        lastNameInput.setValue(testData.lastname);
        return this;
    }

    public RegistrationPageWithFaker setEmail() {
        emailInput.setValue(testData.email);
        return this;
    }

    public RegistrationPageWithFaker setGender() {
        genderSection.$(byText(testData.gender)).click();
        return this;
    }

    public RegistrationPageWithFaker setPhone() {
        phoneInput.setValue(testData.phone);
        return this;
    }

    public RegistrationPageWithFaker setCurrentAddressInput() {
        currentAddressInput.setValue(testData.adress);
        return this;
    }

    public RegistrationPageWithFaker setUserBirth() {
        calendarSection.click();
        new CalendarComponent().setBirth(testData.birthDay, testData.birthMonth, testData.birthYear);
        return this;
    }

    public RegistrationPageWithFaker setSubjects() {
        for (String subject : testData.subjects) {
            subjectsContainerInput.setValue(subject);
            subjectsContainerAutoCompleteList.$(byText(subject)).click();
        }
        return this;
    }

    public RegistrationPageWithFaker setHobbies() {
        for (String hobby : testData.hobbies) {
            hobbiesSection.$(byText(hobby)).click();
        }
        return this;
    }

    public RegistrationPageWithFaker setImage() {
        imageUpdateField.uploadFile(new File("src/test/resources/img/" + testData.img));
        return this;
    }

    public RegistrationPageWithFaker setState() {
        stateField.click();
        $(byText(testData.state)).click();
        return this;
    }

    public RegistrationPageWithFaker setCity() {
        //не помещается в экран форма - прокрутить до поля stateCity-wrapper
        $("#stateCity-wrapper").scrollIntoView(true);
        cityField.click();
        $(byText(testData.city)).click();
        return this;
    }

    public RegistrationPageWithFaker clickSubmitButton() {
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        submitButton.click();
        return this;
    }

    public RegistrationPageWithFaker verifyTableValues() {

        $(".table-responsive").$(byText("Student Name")).
        sibling(0).shouldHave(text(testData.firstname + " " + testData.lastname));

        $(".table-responsive").$(byText("Student Email")).
                sibling(0).shouldHave(text(testData.email));

        $(".table-responsive").$(byText("Gender")).
                sibling(0).shouldHave(text(testData.gender));

        $(".table-responsive").$(byText("Mobile")).
                sibling(0).shouldHave(text(testData.phone));

        $(".table-responsive").$(byText("Date of Birth")).
                sibling(0).shouldHave
                        (text(testData.birthDay+" "+testData.birthMonth+","+testData.birthYear));

        $(".table-responsive").$(byText("Address")).
                sibling(0).shouldHave(text(testData.adress));

        $(".table-responsive").$(byText("Subjects")).
                sibling(0).shouldHave(text(testData.subjects[0]));

        $(".table-responsive").$(byText("Hobbies")).
                sibling(0).shouldHave(text(testData.hobbies[0]));

        $(".table-responsive").$(byText("Picture")).
                sibling(0).shouldHave(text(testData.img));

        $(".table-responsive").$(byText("State and City")).
                sibling(0).shouldHave(text(testData.state));

        return this;
    }

    public RegistrationPageWithFaker RegistrationResultsModal() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }


}
