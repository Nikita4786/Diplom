package ru.netology.data;

import io.qameta.allure.Step;

import static ru.netology.data.DataHelper.faker;

public class CardNumberGenerator {
    private CardNumberGenerator() {}

//    номер одобренной карты
    @Step("Ввод номера одобренной карты")
    public static String ApprovedCardNumber() {
        return "4444 4444 4444 4441";
    }

//    номер заблокированной карты
    @Step("Ввод номера заблокированной карты")
    public static String DeclinedCardNumber() {
        return "4444 4444 4444 4442";
    }

//    номер случайной карты
    @Step("Ввод номера случайной карты")
    public static String RandomCardNumber() {
        return faker.numerify("#### #### #### ####");
    }

//    Номер карты с 12 цифрами
    @Step("Ввод номера карты неверного формата")
    public static String InvalidFormatCardNumber() {
        return "#### #### ####";
    }

//    Пустой номер карты
    @Step("Оставление поля для номера карты пустым")
    public static String EmptyCardNumber() {
        return "";
    }

    /*
Статус карты в базе
 */
    public static String getApprovedCardStatus() {
        return "APPROVED";
    }

    public static String getDeclinedCardStatus() {
        return "DECLINED";
    }

    public static String getRandomCardStatus() {
        return null;
    }
}