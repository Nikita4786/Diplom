package ru.netology.data;

import lombok.Value;
import com.github.javafaker.Faker;

import java.util.Locale;

import static ru.netology.data.CardNumberGenerator.*;
import static ru.netology.data.DateGenerator.*;
import static ru.netology.data.UserGenerator.*;
import static ru.netology.data.CVCGenerator.*;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class CardInfo {
        private String number;
        private String year;
        private String month;
        private String user;
        private String cvc;
    }

    public static Faker faker = new Faker(new Locale("en"));

    /*
                        ВАЛИДНЫЕ ДАННЫЕ

                     ОДОБРЕННЫЙ НОМЕР КАРТЫ

    Отправка валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
     */
    public static CardInfo getValidCardInfoApprovedCardNumber() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код
     */
    public static CardInfo getValidCardInfoWithTwoWordsNameThroughSpaceApprovedCardNumber() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getValidNameInUppercaseSeparatedBySpace().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getValidCardInfoWithTwoWordsNameThroughHyphenApprovedCardNumber() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getValidNameInUppercaseSeparatedByHyphen().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка Валидных данных (Одобренный номер карты; текущий год, текущий месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getValidCardInfoCurrentDateApprovedCardNumber() {
        return new CardInfo(ApprovedCardNumber(),
                getCurrentDateYear().getYear(),
                getCurrentDateMonth().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
                    ЗАБЛОКИРОВАННЫЙ НОМЕР КАРТЫ

    Отправка валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getValidCardInfoDeclinedCardNumber() {
        return new CardInfo(DeclinedCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }
    /*
    Отправка валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getValidCardInfoWithTwoWordsNameThroughSpaceDeclinedCardNumber() {
        return new CardInfo(DeclinedCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getValidNameInUppercaseSeparatedBySpace().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getValidCardInfoWithTwoWordsNameThroughHyphenDeclinedCardNumber() {
        return new CardInfo(DeclinedCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getValidNameInUppercaseSeparatedByHyphen().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка Валидных данных (Одобренный номер карты; текущий год, текущий месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getValidCardInfoCurrentDateDeclinedCardNumber() {
        return new CardInfo(DeclinedCardNumber(),
                getCurrentDateYear().getYear(),
                getCurrentDateMonth().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }
    /*
            СЛУЧАЙНЫЙ НОМЕР КАРТЫ

    Отправка Валидных данных (Случайный номер карты; валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getValidCardInfoRandomCardNumber() {
        return new CardInfo(RandomCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getValidCardInfoWithTwoWordsNameThroughSpaceRandomCardNumber() {
        return new CardInfo(RandomCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getValidNameInUppercaseSeparatedBySpace().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getValidCardInfoWithTwoWordsNameThroughHyphenRandomCardNumber() {
        return new CardInfo(RandomCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getValidNameInUppercaseSeparatedByHyphen().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка Валидных данных (Одобренный номер карты; текущий год, текущий месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getValidCardInfoCurrentDateRandomCardNumber() {
        return new CardInfo(RandomCardNumber(),
                getCurrentDateYear().getYear(),
                getCurrentDateMonth().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
                    НЕ ВАЛИДНЫЕ ДАННЫЕ

                    ИМЯ ВЛАДЕЛЬЦА КАРТЫ

    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Не валидное имя владельца(Латиница Первая заглавная остальные строчные),
    валидный CVC код
    */
    public static CardInfo getInvalidCardInfoNameLowercase() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getInvalidNameInLowercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Не валидное имя владельца(Кириллица), валидный CVC код
    */
    public static CardInfo getInvalidCardInfoNameInCyrillic() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getInvalidNameInCirillic().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Не валидное имя владельца(Имя с цифрой), валидный CVC код
    */
    public static CardInfo getInvCardInfoNameWithNumber() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getInvalidNameWithNambers().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Не валидное имя владельца(Имя из спецсимволов), валидный CVC код
    */
    public static CardInfo getInvCardInfoNameWithSymbol() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getInvalidNameWithSymbol().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Не валидное имя владельца(Имя из иероглифов), валидный CVC код
    */
    public static CardInfo getInvCardInfoNameInCN() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getInvalidNameInCN().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
                            ДАТА (ГОД)

    Отправка НЕ валидных данных (Одобреный номер карты; год оканчания действия больше чем через 5 лет,
    валидный месяц, Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getInvalidCardInfoDateWithExpirationMoreThatFiveYears() {
        return new CardInfo(ApprovedCardNumber(),
                getDateWithExpirationMoreThatFiveYears().getYear(),
                getDateWithExpirationMoreThatFiveYearsMonth().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка НЕ валидных данных (Одобреный номер карты; год действия карты истек,
    валидный месяц, Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getInvCardInfoDateWithPreviousYears() {
        return new CardInfo(ApprovedCardNumber(),
                getDateWithPreviousYears().getYear(),
                getDateWithPreviousYearsMonth().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка НЕ валидных данных (Одобреный номер карты; Не валидное значение года (одна цифра),
    текущий месяц, Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getInvalidCardInfoDateWithInvalidYearInfo() {
        return new CardInfo(ApprovedCardNumber(),
                getDateWithInvalidYearInfo().getYear(),
                getDateWithInvalidYearInfoMonth().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
                            ДАТА (МЕСЯЦ)

    Отправка НЕ валидных данных (Одобреный номер карты; текущий год,
    месяц действия карты истек , Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getInvCardInfoDateWithPreviousMonths() {
        return new CardInfo(ApprovedCardNumber(),
                getDateWithPreviousMonthsYear().getYear(),
                getDateWithPreviousMonths().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка НЕ валидных данных (Одобреный номер карты; текущий год, Не валидное значение месяца(13-99)
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getInvCardInfoDateWithInvalidMonthInfo() {
        return new CardInfo(ApprovedCardNumber(),
                getDateWithInvalidMonthInfoYear().getYear(),
                getDateWithInvalidMonthInfo().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка НЕ валидных данных (Одобреный номер карты; текущий год, Не валидное значение месяца(00)
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getInvalidCardInfoDateWithInvalidMonthInfo00() {
        return new CardInfo(ApprovedCardNumber(),
                getDateWithInvalidMonthInfo00Year().getYear(),
                getDateWithInvalidMonthInfo00().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка НЕ валидных данных (Одобреный номер карты; текущий год, Не валидное значение месяца(одна цифра),
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getInvalidCardInfoDateWithInvalidMonthInfoOneNumber() {
        return new CardInfo(ApprovedCardNumber(),
                getDateWithInvalidMonthInfoOneNumberYear().getYear(),
                getDateWithInvalidMonthInfoOneNumber().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
                        CVC КОД

    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), НЕ валидный CVC код(две цифры)
    */
    public static CardInfo getInvalidCardInfoCVCNumberWithTwoNumbers() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getValidNameInUppercase().getUserName(),
                getInvalidCVCNumberWithTwoNumbers().getCVCNumber());
    }

    /*
    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), НЕ валидный CVC код(одна цифра)
    */
    public static CardInfo getInvalidCardInfoCVCNumberWithSingleNumber() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getValidNameInUppercase().getUserName(),
                getInvalidCVVNumberWithSingleNumber().getCVCNumber());
    }

    /*
                        КАРТЫ

    Отправка НЕ валидных данных (Не верный формат номера карты(12 цифр вместо 16); валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getInvalidFormatCardInfoInvalidCardNumber() {
        return new CardInfo(InvalidFormatCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
                      ПУСТЫЕ ПОЛЯ

    Отправка формы с пустыми полями
    */
    public static CardInfo getCardInfoWithEmptyData() {
        return new CardInfo(EmptyCardNumber(),
                getEmptyDateYear().getYear(),
                getEmptyDateMonth().getMonth(),
                "",
                getEmptyCVCNumber().getCVCNumber());
    }

    /*
    Отправка НЕ валидных данных (пустая форма всесто номера карты; валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getCardInfoWithEmptyCardNumber() {
        return new CardInfo(EmptyCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка НЕ валидных данных (Одобреный номер карты; Пустая форма в поле Год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getCardInfoWithEmptyYear() {
        return new CardInfo(ApprovedCardNumber(),
                getEmptyDateYear().getYear(),
                getEmptyDateYearMonth().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, Пустая форма в поле Месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    public static CardInfo getCardInfoWithEmptyMonth() {
        return new CardInfo(ApprovedCardNumber(),
                getEmptyDateYearMonthYear().getYear(),
                getEmptyDateMonth().getMonth(),
                getValidNameInUppercase().getUserName(),
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Пустая форма в поле Владелец, валидный CVC код
    */
    public static CardInfo getCardInfoWithEmptyUser() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                "",
                getValidCVCNumber().getCVCNumber());
    }

    /*
    Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), Пустая форма в поле CVC код
    */
    public static CardInfo getCardInfoWithEmptyCVC() {
        return new CardInfo(ApprovedCardNumber(),
                getValidDateYear().getYear(),
                getValidDateMonth().getMonth(),
                getValidNameInUppercase().getUserName(),
                getEmptyCVCNumber().getCVCNumber());
    }
}                                