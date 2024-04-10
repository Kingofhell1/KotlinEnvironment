 * Seminar_1

Написать программу, которая обрабатывает введённые пользователем в консоль команды:
exit
help
add <Имя> phone <Номер телефона>
add <Имя> email <Адрес электронной почты>

После выполнения команды, кроме команды exit, программа ждёт следующую команду,
[Ссылка на первый семинар](https://github.com/Kingofhell1/KotlinEnvironment/blob/main/src/main/kotlin/KotlinEnvironmentLesson1/Main.kt)

 * Seminar_2

- За основу берём код решения домашнего задания из предыдущего семинара и дорабатываем его.

- Создайте иерархию sealed классов, которые представляют собой команды. В корне иерархии интерфейс Command.
- В каждом классе иерархии должна быть функция isValid(): Boolean, которая возвращает true, если команда введена с корректными аргументами. Проверку телефона и email нужно перенести в эту функцию.
- Напишите функцию readCommand(): Command, которая читает команду из текстового ввода, распознаёт её и возвращает один из классов-наследников Command, соответствующий введённой команде.
- Создайте data класс Person, который представляет собой запись о человеке. Этот класс должен содержать поля:
    * name – имя человека
    * phone – номер телефона
    * email – адрес электронной почты
- Добавьте новую команду show, которая выводит последнее значение, введённой с помощью команды add. Для этого значение должно быть сохранено в переменную типа Person. Если на момент выполнения команды show не было ничего введено, нужно вывести на экран сообщение “Not initialized”.
- Функция main должна выглядеть следующем образом. Для каждой команды от пользователя:
- Читаем команду с помощью функции readCommand
- Выводим на экран получившийся экземпляр Command
- Если isValid для команды возвращает false, выводим help. Если true, обрабатываем команду внутри when.
[Ссылка на второй семинар](https://github.com/Kingofhell1/KotlinEnvironment/tree/main/src/main/kotlin/KotlinEnvironmentLesson2)

 * Seminar_3

Продолжаем дорабатывать домашнее задание из предыдущего семинара. За основу берём код решения из предыдущего домашнего задания.

1. Измените класс Person так, чтобы он содержал список телефонов и список почтовых адресов, связанных с человеком.
2. Теперь в телефонной книге могут храниться записи о нескольких людях. Используйте для этого наиболее подходящую структуру данных.
3. Команда AddPhone теперь должна добавлять новый телефон к записи соответствующего человека.
4. Команда AddEmail теперь должна добавлять новый email к записи соответствующего человека.
5. Команда show должна принимать в качестве аргумента имя человека и выводить связанные с ним телефоны и адреса электронной почты.
6. Добавьте команду find, которая принимает email или телефон и выводит список людей, для которых записано такое значение.

[Ссылка на третий семинар](https://github.com/Kingofhell1/KotlinEnvironment/tree/main/src/main/kotlin/KotlinEnvironmentLesson3)

 * Seminar_4
   Продолжаем дорабатывать домашнее задание из предыдущего семинара. За основу берём код решения из предыдущего домашнего задания.

— Добавьте новую команду export, которая экспортирует добавленные значения в текстовый файл в формате JSON. Команда принимает путь к новому файлу. Например
export /Users/user/myfile.json
— Реализуйте DSL на Kotlin, который позволит конструировать JSON и преобразовывать его в строку.
— Используйте этот DSL для экспорта данных в файл.
— Выходной JSON не обязательно должен быть отформатирован, поля объектов могут идти в любом порядке. Главное, чтобы он имел корректный синтаксис. Такой вывод тоже принимается:
[{""emails"": [""ew@huh.ru""],""name"": ""Alex"",""phones"": [""34355"",""847564""]},{""emails"": [],""name"": ""Tom"",""phones"": [""84755""]}]

- Записать текст в файл можно при помощи удобной функции-расширения writeText:
File(""/Users/user/file.txt"").writeText(""Text to write"")

- Под капотом она использует такую конструкцию


FileOutputStream(file).use {
it.write(text.toByteArray(Charsets.UTF_8))
}
[Ссылка на четверртый семинар](https://github.com/Kingofhell1/KotlinEnvironment/tree/main/src/main/kotlin/KotlinEnvironmentLesson4)