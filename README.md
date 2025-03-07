## Варианты запуска:
***
### **Если используете IntelliJ IDEA:**

Скорее всего, если не отключали авто-подгрузку зависимостей, библиотеки загрузсятся автоматически.

**! Если что-то пошло не так !**

Попробуйте в правом сайдбаре выбрать Maven, перейти в `Lifecycle` и запустите `clean`, затем `install`

***
### **Если используете другую IDE:**

1. Откройте командную строку (можно открыть сразу в папке с проектом) и перейдите в папку с проектом.
2. Выполните команду `mvn dependency:resolve` (Если используется IntelliJ IDEA, то можно просто нажать на команду, она сработает в папке проекта)

***
### Как пользоваться
1. Запустить сервер: `ExcelMaxValueApplication`;
2. Перейти в браузере по адресу: http://localhost:8080/swagger-ui/index.html
3. Выбрать единственный метод;
4. Можно передать ссылку на собственный файл, **!однако!**, важно соблюдать правила передачи пути к файлу: <br>
Нельзя использовать символ `\` не экранировав его (`\\` - экранированный `\`)
<br>
Таким образом имеем путь к файлу вида: `path\\to\\your\\file.xlsx`;
<br>
Однако проще всего использовать символ `/` вместо `\`;