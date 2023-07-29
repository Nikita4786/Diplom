package ru.netology.data;

import io.qameta.allure.Step;
import lombok.Value;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static ru.netology.data.DataHelper.faker;

public class DateGenerator {
    private DateGenerator() {}

    @Value
    public static class Date{
        private String year;
        private String month;

    }

    private static final LocalDate actualDate = LocalDate.now();
    static DateTimeFormatter monthTimeFormatter = DateTimeFormatter.ofPattern("MM");
    static DateTimeFormatter yearTimeFormatter = DateTimeFormatter.ofPattern("yy");

    // Получение текущей даты (год и месяц)
    @Step("Ввод текущего года")
    public static Date getCurrentDateYear() {
        return new Date(actualDate.format(yearTimeFormatter), actualDate.format(monthTimeFormatter));
    }

    @Step("Ввод текущего месяца")
    public static Date getCurrentDateMonth() {
        return new Date(actualDate.format(yearTimeFormatter), actualDate.format(monthTimeFormatter));
    }


    /*
    Получение валидной даты (с текущей даты до +5 лет с текущей даты.
    Если год будет увеличен на 5 лет, то значение месяца не будет превышать текущее значение
    Если год останется прежним, то значение месяца будет не меньше текущего
    */
    @Step("Ввод валидного года")
    public static Date getValidDateYear() {
        int numberOfYeatsAdded = faker.number().numberBetween(0, 5);
        Month month = Month.of(faker.number().numberBetween(1, 12));
        if (numberOfYeatsAdded == 5) {
            month = actualDate.minusMonths(faker.number()
                    .numberBetween(0, actualDate.getMonth().getValue() - 1)).getMonth();
        } else {
            if (numberOfYeatsAdded == 0) {
                month = actualDate.plusMonths(faker.number()
                        .numberBetween(1, 12 - actualDate.getMonth().getValue())).getMonth();
            }
        }
        LocalDate newDate = LocalDate.of(actualDate.plusYears(numberOfYeatsAdded).getYear(),
                    month, actualDate.getDayOfMonth());
        return new Date(newDate.format(yearTimeFormatter), newDate.format(monthTimeFormatter));
    }

    @Step("Ввод валидного месяца")
    public static Date getValidDateMonth() {
        int numberOfYeatsAdded = faker.number().numberBetween(0, 5);
        Month month = Month.of(faker.number().numberBetween(1, 12));
        if (numberOfYeatsAdded == 5) {
            month = actualDate.minusMonths(faker.number()
                    .numberBetween(0, actualDate.getMonth().getValue() - 1)).getMonth();
        } else {
            if (numberOfYeatsAdded == 0) {
                month = actualDate.plusMonths(faker.number()
                        .numberBetween(1, 12 - actualDate.getMonth().getValue())).getMonth();
            }
        }
        LocalDate newDate = LocalDate.of(actualDate.plusYears(numberOfYeatsAdded).getYear(),
                month, actualDate.getDayOfMonth());
        return new Date(newDate.format(yearTimeFormatter), newDate.format(monthTimeFormatter));
    }

    //Получение значение года на +5 лет
    @Step("Ввод значения года +5 лет от текущего")
    public static Date getDateWithExpirationMoreThatFiveYears() {
        int numberOfYearsAdded = faker.number().numberBetween(6, 99 - Integer.valueOf(actualDate.format(yearTimeFormatter)));
        return new Date(actualDate.plusYears(numberOfYearsAdded).format(yearTimeFormatter), actualDate.format(monthTimeFormatter));
    }

    @Step("Ввод текущего месяца")
    public static Date getDateWithExpirationMoreThatFiveYearsMonth() {
        int numberOfYearsAdded = faker.number().numberBetween(6, 99 - Integer.valueOf(actualDate.format(yearTimeFormatter)));
        return new Date(actualDate.plusYears(numberOfYearsAdded).format(yearTimeFormatter), actualDate.format(monthTimeFormatter));
    }

    //Получение прошлых лет
    @Step("Ввод прошедшего года")
    public static Date getDateWithPreviousYears() {
        int numberYearsDeducted = faker.number().numberBetween(1, Integer.valueOf(actualDate.format(yearTimeFormatter)));
        return new Date(actualDate.minusYears(numberYearsDeducted).format(yearTimeFormatter), actualDate.format(monthTimeFormatter));
    }

    @Step("Ввод текущего месяца")
    public static Date getDateWithPreviousYearsMonth() {
        int numberYearsDeducted = faker.number().numberBetween(1, Integer.valueOf(actualDate.format(yearTimeFormatter)));
        return new Date(actualDate.minusYears(numberYearsDeducted).format(yearTimeFormatter), actualDate.format(monthTimeFormatter));
    }

    // получение прошлых месяцев
    @Step("Ввод прошедших месяцев")
    public static Date getDateWithPreviousMonths() {
        String month = actualDate.format(monthTimeFormatter);
        String year;
        if (month.equals("01")) {
            month = "12";
            year = actualDate.minusYears(1).format(yearTimeFormatter);
        }else {
            int numberMonthDeducted = faker.number().numberBetween(1, actualDate.getMonth().getValue() - 1);
            month = actualDate.withMonth(numberMonthDeducted).format(monthTimeFormatter);
            year = actualDate.format(yearTimeFormatter);
        }
        return new Date(year, month);
    }

    @Step("Ввод текущего года")
    public static Date getDateWithPreviousMonthsYear() {
        String month = actualDate.format(monthTimeFormatter);
        String year;
        if (month.equals("01")) {
            month = "12";
            year = actualDate.minusYears(1).format(yearTimeFormatter);
        }else {
            int numberMonthDeducted = faker.number().numberBetween(1, actualDate.getMonth().getValue() - 1);
            month = actualDate.withMonth(numberMonthDeducted).format(monthTimeFormatter);
            year = actualDate.format(yearTimeFormatter);
        }
        return new Date(year, month);
    }

    //Получение не валидных заначений для месяца (13-99)
    @Step("Ввод не валидных значений месяца (13-19)")
    public static Date getDateWithInvalidMonthInfo() {
        int number = faker.number().numberBetween(13, 99);
        String month = String.valueOf(number);
        return new Date(actualDate.format(yearTimeFormatter), month);
    }

    @Step("Ввод текущего года")
    public static Date getDateWithInvalidMonthInfoYear() {
        int number = faker.number().numberBetween(13, 99);
        String month = String.valueOf(number);
        return new Date(actualDate.format(yearTimeFormatter), month);
    }

//    Получение не валидных значений для месяца (00)
    @Step("Ввод не валидных значений месяца (00)")
    public static Date getDateWithInvalidMonthInfo00() {
        String month = "00";
        return new Date(actualDate.format(yearTimeFormatter), month);
    }

    @Step("Ввод текущего года")
    public static Date getDateWithInvalidMonthInfo00Year() {
        String month = "00";
        return new Date(actualDate.format(yearTimeFormatter), month);
    }

//    получение не валидных значений для месяца(одна цифра)
    @Step("Ввод не валидных значений для месяца (0-9)")
    public static Date getDateWithInvalidMonthInfoOneNumber() {
        int number = faker.number().numberBetween(0, 9);
        String month = String.valueOf(number);
        return new Date(actualDate.format(yearTimeFormatter), month);
    }

    @Step("Ввод текущего года")
    public static Date getDateWithInvalidMonthInfoOneNumberYear() {
        int number = faker.number().numberBetween(0, 9);
        String month = String.valueOf(number);
        return new Date(actualDate.format(yearTimeFormatter), month);
    }

    //Получение не валидных значений для года (0-9 (одна цифра))
    @Step("Ввод не валидных значений для года (0-9)")
    public static Date getDateWithInvalidYearInfo() {
        int number = faker.number().numberBetween(0, 9);
        String year = String.valueOf(number);
        return new Date(year, actualDate.format(monthTimeFormatter));
    }

    @Step("Ввод текущего месяца")
    public static Date getDateWithInvalidYearInfoMonth() {
        int number = faker.number().numberBetween(0, 9);
        String year = String.valueOf(number);
        return new Date(year, actualDate.format(monthTimeFormatter));
    }

//    Получение поляя год пустым
    @Step("Оставление поля год пустым")
    public static Date getEmptyDateYear() {
        String year = "";
        return new Date(year, actualDate.format(monthTimeFormatter));
    }

    @Step("Ввод текущего месяца")
    public static Date getEmptyDateYearMonth() {
        String year = "";
        return new Date(year, actualDate.format(monthTimeFormatter));
    }

    //    Получение поляя месяц пустым
    @Step("Оставление поля месяц пустым")
    public static Date getEmptyDateMonth() {
        String month = "";
        return new Date(actualDate.format(monthTimeFormatter), month);
    }

    @Step("Ввод текущего года")
    public static Date getEmptyDateYearMonthYear() {
        String month = "";
        return new Date(actualDate.format(monthTimeFormatter), month);
    }
}