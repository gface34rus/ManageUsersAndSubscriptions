# Manage Users And Subscriptions

## Описание

Manage Users And Subscriptions - это RESTful API, разработанный с использованием Spring Boot, который позволяет управлять пользователями и их подписками. Проект предоставляет функциональность для создания, обновления и удаления пользователей, а также для управления подписками.

## Технологии

- **Java**: 17
- **Spring Boot**: 3.4.5
- **Spring Data JPA**: 3.4.5
- **PostgreSQL**: база данных
- **Maven**: управление зависимостями

## Установка

1. **Клонируйте репозиторий:**
   ```bash
   git clone [repository_url]
   cd ManageUsersAndSubscriptions
Соберите проект:

COPY
mvn clean install
Запустите приложение:

COPY
mvn spring-boot:run
Доступ к API:

API будет доступен по адресу http://localhost:8080.
Использование
Эндпоинты API
Создание нового пользователя

Метод: POST
URL: /users
Тело запроса: объект User (username, password)
Ответ: объект User с ID.
Получение данных пользователя по ID

Метод: GET
URL: /users/{id}
Ответ: объект User.
Обновление данных пользователя

Метод: PUT
URL: /users/{id}
Тело запроса: объект User с обновленными данными.
Ответ: обновленный объект User.
Удаление пользователя

Метод: DELETE
URL: /users/{id}
Ответ: 204 No Content.
Добавление подписки для пользователя

Метод: POST
URL: /users/{userId}/subscriptions
Тело запроса: объект Subscription (serviceName)
Ответ: объект Subscription с ID.
Получение подписок для пользователя

Метод: GET
URL: /users/{userId}/subscriptions
Ответ: список объектов Subscription.
Удаление подписки

Метод: DELETE
URL: /users/{userId}/subscriptions/{sub_id}
Ответ: 204 No Content.
Получение топовых подписок

Метод: GET
URL: /users/{userId}/subscriptions/top
Ответ: список объектов Subscription.
Развертывание
Проект можно развернуть как Spring Boot приложение. Он может быть упакован в JAR файл и запущен с помощью команды:

COPY
java -jar target/manage-users-and-subscriptions.jar
