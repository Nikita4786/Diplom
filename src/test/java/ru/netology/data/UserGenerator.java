package ru.netology.data;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.Value;

import java.util.Locale;

public class UserGenerator {
    private UserGenerator() {
    }

    @Value
    public static class User {
        private String userName;
    }

    public static Faker fakerEn = new Faker(new Locale("en"));
    public static Faker fakerRu = new Faker(new Locale("ru"));
    public static Faker fakerCN = new Faker(new Locale("zh_CN"));

    //    Имя на Латинице верхний регистр
    @Step("Ввод имени на Латинице в ВЕРХНЕМ регистре")
    public static User getValidNameInUppercase() {
        return new User(fakerEn.name().fullName().toUpperCase());
    }

    //    Имя на Латинице через пробел в верхнем регистре
    @Step("Ввод имени на Латинице в ВЕРХНЕМ регистре с двумя пробелами внутри имени")
    public static User getValidNameInUppercaseSeparatedBySpace() {
        return new User(fakerEn.name().lastName().toUpperCase() + " " + fakerEn.name().fullName().toUpperCase());
    }

    //    Имя на Латинице через дефис Верхний регистр
    @Step("Ввод имени на Латинице в ВЕРХНЕМ регистре содержащем дефис")
    public static User getValidNameInUppercaseSeparatedByHyphen() {
        return new User(fakerEn.name().lastName().toUpperCase() + "-" + fakerEn.name().fullName().toUpperCase());
    }

    //    Имя на Латинице, Первая заглавная остальные строчные
    @Step("Ввод имени на Латинице, Первая буква заглавная, остальные строчные")
    public static User getInvalidNameInLowercase() {
        return new User(fakerEn.name().fullName());
    }

    //    Имя на кирилице
    @Step("Ввод Имени на Кириллице")
    public static User getInvalidNameInCirillic() {
        return new User(fakerRu.name().fullName());
    }

    //    Имя с цифрой
    @Step("Ввод имени на Латинице. Имя содержит цифру")
    public static User getInvalidNameWithNambers() {
        return new User(fakerEn.name().fullName() + fakerEn.numerify("#"));
    }

    //    Имя из спецсимволов
    @Step("Ввод имени из спецсимволов")
    public static User getInvalidNameWithSymbol() {
        String user = "!@#$%^&*()_+=-`~\\||{}][|;:?><";
        return new User(user);
    }

    //    Имя из иероглифов
    @Step("Ввод имени написаном иероглифами")
    public static User getInvalidNameInCN() {
        return new User(fakerCN.name().fullName());
    }

    //    Пустое поля Имя
    @Step("Поле имя Оставлено пустым")
    public static User getEmptyUser() {
        String user = "";
        return new User(user);
    }
}