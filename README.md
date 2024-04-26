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

- `/auth/reg` - регистрация нового пользователя
- `/auth/login` - вход пользователя
- `/prod/add` - добавление нового продукта
- `/prod/all` - получение всех продуктов

## Docker

Для запуска проекта с помощью Docker, вы можете использовать следующие команды:

```bash
docker build -t имя_вашего_образа .
docker run -p 8080:8080 имя_вашего_образа