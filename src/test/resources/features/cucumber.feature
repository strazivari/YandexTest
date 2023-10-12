#language: ru

Функция: Тестирование edujira.ifellow.ru

  Структура сценария: Тестирование сайта eduJira
    Дано Начальная страница
    Когда Пользователь вводит логин "<логин>", пароль "<пароль>" и нажимает Войти
    Когда Пользователь жмет кнопку Проекты и выбирает из списка Тест. Открывается проект
    И На странице указано количество задач
    Тогда Клик по поиску, ввести текст "<поиск>", выбрать первый результат поиска
    Тогда Откроется страница единичного задания, будут выведены Статус задания "<статусзадачи>" и Версия задания "<версиязадачи>"
    Дано Пользователь создает задание, заполняя в нем поля: Тип задачи "<тип>" Тема "<тема>" Исправить в версиях "<версии>" Приоритет "<приоритет>" Метки "<метка>" Описание "<описание>" Окружение "<окружение>" Затронуты версии Исполнитель
    Тогда Выполняются проверки работоспособности статуса задачи Сортировка "<сортировка>" Фильтрация "<фильтр>" статусЗадачиИзмененНа "<статус1>" статусЗадачиИзмененНа "<статус2>" статусЗадачиИзмененНа "<статус3>" статусЗадачиИзмененНа "<статус4>" статусЗадачиИзмененНа "<статус5>"
    Примеры:
      | логин | пароль    | поиск        | версиязадачи | статусзадачи | тип    | тема         | описание                                                             | версии      | приоритет | метка      | окружение     | сортировка                 | фильтр             | статус1 | статус2 | статус3 | статус4 | статус5 |
      | AT16  | Qwerty123 | TestSelenium | Version 2.0  | В РАБОТЕ     | Ошибка | TestSelenium | Шаги:  1.Тест вызванных функций  2.Проверка результатов тестирования | Version 2.0 | Medium    | bugBuzzers | local machine | Сортировать по Cоздано | Мои открытые задачи | РЕШЕННЫЕ | В РАБОТЕ  | ПЕРЕОТКРЫТ | ГОТОВО      | Готово       |