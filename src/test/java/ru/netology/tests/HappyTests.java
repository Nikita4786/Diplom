package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.page.StartPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.CardNumberGenerator.*;
import static ru.netology.data.DataBaseHelper.getCreditStatus;
import static ru.netology.data.DataBaseHelper.getStatusPaymentStatus;
import static ru.netology.data.DataHelper.*;

public class HappyTests {

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
          ОТКРЫТИЕ СРАНИЦЫ; ПЕРЕХОД НА ФОРМЫ ДЛЯ ЗАПАЛНЕНИЯ ДАННЫХ; ПЕРЕХОД С ФОРМЫ НА ФОРМУ

    №1. Открытие страницы "Путешествие Дня"
         */
    @DisplayName("Открытие Начальной страницы")
    @Test
    @Feature("ОТКРЫТИЕ СТРАНИЦЫ; ПЕРЕХОД НА ФОРМЫ ДЛЯ ЗАПОЛНЕНИЯ ДАННЫХ; ПЕРЕХОД С ФОРМЫ НА ФОРМУ")
    @Epic("ОТКРЫТИЕ СТРАНИЦЫ")
    @Story("Открытие страницы \"Путешествие Дня\"")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проходит проверка открытия стартовой страницы")
    void shouldVoidStartPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        startPage.startPageHedar();
    }

    /*
№2. Переход на форму оплаты по дебетовой карте
    */
    @DisplayName("Переход на форму оплаты по дебетовой карте")
    @Test
    @Feature("ОТКРЫТИЕ СТРАНИЦЫ; ПЕРЕХОД НА ФОРМЫ ДЛЯ ЗАПОЛНЕНИЯ ДАННЫХ; ПЕРЕХОД С ФОРМЫ НА ФОРМУ")
    @Epic("ПЕРЕХОД НА ФОРМЫ ДЛЯ ЗАПОЛНЕНИЯ ДАННЫХ")
    @Story("Переход на форму оплаты по дебетовой карте")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка на открытие формы для оплаты тура по дебетовой карте")
    void shouldVoidPaymentCardPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        paymentCardPage.paymentCardPageHeader();
    }

    /*
№3.     Переход на форму оплаты Тура в кредит
    */
    @DisplayName("Переход на форму оплаты Тура в кредит")
    @Test
    @Feature("ОТКРЫТИЕ СТРАНИЦЫ; ПЕРЕХОД НА ФОРМЫ ДЛЯ ЗАПОЛНЕНИЯ ДАННЫХ; ПЕРЕХОД С ФОРМЫ НА ФОРМУ")
    @Epic("ПЕРЕХОД НА ФОРМЫ ДЛЯ ЗАПОЛНЕНИЯ ДАННЫХ")
    @Story("Переход на форму оплаты Тура в кредит")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Проверка на открытие формы для покупки тура в кредит по данным карты")
    void shouldVoidCreditCardPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        creditCardPage.creditCardPageHeader();

    }

    /*
№4.     Переход с формы оплаты по дебитовой карте на форму оплаты тура в кредит при нажатии кнопки "Купить в кредит"
    */
    @DisplayName("Переход с формы оплаты по дебитовой карте на форму оплаты тура в кредит при нажатии кнопки \"Купить в кредит\"")
    @Test
    @Feature("ОТКРЫТИЕ СТРАНИЦЫ; ПЕРЕХОД НА ФОРМЫ ДЛЯ ЗАПОЛНЕНИЯ ДАННЫХ; ПЕРЕХОД С ФОРМЫ НА ФОРМУ")
    @Epic("ПЕРЕХОД С ФОРМЫ НА ФОРМУ")
    @Story("Переход с формы оплаты по дебитовой карте на форму оплаты тура в кредит при нажатии кнопки \"Купить в кредит\"\n")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Провека переключения с формы оплаты по дебитовой карте на форму оплаты тура в кредит при нажатии кнопки \"Купить в кредит\"n")
    void shouldVoidCreditCardPageAfterPaymentCardPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var creditCardPage = paymentCardPage.playWithCreditCardButton();
        creditCardPage.creditCardPageHeader();

    }

    /*
№5.     Переход с формы покупки тура в кредит на форму оплаты по дебитовой карте при нажатии кнопки "Купить"
    */
    @DisplayName("Переход с формы покупки тура в кредит на форму оплаты по дебитовой карте при нажатии кнопки \"Купить\"")
    @Test
    @Feature("ОТКРЫТИЕ СТРАНИЦЫ; ПЕРЕХОД НА ФОРМЫ ДЛЯ ЗАПОЛНЕНИЯ ДАННЫХ; ПЕРЕХОД С ФОРМЫ НА ФОРМУ")
    @Epic("ПЕРЕХОД С ФОРМЫ НА ФОРМУ")
    @Story("Переход с формы покупки тура в кредит на форму оплаты по дебитовой карте при нажатии кнопки \"Купить\"")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверка переключения с формы покупки тура в кредит на форму оплаты по дебитовой карте при нажатии кнопки \"Купить\"")
    void shouldVoidPaymentCardPageAfterCreditCardPage() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var paymentCardPage = creditCardPage.playWithDebitCardButton();
        paymentCardPage.paymentCardPageHeader();
    }

    /*
                  ТЕСТЫ ДЛЯ ОДОБРЕННОЙ КАРТЫ

               ФОРМА ДЛЯ ПОКУПКИПО ДЕБИТОВОЙ КАРТЕ

№6.    Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
     Одобреный номер карты; валидный год, валидный месяц,
     Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
     */
    @DisplayName("Форма: Дебит; Номер карты: Одобренный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Одобреный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
    void shouldValidDebitCardApprovedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoApprovedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.successNotificationPaymentCardPage();
    }
    /*
№7.     Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
    Одобреный номер карты; Текущий год, Текущий  месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
     */
    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Одобреный номер карты; Текущий год, Текущий  месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
    void shouldCurrentDateDebitCardApprovedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoCurrentDateApprovedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.successNotificationPaymentCardPage();
    }

    /*
№8.    Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
    Одобреный номер карты; валидный год, валидный месяц,
    Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код
    */
    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через пробел, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Одобреный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
    void shouldValidDebitCardInfoWithTwoWordsNameThroughSpaceApprovedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughSpaceApprovedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.successNotificationPaymentCardPage();
    }

       /*
№9.    Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
       Одобреный номер карты; валидный год, валидный месяц,
       Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
       */

    @DisplayName("Форма: Дебит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через дефис, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Одобреный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
    void shouldValidDebitCardInfoWithTwoWordsNameThroughHyphenApprovedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughHyphenApprovedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
    }

    /*
                ФОРМА ДЛЯ ПОКУПКИ В КРЕДИТ

№10.   Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
   Одобреный номер карты; валидный год, валидный месяц,
   Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
   */
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Одобреный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ данными")
    void shouldValidCreditCardApprovedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoApprovedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.successNotificationCreditCardPage();
    }

    /*
№11.   Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
    Одобреный номер карты; Текущий год, Текущий  месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Текущий; Дата(Месяц): Текущий; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Одобреный номер карты; Текущий год, Текущий  месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ данными")
    void shouldCurrentDateCreditCardApprovedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoCurrentDateApprovedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.successNotificationCreditCardPage();
    }

    /*
№12.   Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
    Одобреный номер карты; валидный год, валидный месяц,
    Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код
    */
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через пробел, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Одобреный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ данными")
    void shouldValidCreditCardInfoWithTwoWordsNameThroughSpaceApprovedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughSpaceApprovedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.successNotificationCreditCardPage();
    }

    /*
№13.   Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
   Одобреный номер карты; валидный год, валидный месяц,
   Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
    */
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через дефис, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Одобренный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ данными")
    void shouldValidCreditCardInfoWithTwoWordsNameThroughHyphenApprovedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughHyphenApprovedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.successNotificationCreditCardPage();
    }

    /*
                  ТЕСТЫ ДЛЯ ЗАБЛОКИРОВАННОЙ КАРТЫ

                ФОРМА ДЛЯ ОПЛАТЫ ПО ДЕБИТОВОЙ КАРТЕ

    №14. Заполнение формы покупки по дебетовой карте ВАЛИДНЫМИ данными:
   Заблокированный номер карты; валидный год, валидный месяц,
   Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
   */
    @DisplayName("Форма: Дебит; Номер карты: Заблокированный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Заполнение формы покупки по дебетовой карте ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебетовой карте ВАЛИДНЫМИ данными")
    void shouldValidDebitCardDeclinedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoDeclinedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.failNotificationPaymentCardPage();
   }


    /*
№15.    Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
    Заблокированный номер карты; Текущий год, Текущий  месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код

    */
    @DisplayName("Форма: Дебит; Номер карты: Заблокированный; Дата(год): Текущий; Дата(Месяц): Текущий; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; Текущий год, Текущий  месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
    void shouldCurrentDateDebitCardDeclinedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoCurrentDateDeclinedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.failNotificationPaymentCardPage();
    }

    /*
№16.    Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
    Заблокированный номер карты; валидный год, валидный месяц,
    Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код
    */
    @DisplayName("Форма: Дебит; Номер карты: Заблокированный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через пробел, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
    void shouldValidDebitCardInfoWithTwoWordsNameThroughSpaceDeclinedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughSpaceDeclinedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.failNotificationPaymentCardPage();
    }

    /*
    №17. Заполнение формы покупки по дебетовой карте ВАЛИДНЫМИ данными:
    Заблокированный номер карты; валидный год, валидный месяц,
    Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
     */
    @DisplayName("Форма: Дебит; Номер карты: Заблокированный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через дефис, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Заполнение формы покупки по дебетовой карте ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебетовой карте ВАЛИДНЫМИ данными")
    void shouldValidDebitCardInfoWithTwoWordsNameThroughHyphenDeclinedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughHyphenDeclinedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.failNotificationPaymentCardPage();
    }

    /*

                 ФОРМА ДЛЯ ПОКУПКИ В КРЕДИТ

№18.       Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
    Заблокированный номер карты; валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    @DisplayName("Форма: Кредит; Номер карты: Заблокированный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ данными")
    void shouldValidCreditCardDeclinedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoDeclinedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.failNotificationCreditCardPage();
    }

    /*
№19.       Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
    Заблокированный номер карты; Текущий год, Текущий  месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    @DisplayName("Форма: Кредит; Номер карты: Заблокированный; Дата(год): Текущий; Дата(Месяц): Текущий; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; Текущий год, Текущий  месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ данными")
    void shouldCurrentDateCreditCardDeclinedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoCurrentDateDeclinedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.failNotificationCreditCardPage();
    }

    /*
№20.       Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
    Заблокированный номер карты; валидный год, валидный месяц,
    Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код
    */
    @DisplayName("Форма: Кредит; Номер карты:  Заблокированный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через пробел, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ данными")
    void shouldValidCreditCardInfoWithTwoWordsNameThroughSpaceDeclinedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughSpaceDeclinedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.failNotificationCreditCardPage();
    }

    /*
№21.      Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
    Заблокированный номер карты; валидный год, валидный месяц,
    Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
    */
    @DisplayName("Форма: Кредит; Номер карты:  Заблокированный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через дефис, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ данными")
    void shouldValidCreditCardInfoWithTwoWordsNameThroughHyphenDeclinedCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughHyphenDeclinedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.failNotificationCreditCardPage();
    }

        /*
                      ТЕСТЫ ДЛЯ СЛУЧАЙНОЙ КАРТЫ

                    ФОРМА ДЛЯ ОПЛАТЫ ПО ДЕБИТОВОЙ КАРТЕ

№22.   Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
       Случайный номер карты; валидный год, валидный месяц,
       Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
       */

    @DisplayName("Форма: Дебит; Номер карты: Случайный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("СЛУЧАЙНАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Случайный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
    void shouldValidDebitCardRandomCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoRandomCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.failNotificationPaymentCardPage();
    }


    /*
№23.    Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
        Случайный номер карты; Текущий год, Текущий  месяц,
        Валидное имя владельца(Латиница Верхний регистр), валидный CVC код

    */
    @DisplayName("Форма: Дебит; Номер карты: Случайный; Дата(год): Текущий; Дата(Месяц): Текущий; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("СЛУЧАЙНАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Случайный номер карты; Текущий год, Текущий  месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
    void shouldCurrentDateDebitCardRandomCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoCurrentDateRandomCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.failNotificationPaymentCardPage();
    }

    /*
№24.    Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
        Случайный номер карты; валидный год, валидный месяц,
        Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
    */
    @DisplayName("Форма: Дебит; Номер карты: Случайный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через пробел, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("СЛУЧАЙНАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Случайный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
    void shouldValidDebitCardInfoWithTwoWordsNameThroughSpaceRandomCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughSpaceRandomCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.failNotificationPaymentCardPage();
    }

    /*
№25.    Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:
    Случайный номер карты; валидный год, валидный месяц,
    Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
    */
    @DisplayName("Форма: Дебит; Номер карты: Случайный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через дефис, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("СЛУЧАЙНАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Случайный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
    void shouldValidDebitCardInfoWithTwoWordsNameThroughHyphenRandomCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughHyphenRandomCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.failNotificationPaymentCardPage();
    }

    /*

             ФОРМА ДЛЯ ПОКУПКИ В КРЕДИТ

№26.    Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
    Случайный номер карты; валидный год, валидный месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    @DisplayName("Форма: Кредит; Номер карты: Случайный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("СЛУЧАЙНАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Случайный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ данными")
    void shouldValidCreditCardRandomCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoRandomCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.failNotificationCreditCardPage();
    }

    /*
№27.    Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
    Случайный номер карты; Текущий год, Текущий  месяц,
    Валидное имя владельца(Латиница Верхний регистр), валидный CVC код
    */
    @DisplayName("Форма: Кредит; Номер карты: Случайный; Дата(год): Текущий; Дата(Месяц): Текущий; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("СЛУЧАЙНАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Случайный номер карты; Текущий год, Текущий  месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ данными")
    void shouldCurrentDateCreditCardRandomCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoCurrentDateRandomCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.failNotificationCreditCardPage();
    }

    /*
№28.    Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
    Случайный номер карты; валидный год, валидный месяц,
    Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код
    */
    @DisplayName("Форма: Кредит; Номер карты: Случайный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через пробел, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("СЛУЧАЙНАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Случайный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через пробел(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ данными")
    void shouldValidCreditCardInfoWithTwoWordsNameThroughSpaceRandomCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughSpaceRandomCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.failNotificationCreditCardPage();
    }

    /*
№29.    Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:
    Случайный номер карты; валидный год, валидный месяц,
    Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код
    */
    @DisplayName("Форма: Кредит; Номер карты: Случайный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница через дефис, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("СЛУЧАЙНАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Заполнение формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Случайный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца через дефис(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка заполнение формы покупки в кредит ВАЛИДНЫМИ данными")
    void shouldValidCreditCardInfoWithTwoWordsNameThroughHyphenRandomCardNumber() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoWithTwoWordsNameThroughHyphenRandomCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.failNotificationCreditCardPage();
    }

    /*
    Проверка базы данных

                    ДЕБИТ

        ОДОБРЕННАЯ КАРТА ВАЛИДНЫЕ ДАННЫЕ
     */
    @DisplayName("Форма: Дебит; Номер карты: Одобренный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ПРОВЕРКУ ЗАПИСЕЙ В БАЗЕ ДАННЫХ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Проверка записи в базе данных статуса карты для заполненой формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Одобреный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка записи в базе данных статуса карты для заполненой формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
    void shouldValidDebitCardApprovedCardNumberCheckingDatabase() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoApprovedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        paymentCardPage.successNotificationPaymentCardPage();

        var expected = getApprovedCardStatus();
        var actual = getStatusPaymentStatus();
//       TODO Добавить проверку по базе данных возможно надо будет сделать отдельный клас для проверок на бекэнд
        Assertions.assertEquals(expected, actual);
    }

    /*
    ЗАБЛОКИРОВАННАЯ КАРТА ВАЛИДНЫЕ ДАННЫЕ
     */
    @DisplayName("Форма: Дебит; Номер карты: Заблокированный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ПРОВЕРКУ ЗАПИСЕЙ В БАЗЕ ДАННЫХ")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Story("Проверка записи в базе данных статуса карты для заполненой формы покупки по дебитовой карте ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка записи в базе данных статуса карты для заполненой формы покупки по дебитовой карте ВАЛИДНЫМИ данными")
    void shouldValidDebitCardDeclinedCardNumberCheckingDatabase() throws InterruptedException {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var paymentCardPage = startPage.playWithDebitCardButton();
        var validCardInfo = getValidCardInfoDeclinedCardNumber();
        paymentCardPage.fillTheForm(validCardInfo);
        Thread.sleep(15000);

        var expected = getDeclinedCardStatus();
        var actual = getStatusPaymentStatus();
//       TODO Добавить проверку по базе данных возможно надо будет сделать отдельный клас для проверок на бекэнд
        Assertions.assertEquals(expected, actual);
    }

    /*
                    КРЕДИТ
           ОДОБРЕННАЯ КАРТА ВАЛИДНЫЕ ДАННЫЕ
     */
    @DisplayName("Форма: Кредит; Номер карты: Одобреный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ПРОВЕРКУ ЗАПИСЕЙ В БАЗЕ ДАННЫХ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Проверка записи в базе данных статуса карты для заполненой формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Одобреный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка записи в базе данных статуса карты для заполненой формы покупки в кредит ВАЛИДНЫМИ данными")
    void shouldValidCreditCardApprovedCardNumberCheckingDatabase() {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoApprovedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
        creditCardPage.successNotificationCreditCardPage();

        var expected = getApprovedCardStatus();
        var actual = getCreditStatus();
//       TODO Добавить проверку по базе данных возможно надо будет сделать отдельный клас для проверок на бекэнд
        Assertions.assertEquals(expected, actual);
    }

    /*
    ЗАБЛОКИРОВАННАЯ КАРТА ВАЛИДНЫЕ ДАННЫЕ
     */
    @DisplayName("Форма: Кредит; Номер карты: Заблокированный; Дата(год): Валидный; Дата(Месяц): Валидный; Имя: Латиница, Верхний регистр; CVC: Валидный")
    @Test
    @Feature("ТЕСТЫ НА ПРОВЕРКУ ЗАПИСЕЙ В БАЗЕ ДАННЫХ")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Story("Проверка записи в базе данных статуса карты для заполненой формы покупки в кредит ВАЛИДНЫМИ данными:\n" +
            "Заблокированный номер карты; валидный год, валидный месяц,\n" +
            "Валидное имя владельца(Латиница Верхний регистр), валидный CVC код")
    @Owner("Никита студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка записи в базе данных статуса карты для заполненой формы покупки в кредит ВАЛИДНЫМИ данными")
    void shouldValidCreditCardDeclinedCardNumberCheckingDatabase() throws InterruptedException {
        open("http://localhost:8080");
        var startPage = new StartPage();
        var creditCardPage = startPage.playWithCreditCardButton();
        var validCardInfo = getValidCardInfoDeclinedCardNumber();
        creditCardPage.fillTheForm(validCardInfo);
            Thread.sleep(15000);

            var expected = getDeclinedCardStatus();
            var actual = getCreditStatus();
            Assertions.assertEquals(expected, actual);

    }
}