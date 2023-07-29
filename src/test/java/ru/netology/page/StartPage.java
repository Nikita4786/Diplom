package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;


public class StartPage {

//    селекторы для кнопок покупки тура
    private static final SelenideElement buyWithDebitCardButton = $(byText("Купить"));
    private static final SelenideElement buyWithCreditCardButton = $(byText("Купить в кредит"));

//   селектор для виджета "Путишествие дня"
    private static final SelenideElement hedar = $(withText("Путешествие дня"));

//   Проверка открытия страницы
    @Step("Проверка Открытия стартовой страницы")
    public void startPageHedar() {
        hedar.shouldBe(visible);
    }

//    Нажатие кнопок покупки
    @Step("Нажатие кнопки \"Купить\"")
    public PaymentCardPage playWithDebitCardButton() {
        buyWithDebitCardButton.click();
        return new PaymentCardPage();
    }

    @Step("Нажатие кнопки \"Купить в кредит\"")
    public CreditCardPage playWithCreditCardButton() {
        buyWithCreditCardButton.click();
        return new CreditCardPage();
    }

}