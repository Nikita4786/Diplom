package ru.netology.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static ru.netology.data.API.CreditStatus;
import static ru.netology.data.API.PaymentStatus;
import static ru.netology.data.DataHelper.getValidCardInfoApprovedCardNumber;
import static ru.netology.data.DataHelper.getValidCardInfoDeclinedCardNumber;

public class APITest {

    @BeforeAll
    static void setUpAfterAll() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true).savePageSource(true));
    }

    @AfterAll
    static void tearDownAfterAll() {
        SelenideLogger.removeListener("allure");
    }

    @DisplayName("API тест для одобренной карты для формы оплаты по дедитовой карте")
    @Test
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    void shouldGetStatusForApprovedCardNumberWithValidPaymentPage() {
        var validApprovedCard = getValidCardInfoApprovedCardNumber();
        var status = PaymentStatus(validApprovedCard);
        Assertions.assertEquals(true, status.contains("APPROVED"));

    }

    @DisplayName("API тест для одобренной карты для формы покупки тура в кредит")
    @Test
    @Feature("ОДОБРЕННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    void shouldGetStatusForApprovedCardNumberWithValidCreditPage() {
        var validApprovedCard = getValidCardInfoApprovedCardNumber();
        var status = CreditStatus(validApprovedCard);
        Assertions.assertEquals(true, status.contains("APPROVED"));
    }

    @DisplayName("API тест для заблокированной карты для формы оплаты по дедитовой карте")
    @Test
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ПО ДЕБЕТОВОЙ КАРТЕ")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    void shouldGetStatusForDeclinedCardNumberWithValidPaymentPage() {
        var validDeclinedCard = getValidCardInfoDeclinedCardNumber();
        var status = PaymentStatus(validDeclinedCard);
        Assertions.assertEquals(true, status.contains("DECLINED"));
    }

    @DisplayName("API тест для заблокированной карты для формы покупки тура в кредит")
    @Test
    @Feature("ЗАБЛОКИРОВАННАЯ КАРТА")
    @Epic("ФОРМА ПОКУПКИ ТУРА В КРЕДИТ")
    @Owner("Андрей студент 'Нетологии'")
    @Severity(SeverityLevel.CRITICAL)
    void shouldGetStatusForDaclinedCardNumberWithValidCreditPage() {
        var validDeclinedCard = getValidCardInfoDeclinedCardNumber();
        var status = CreditStatus(validDeclinedCard);
        Assertions.assertEquals(true, status.contains("DECLINED"));
    }
}