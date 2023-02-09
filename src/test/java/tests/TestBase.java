package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPageWithFaker;

public class TestBase {
    RegistrationPageWithFaker registrationPagewithfaker = new RegistrationPageWithFaker();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
    }
}