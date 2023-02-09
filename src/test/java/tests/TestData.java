package tests;

import com.github.javafaker.Faker;

import java.util.Date;
import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("ru"));

    public String firstname = faker.name().firstName();
    public String lastname = faker.name().firstName();
    public String email = faker.internet().emailAddress();



}
