# Название вашего проекта
Rest API for Job Interview

## Описание проекта

Проект представляет собой REST API для работы с продуктами. 
Пользователь может зарегистрироваться, войти в систему, добавить новый продукт 
и получить список всех продуктов.
## Технологии

- Java
- Spring Security
- Spring Data JPA
- H2 Database
- Lombok
- Docker
- Swagger
- JWT
- Hibernate
- Spring Boot
- Maven

## Как запустить проект

1. Клонируйте репозиторий
2. Установите необходимые зависимости
3. Запустите проект

## Эндпоинты

- 1 (post) /auth/reg - для регистрации
Нужно отправить такой JSON
{
"username": "Joni",
 "password": "123456789",
 ""confirm Password": "123456789",
 ""fullName": "Мурат Жанибек Канибекулы",
 "email": "joni@gmail.com",
 ""photo URL": "https:/photo/url"
}
и он вернет jwt-token для авторизации и уже с ним можно пользоваться сервисом.
Нужно вставить его в http header – key: Authorization val: jwt-token
- 2(post) /auth/login - Для входа он возвращает jwt-token но
только если человек зарегистрирован
Нужно отправить такой JSON
{
"username": "Joni",
"password": "123456789"
}

- 3(post) /prod/add - для добавления продуктов
{
 "name": "phone",
 "weight": 15,
 ""description": "var root device",
 "count": 50,
 "type": "electronic"
}

- 4(get) /prod/all - для получения всех продуктов
Возвращает JSON с ответом

## Docker

Для запуска проекта с помощью Docker, вы можете использовать следующие команды:

```bash
docker build -t имя_вашего_образа .
docker run -p 8080:8080 имя_вашего_образа
