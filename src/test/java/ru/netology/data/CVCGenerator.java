package ru.netology.data;

import io.qameta.allure.Step;
import lombok.Value;

import static ru.netology.data.DataHelper.faker;

public class CVCGenerator {

    private CVCGenerator(){}

    @Value
    public static class CVCNumber {
        private String CVCNumber;
    }

    // получение кода из 3х цифр
    @Step("Ввод валидного кода CVC из трех цифр")
    public static CVCNumber getValidCVCNumber() {
        return new CVCNumber(faker.numerify("###"));
    }

//  Получение кода из 2х цифр
    @Step("Ввод невалидного кода CVC из двух цифр")
    public static CVCNumber getInvalidCVCNumberWithTwoNumbers() {
        return new CVCNumber(faker.numerify("##"));
    }

//  Получение кода из 1 цифры
    @Step("Ввод невалидного кода CVC из одной цифры")
    public static CVCNumber  getInvalidCVVNumberWithSingleNumber() {
        return new CVCNumber(faker.numerify("#"));
    }

//    Получение пустой формы
    @Step("Оставление поля Код CVC пустым")
    public static CVCNumber getEmptyCVCNumber() {
        String cvcNumber = "";
        return new CVCNumber(cvcNumber);
    }
}