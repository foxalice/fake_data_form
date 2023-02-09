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

    public RegistrationPageWithFaker setGender(String values) {
        genderSection.$(byText(values)).click();
        return this;
    }

    public RegistrationPageWithFaker setPhone(String values) {
        phoneInput.setValue(values);
        return this;
    }

    public RegistrationPageWithFaker setCurrentAddressInput(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPageWithFaker setUserBirth(String day, String month, String year) {
        calendarSection.click();
        new CalendarComponent().setBirth(day, month, year);
        return this;
    }

    public RegistrationPageWithFaker setSubjects(String... value) {
        for (String subject : value) {
            subjectsContainerInput.setValue(subject);
            subjectsContainerAutoCompleteList.$(byText(subject)).click();
        }
        return this;
    }

    public RegistrationPageWithFaker setHobbies(@org.jetbrains.annotations.NotNull String... value) {
        for (String hobby : value) {
            hobbiesSection.$(byText(hobby)).click();
        }
        return this;
    }

    public RegistrationPageWithFaker setImage(String fileName) {
        imageUpdateField.uploadFile(new File("src/test/resources/img/" + fileName));
        return this;
    }

    public RegistrationPageWithFaker setState(String state) {
        stateField.click();
        $(byText(state)).click();
        return this;
    }

    public RegistrationPageWithFaker setCity(String city) {
        //не помещается в экран форма - прокрутить до поля stateCity-wrapper
        $("#stateCity-wrapper").scrollIntoView(true);
        cityField.click();
        $(byText(city)).click();
        return this;
    }

    public RegistrationPageWithFaker clickSubmitButton() {
        executeJavaScript("window.scrollTo(0, document.body.scrollHeight)");
        submitButton.click();
        return this;
    }

    public RegistrationPageWithFaker verifyTableValues(String key, String value) {
        $(".table-responsive").$(byText(key)).
                sibling(0).shouldHave(text(value));


        return this;
    }

    public RegistrationPageWithFaker RegistrationResultsModal() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }


}
