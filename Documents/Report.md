# Отчёт по итогам тестирования:

Отчёт по результату автоматизированного тестированию функционала покупки и оформления кредита по данным карты веб-сервиса покупки тура
"Путешествие дня".

## Количество Тест-кейсов:

*Результат прогона тестов не зависит от подключенной БД, поэтому предоставлен единый отчет по тестам.*

Всего было пройдено 77 Тест-кейсов. Общий процент успешных тестов: 63,63%.

Тесты были разбиты на следующие классы:

* NegativeTests - в нем проверяются сценарии, когда пользователь вводит неверные или невалидные данные, производит действия, которые нарушают логику работы веб-сервиса.
* HappyTests - в нем проверяется обычное поведение пользователя, когда все происходит, как было запланировано, без исключений и ошибок;
* APITest - тестирование REST API c помощью библиотеки Rest Assured);

![Report1.jpg](pic%2FReport1.jpg)

* NegativeTests - 30 тестов пройдено, 30 тестов не пройдено.
* HappyTests - 23 тестов пройден, 10 тестов не пройдено.
* APITest - все 4 теста пройдены

## Результаты тестов по градации серьёзности:

![Report2.jpg](pic%2FReport2.jpg)

## Результаты тестов по тестируемому функционалу:

![Report3.jpg](pic%2FReport3.jpg)

### Общие итоги:

|                | Кол-во тестов | Passed | Failed | Passed, % |
|:---------------|:-------------:|:------:|:------:|----------:|
| APITest        |       4       |   4    |   0    |      100% |
| HappyTests     |      33       |   23   |   10   |    69.70% |
| NegativeTests  |      40       |   22   |   18   |       55% |
| Всего          |      77       |   49   |   28   |    63.63% |

В результате прогона тестов было составлено 8 [issue](https://github.com/Nikita4786/Diplom/issues). 

## Общие рекомендации

* Исправить орфографические ошибки
* Сложный поиск CSS Селекторов. Нужно создать уникальные для всей страницы (либо в конкретной её области) идентификаторы для элементов, собственные атрибуты с префиксом data-, например, data-id.
* Большинство багов не являются критичными. Система отображает ошибку при заполнении формы, но неправильно ее идентифицирует (вместо "Поле обязательно для заполнения" система отображает "Неверный формат")
* Для поля "Месяц" ввести ограничение на ввод данных. Сделать возможным ввод только цифровых значений от 01 до 12.
* Для поля "Владелец" ввести ограничение на ввод данных. Сделать возможным заполнение формы только на латинице, автоматически переводя буквы в верхний регистр. Спецсимволы и цифры вводить нельзя (дефис, пробел и апостроф  допустимы).