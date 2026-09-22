# Эмулятор оболочки ОС

## 1. Общее описание
GUI-эмулятор UNIX-подобной оболочки на Java Swing.
Вариант №10, этап 1.

## 2. Функции и настройки
- Окно с заголовком `Эмулятор - [username@hostname]`
- Команды: `ls`, `cd` (заглушки), `exit`
- Раскрытие переменных: `$HOME`, `$USER`
- Обработка ошибок для неизвестных команд

## 3. Сборка и запуск
Сборка:
javac -d out src/main/java/ru/miem/shell/Main.java

Запуск:
java -cp out ru.miem.shell.Main

Запуск тестов: на этапе 1 автотесты не реализованы.

## 4. Примеры использования
Введите в поле ввода:

VFS> ls -La
ls -La

VFS> cd $HOME
cd C:\Users\Aleksandra

VFS> blabla
Unknown command: blabla

VFS> exit
(окно закрывается)