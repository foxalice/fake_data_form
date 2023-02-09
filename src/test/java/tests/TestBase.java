package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import pages.RegistrationPageWithFaker;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationPageWithFaker registrationPagewithfaker = new RegistrationPageWithFaker();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
    }
}