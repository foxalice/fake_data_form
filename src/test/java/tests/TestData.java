package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    static Faker faker = new Faker(new Locale("ru"));

    public static String firstname = faker.name().firstName();
    public static String lastname = faker.name().firstName();
    public static String email = faker.internet().emailAddress();



}
