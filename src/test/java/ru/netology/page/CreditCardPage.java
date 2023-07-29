package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.netology.data.DataHelper;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreditCardPage extends StartPage {

//      селектор для виджета "Кредит по данным карты"

    public final SelenideElement head = $(byText("Кредит по данным карты"));

    //      селекторы для кнопок покупки тура
    private static final SelenideElement buyWithDebitCardButton = $(byText("Купить"));
    private static final SelenideElement buyWithCreditCardButton = $(byText("Купить в кредит"));

    //      селекторы для полей ввода данных
    private final ElementsCollection fields = $$(".input__control");
    private final SelenideElement fieldCardNumber = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement fieldMonth = $("[placeholder='08']");
    private final SelenideElement fieldYear = $("[placeholder='22']");
    private final SelenideElement fieldUserName = fields.get(3);
    private final SelenideElement fieldCVC = $("[placeholder='999']");

    //    селектор для кнопки Продолжить
    private final SelenideElement buttonContinue = $(byText("Продолжить"));

    //    селекторы для всплывающих окон
    private final SelenideElement successNotification = $(withText("Операция одобрена Банком."));
    private final SelenideElement failNotification = $(withText("Ошибка! Банк отказал в проведении операции."));

    //    селекторы для сообщений об ошибках ввода
    private final SelenideElement errorFormatMessage = $(withText("Неверный формат"));
    private final SelenideElement errorTermMessage = $(withText("Неверно указан срок действия карты"));
    private final SelenideElement cardExpiredMessage = $(withText("Истёк срок действия карты"));
    private final SelenideElement fieldFillRequiredMessage = $(withText("Поле обязательно для заполнения"));

    //    селектор для предупреждения об ошибке заполнения поля
    private final ElementsCollection invalidNotification = $$(".input__sub");

    //    Проверка перехода на форму покупке тура в кредит
    @Step("Проверка перехода на форму покупке тура в кредит")
    public void creditCardPageHeader() {
        head.shouldBe(visible);
    }

    //  Нажати кнопки "Купить"
    @Step("Нажати кнопки \"Купить\"")
    public PaymentCardPage playWithDebitCardButton() {
        buyWithDebitCardButton.click();
        return new PaymentCardPage();
    }

    //    Общая форма для  отправки данных
    public void fillTheForm(DataHelper.CardInfo cardInformation) {
        fieldCardNumber.setValue(cardInformation.getNumber());
        fieldMonth.setValue(cardInformation.getMonth());
        fieldYear.setValue(cardInformation.getYear());
        fieldUserName.setValue(cardInformation.getUser());
        fieldCVC.setValue(cardInformation.getCvc());
        buttonContinue.click();
    }

    //    Проверка видимости всплывающего окна "Операция одобрена Банком."
    @Step("Проверка видимости всплывающего окна \"Операция одобрена Банком.\"")
    public void successNotificationCreditCardPage() {
        successNotification.shouldBe(visible, Duration.ofSeconds(15));
    }

    //    Проверка видимости всплывающего окна "Ошибка! Банк отказал в проведении операции."
    @Step("Проверка видимости всплывающего окна \"Ошибка! Банк отказал в проведении операции.\"")
    public void failNotificationCreditCardPage() {
        failNotification.shouldBe(visible, Duration.ofSeconds(15));
    }

    //    Проверка видимости предупреждения о незаполненности всех полей в форме
    @Step("Проверка видимости предупреждения о незаполненности всех полей в форме")
    public void fillAllField() {
        for (SelenideElement x : invalidNotification) {
            x.shouldBe(exactText("Поле обязательно для заполнения"));
        }
    }

    //      Проверка видимости предупреждения о незаполнености поля в форме для номера карты
    @Step("Проверка видимости предупреждения о незаполнености поля в форме для номера карты")
    public void fillCardNumberRequest() {
        invalidNotification.first().shouldHave(exactText("Поле обязательно для заполнения"));
    }

    //      Проверка видимости предупреждения о не заполненности поля в формах Год; Месяц; Владелец
    @Step("Проверка видимости предупреждения о не заполненности поля в формах")
    public void fillRequest() {
        fieldFillRequiredMessage.shouldBe(visible);
    }

    //      Проверка видимости предупреждения о незаполненности поля в форме Код cvc
    @Step("Проверка видимости предупреждения о незаполненности поля в форме Код cvc")
    public void fillCVCRequest() {
        invalidNotification.last().shouldBe(exactText("Поле обязательно для заполнения"));
    }

    //    Проверка видимости предупреждения о неверно заполненном поле месяц
    @Step("Проверка видимости предупреждения о неверно заполненном поле месяц")
    public void invalidDateMont() {
        errorTermMessage.shouldBe(visible);
    }

    //    Проверка видимости предупреждения о не верном формате заполнения поля месяц
    @Step("Проверка видимости предупреждения о не верном формате заполнения поля месяц")

    public void  errorFormatMessageCardPage() {
        errorFormatMessage.shouldBe(visible);
    }

    //    Проверка видимости предупреждения о неверно заполненном поле Год
    @Step("Проверка видимости предупреждения о неверно заполненном поле Год")
    public void invalidDateYears() {
        errorTermMessage.shouldBe(visible);
    }

    //    Проверка видимости предупреждения о неверно заполненном поле Год
    @Step("Проверка видимости предупреждения о неверно заполненном поле Год")
    public void invalidExpiredDateYears() {
        cardExpiredMessage.shouldBe(visible);
    }

    //    Проверка видимости предупреждения о не верном формате заполнения поля Год
    @Step("Проверка видимости предупреждения о не верном формате заполнения поля Год")
    public void  errorFormatMessageCardPageYears() {
        errorFormatMessage.shouldBe(visible);
    }

    //    Проверка видимости предупреждения о неверном формате заполнения поля Имя
    @Step("Проверка видимости предупреждения о неверном формате заполнения поля Имя")
    public void errorFormatMessageCardPageName() {
        errorFormatMessage.shouldBe(visible);
    }

    //    Проверка видимости предупреждения о неверном формате заполнения поля Код CVC
    @Step("Проверка видимости предупреждения о неверном формате заполнения поля Код CVC")
    public void errorFormatMessageCardPageCVC() {
        errorFormatMessage.shouldBe(visible);
    }
}