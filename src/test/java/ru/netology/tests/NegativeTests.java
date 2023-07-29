package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.page.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataHelper.*;

public class NegativeTests {

    @BeforeAll
    static void setupAll() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true).savePageSource(true));
    }

    @AfterAll
    static void teardownAll() {
        SelenideLogger.removeListener("allure");
    }

    /*
            ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ

            ДЕБИТОВАЯ КАРТА

    №1.     Отправка формы покупки по дебитовой карте со всеми пустыми полями
        */
    @DisplayName("Форма: Дебит; Номер карты: Пусто; Дата(год):  Пусто; Дата(Месяц): Пусто; Имя: Пусто; CVC: Пусто")
    @Test
    @Feature("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Отправка формы покупки по дебитовой карте со всеми незаполненными полями")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы со всеми пустыми полями")
    void shouldPaymentCardPagedInfoWithEmptyData() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getCardInfoWithEmptyData();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.fillAllField();
    }

    /*
№2.             Отправка НЕ валидных данных (пустая форма всесто номера карты; валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код

     */
    @DisplayName("Форма: Дебит; Номер карты: Пусто; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Отправка формы покупки по дебитовой карте с пустым полем Номера карты")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем Номера карты")
    void shouldPaymentCardPageWithEmptyCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getCardInfoWithEmptyCardNumber();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.fillCardNumberRequest();
    }

    /*
№3.    Отправка НЕ валидных данных (Одобреный номер карты; Пустая форма в поле Год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
     */
    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Пусто; Дата(Месяц): Валидный; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Отправка формы покупки по дебитовой карте с пустым полем Год")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем Год")
    void shouldPaymentCardPageWithEmptyYear() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getCardInfoWithEmptyYear();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.fillRequest();
    }

    /*
№4. Отправка НЕ валидных данных (Одобренный номер карты; валидный год, Пустая форма в поле Месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
     */
    @DisplayName("Форма: Дебит; Номер карты: Одобренный; Дата(год): Валидный; Дата(Месяц): Пусто; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Отправка формы покупки по дебетовой карте с пустым полем Месяц")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем Месяц")
    void shouldPaymentCardPageWithEmptyMonth() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getCardInfoWithEmptyMonth();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.fillRequest();
    }

    /*
№5.         Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Пустая форма в поле Владелец, валидный CVC код
     */
    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Пусто; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Отправка формы покупки по дебитовой карте с пустым полем Владелец")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем Владелец")
    void shouldPaymentCardPageWithEmptyUser() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getCardInfoWithEmptyUser();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.fillRequest();
    }

    /*
№6              Отправка НЕ валидных данных (Одобренный номер карты; валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), Пустая форма в поле CVC код
     */
    @DisplayName("Форма: Дебит; Номер карты: Одобренный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница Верхний регистр; CVC: Пусто")
    @Test
    @Feature("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Отправка формы покупки по дебетовой карте с пустым полем CVC")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем CVC")
    void shouldPaymentCardPageWithEmptyCVC() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getCardInfoWithEmptyCVC();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.fillCVCRequest();
    }

    /*
            КРЕДИТНАЯ КАРТА

№7.     Отправка формы покупки в кредит со всеми  пустыми полями

     */
    @DisplayName("Форма: Кредит; Номер карты: Пусто; Дата(год): Пусто; Дата(Месяц): Пусто; Имя: Пусто; CVC: Пусто")
    @Test
    @Feature("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Отправка формы покупке в кредит со всеми незаполненными полями")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы со всеми пустыми полями")
    void shouldCreditCardPagedInfoWithEmptyData() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getCardInfoWithEmptyData();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.fillAllField();
    }


    /*
№8.             Отправка НЕ валидных данных (пустая форма всесто номера карты; валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код

     */
    @DisplayName("Форма: Кредит; Номер карты: Пусто; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Отправка формы покупке в кредит с пустым полем Номера карты")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем Номера карты")
    void shouldCreditCardPageWithEmptyCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getCardInfoWithEmptyCardNumber();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.fillCardNumberRequest();
    }

    /*
№9.    Отправка НЕ валидных данных (Одобреный номер карты; Пустая форма в поле Год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
     */
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Пусто; Дата(Месяц): Валидный; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Отправка формы покупке в кредит с пустым полем Год")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем Год")
    void shouldCreditCardPageWithEmptyYear() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getCardInfoWithEmptyYear();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.fillRequest();
    }

    /*
№10.     Отправка НЕ валидных данных (Одобреный номер карты; валидный год, Пустая форма в поле Месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
     */
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Пусто; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Отправка формы покупке в кредит с пустым полем Месяц")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем Месяц")
    void shouldCreditCardPageWithEmptyMonth() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getCardInfoWithEmptyMonth();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.fillRequest();
    }

    /*
№11.         Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Пустая форма в поле Владелец, валидный CVC код
     */
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Пусто; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Отправка формы покупке в кредит с пустым полем Владелец")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем Владелец")
    void shouldCreditCardPageWithEmptyUser() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getCardInfoWithEmptyUser();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.fillRequest();
    }

    /*
№12              Отправка НЕ валидных данных (Одобреный номер карты; валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), Пустая форма в поле CVC код
     */
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница Верхний регистр; CVC: Пусто")
    @Test
    @Feature("ТЕСТЫ НА ОТПРАВКУ ПУСТЫХ ФОРМ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Отправка формы покупке в кредит с пустым полем CVC")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.MINOR)
    @Description("Проверка отправки формы с пустым полем CVC")
    void shouldCreditCardPageWithEmptyCVC() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getCardInfoWithEmptyCVC();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.fillCVCRequest();
    }


    /*
                ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ МЕСЯЦ НЕ ВАЛИДНЫМИ ДАННЫМИ

        ЗАПОЛНЕНИЕ ПОЛЯ МЕСЯЦ ЗНАЧЕНИЯМИ ВЫХОДЯЩИМИ ЗА ГРАНИЦЫ ВАЛИДНЫХ ЗНАЧЕНИЙ (00; 13-19; одна цифра)

        ДЕБИТОВАЯ КАРТА
     */

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год):  Текущий; Дата(Месяц): 00; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ МЕСЯЦ НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ МЕСЯЦА")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы с значением поля месяц 00")
    void shouldPaymentCardPagedInvalidCardInfoDateWithInvalidMonthInfo00() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getInvalidCardInfoDateWithInvalidMonthInfo00();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.invalidDateMont();
    }

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год):  Текущий; Дата(Месяц): (13-99); Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ МЕСЯЦ НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ МЕСЯЦА")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы с значением поля месяц (13-99)")
    void shouldCreditCardPagedInvalidCardInfoDateWithInvalidMonthInfo() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getInvCardInfoDateWithInvalidMonthInfo();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.invalidDateMont();
    }

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год):  Текущий; Дата(Месяц): (0-9); Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ МЕСЯЦ НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ МЕСЯЦА")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы с значением поля месяц (0-9)")
    void shouldCreditCardPagedInvalidCardInfoDateWithInvalidMonthInfoOneNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getInvalidCardInfoDateWithInvalidMonthInfoOneNumber();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.errorFormatMessageCardPage();
    }
    /*
                        КРЕДИТНАЯ КАРТА
     */
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год):  Текущий; Дата(Месяц): 00; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ МЕСЯЦ НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ МЕСЯЦА")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы с значением поля месяц 00")
    void shouldCreditCardPagedInvalidCardInfoDateWithInvalidMonthInfo00() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getInvalidCardInfoDateWithInvalidMonthInfo00();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.invalidDateMont();
    }

    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год):  Текущий; Дата(Месяц): (13-99); Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ МЕСЯЦ НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ МЕСЯЦА")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы с значением поля месяц (13-99)")
    void shouldPaymentCardPagedInvalidCardInfoDateWithInvalidMonthInfo() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getInvCardInfoDateWithInvalidMonthInfo();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.invalidDateMont();
    }

    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год):  Текущий; Дата(Месяц): (0-9); Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ МЕСЯЦ НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ МЕСЯЦА")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы с значением поля месяц (0-9)")
    void shouldPaymentCardPagedInvalidCardInfoDateWithInvalidMonthInfoOneNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getInvalidCardInfoDateWithInvalidMonthInfoOneNumber();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.errorFormatMessageCardPage();
    }

    /*
       Заполнение поля "Месяц" меньше текущего при заполнении поля год значением текущего года.

                              ДЕБИТОВАЯ КАРТА
     */

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год):  Текущий; Дата(Месяц): прошедший ; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ МЕСЯЦ НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("НЕ ВЕРНАЯ ДАТА МЕСЯЦА")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Месяц\" меньше текущего, при заполнении поля год значением текущего года.")
    void shouldPaymentCardPagedInvCardInfoDateWithPreviousMonths() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getInvCardInfoDateWithPreviousMonths();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.invalidDateMont();
    }

    /*
                КРЕДИТНАЯ КАРТА
     */
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год):  Текущий; Дата(Месяц): прошедший ; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ МЕСЯЦ НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("НЕ ВЕРНАЯ ДАТА МЕСЯЦА")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Месяц\" меньше текущего, при заполнении поля год значением текущего года.")
    void shouldCreditCardPagedInvCardInfoDateWithPreviousMonths() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getInvCardInfoDateWithPreviousMonths();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.invalidDateMont();
    }

    /*
    Заполнение поля "Год" не валидными данными (до текущего года; болше текущего года на 6 и более лет; одна цифра)

                    ДЕБИТОВАЯ КАРТА
     */
    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): До текущего; Дата(Месяц): Текущий ; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ ГОД НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("НЕ ВЕРНАЯ ДАТА ГОДА")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Год\" меньше текущего, при заполнении поля \"Месяц\" значением текущего Месяца.")
    void shouldPaymentCardPagedInvCardInfoDateWithPreviousYears() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getInvCardInfoDateWithPreviousYears();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.invalidExpiredDateYears();
    }

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Больше текущего на 6+ лет; Дата(Месяц): Текущий ; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ ГОД НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("НЕ ВЕРНАЯ ДАТА ГОДА")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Год\" на 6+ лет, при заполнении поля \"Месяц\" значением текущего Месяца.")
    void shouldPaymentCardPagedInvalidCardInfoDateWithExpirationMoreThatFiveYears() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getInvalidCardInfoDateWithExpirationMoreThatFiveYears();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.invalidDateYears();
    }

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): (0-9); Дата(Месяц): Текущий ; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ ГОД НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ ГОДА")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Год\" (0-9), при заполнении поля \"Месяц\" значением текущего Месяца.")
    void shouldPaymentCardPagedInvalidCardInfoDateWithInvalidYearInfo() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getInvalidCardInfoDateWithInvalidYearInfo();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.errorFormatMessageCardPageYears();
    }

    /*
                           КРЕДИТНАЯ КАРТА
     */
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): До текущего; Дата(Месяц): Текущий ; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ ГОД НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("НЕ ВЕРНАЯ ДАТА ГОДА")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Год\" меньше текущего, при заполнении поля \"Месяц\" значением текущего Месяца.")
    void shouldCreditCardPagedInvCardInfoDateWithPreviousYears() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getInvCardInfoDateWithPreviousYears();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.invalidExpiredDateYears();
    }

    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Больше текущего на 6+ лет; Дата(Месяц): Текущий ; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ ГОД НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("НЕ ВЕРНАЯ ДАТА ГОДА")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Год\" на 6+ лет, при заполнении поля \"Месяц\" значением текущего Месяца.")
    void shouldCreditCardPagedInvalidCardInfoDateWithExpirationMoreThatFiveYears() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getInvalidCardInfoDateWithExpirationMoreThatFiveYears();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.invalidDateYears();
    }

    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): (0-9); Дата(Месяц): Текущий ; Имя: Латиница Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ ГОД НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ ГОДА")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Год\" (0-9), при заполнении поля \"Месяц\" значением текущего Месяца.")
    void shouldCreditCardPagedInvalidCardInfoDateWithInvalidYearInfo() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getInvalidCardInfoDateWithInvalidYearInfo();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.errorFormatMessageCardPageYears();
    }

    /*
    6. Заполнение поля "Владелец" не валидными данными (Кириллица; цифры в Имени и/или Фамилии; Спец.символы(кроме дефиса и пробела); Латиница в нижнем регистре; Дрегие языки кроме Латиницы)

                                    ДЕБИТОВАЯ КАРТА
     */
    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий ; Имя: Латиница Первая заглавная остальные строчные; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ \"ИМЯ\" НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ ИМЕНИ")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Имя\" Не валидное имя владельца(Латиница Первая заглавная остальные строчные).")
    void shouldPaymentCardPagedInvalidCardInfoNameLowercase() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getInvalidCardInfoNameLowercase();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.errorFormatMessageCardPageName();
    }

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий ; Имя: Кириллица; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ \"ИМЯ\" НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ ИМЕНИ")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Имя\" Не валидное имя владельца(Кириллица).")
    void shouldPaymentCardPagedInvalidCardInfoNameInCyrillic() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getInvalidCardInfoNameInCyrillic();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.errorFormatMessageCardPageName();
    }

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий ; Имя: Имя с цифрой; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ \"ИМЯ\" НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ ИМЕНИ")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Имя\" Не валидное имя владельца(Латиница Имя с цифрой).")
    void shouldPaymentCardPagedInvCardInfoNameWithNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getInvCardInfoNameWithNumber();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.errorFormatMessageCardPageName();
    }

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий ; Имя: Спецсимволы; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ \"ИМЯ\" НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ ИМЕНИ")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Имя\" Не валидное имя владельца(Спецсимволы).")
    void shouldPaymentCardPagedInvCardInfoNameWithSymbol() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getInvCardInfoNameWithSymbol();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.errorFormatMessageCardPageName();
    }

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий ; Имя: Иероглифы; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ \"ИМЯ\" НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ ИМЕНИ")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Имя\" Не валидное имя владельца(Иероглифы).")
    void shouldPaymentCardPagedInvCardInfoNameInCN() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getInvCardInfoNameInCN();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.errorFormatMessageCardPageName();
    }

    /*
                    КРЕДИТНАЯ КАРТА
     */
    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий ; Имя: Латиница Первая заглавная остальные строчные; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ \"ИМЯ\" НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ ИМЕНИ")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Имя\" Не валидное имя владельца(Латиница Первая заглавная остальные строчные).")
    void shouldCreditCardPagedInvalidCardInfoNameLowercase() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getInvalidCardInfoNameLowercase();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.errorFormatMessageCardPageName();
    }

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий ; Имя: Кириллица; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ \"ИМЯ\" НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ ИМЕНИ")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Имя\" Не валидное имя владельца(Кириллица).")
    void shouldCreditCardPagedInvalidCardInfoNameInCyrillic() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getInvalidCardInfoNameInCyrillic();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.errorFormatMessageCardPageName();
    }

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий ; Имя: Имя с цифрой; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ \"ИМЯ\" НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ ИМЕНИ")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Имя\" Не валидное имя владельца(Латиница Имя с цифрой).")
    void shouldCreditCardPagedInvCardInfoNameWithNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getInvCardInfoNameWithNumber();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.errorFormatMessageCardPageName();
    }

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий ; Имя: Спецсимволы; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ \"ИМЯ\" НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ ИМЕНИ")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Имя\" Не валидное имя владельца(Спецсимволы).")
    void shouldCreditCardPagedInvCardInfoNameWithSymbol() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getInvCardInfoNameWithSymbol();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.errorFormatMessageCardPageName();
    }

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий ; Имя: Иероглифы; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ \"ИМЯ\" НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ ИМЕНИ")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Имя\" Не валидное имя владельца(Иероглифы).")
    void shouldCreditCardPagedInvCardInfoNameInCN() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getInvCardInfoNameInCN();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.errorFormatMessageCardPageName();
    }

    /*
                 Заполнение поля "CVC/CVV" не валидными данными (одна цифра; две цифры)

                         ДЕБИТОВАЯ КАРТА
     */

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий ; Имя: Латиница Верхний регистр; CVC: НЕ ВАЛИДНЫЙ (две цифры)")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ \"Код CVC\" НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ CVC")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Код СМС\" Не валидными данными (две цифры).")
    void shouldPaymentCardPagedInvalidCardInfoCVCNumberWithTwoNumbers() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getInvalidCardInfoCVCNumberWithTwoNumbers();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.errorFormatMessageCardPageCVC();
    }

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий ; Имя: Латиница Верхний регистр; CVC: НЕ ВАЛИДНЫЙ (одна цифра)")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ \"Код CVC\" НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ CVC")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Код СМС\" Не валидными данными (одна цифра).")
    void shouldPaymentCardPagedInvalidCardInfoCVCNumberWithSingleNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var invalidCardInfo = getInvalidCardInfoCVCNumberWithSingleNumber();
        paymentCardPage.fillTheForm(invalidCardInfo);
        paymentCardPage.errorFormatMessageCardPageCVC();
    }

    /*
                            КРЕДИТНАЯ КАРТА
     */
    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий ; Имя: Латиница Верхний регистр; CVC: НЕ ВАЛИДНЫЙ (две цифры)")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ \"Код CVC\" НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ CVC")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Код СМС\" Не валидными данными (две цифры).")
    void shouldCreditCardPagedInvalidCardInfoCVCNumberWithTwoNumbers() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getInvalidCardInfoCVCNumberWithTwoNumbers();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.errorFormatMessageCardPageCVC();
    }

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий ; Имя: Латиница Верхний регистр; CVC: НЕ ВАЛИДНЫЙ (одна цифра)")
    @Test
    @Feature("ТЕСТЫ НА ЗАПОЛНЕНИЕ ПОЛЯ \"Код CVC\" НЕ ВАЛИДНЫМИ ДАННЫМИ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("НЕ ВЕРНЫЙ ФОРМАТ CVC")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка отправки формы при заполнение поля \"Код СМС\" Не валидными данными (одна цифра).")
    void shouldCreditCardPagedInvalidCardInfoCVCNumberWithSingleNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var invalidCardInfo = getInvalidCardInfoCVCNumberWithSingleNumber();
        creditCardPage.fillTheForm(invalidCardInfo);
        creditCardPage.errorFormatMessageCardPageCVC();
    }
}