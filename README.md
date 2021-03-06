### Запуск приложения
Перед запуском необходимо выполнить следующие предусловия. Если у вас уже есть необходимое ПО, то понадобится только п.1 и запуск Docker.

#### Предусловия:

1. Необходимо склонировать [репозиторий](https://github.com/shanedasha/Diplom.git) ```git clone```.
2. Установить и запустить Docker Desktop. Это можно сделать здесь в зависимости от операционной системы. 
3. Открыть проект в IntelliJ IDEA.

#### Запуск
1.Запустить необходимые базы данных (MySQL и PostgreSQL), а также NodeJS. Параметры для запуска хранятся в файле ```docker-compose.yml```. Для запуска необходимо ввести в терминале команду:
```docker-compose up```.

2. В новой вкладке терминала ввести следующую команду в зависимости от базы данных
* ```java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -jar artifacts/aqa-shop.jar``` - для MySQL
* ```java -Dspring.datasource-postgresql.url=jdbc:postgresql://localhost:5432/app -jar artifacts/aqa-shop.jar``` - для PostgreSQL
3. Приложение должно запуститься и работать по адресу http://localhost:8080/.

#### Запуск тестов
В новой вкладке терминала ввести команду в зависимости от запущенной БД в п.2 Запуска:
* ```gradlew clean test -Ddb.url=jdbc:mysql://localhost:3306/app``` - для MySQL
* ```gradlew clean test -Ddb.url=jdbc:postgresql://localhost:5432/app``` - для PostgreSQL

#### Перезапуск приложения и тестов
Если необходимо перезапустить приложение и/или тесты (например, для другой БД), необходимо выполнить остановку работы в запущенных ранее вкладках терминала, нажав в них Ctrl+С.

