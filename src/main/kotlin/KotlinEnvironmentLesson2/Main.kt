package KotlinEnvironmentLesson2

fun main() {
    val contacts = ArrayList<Person>()


    while (true) {
        print("Введите команду: ")

        when(val input = readlnOrNull()) {
            "exit" -> {
                println("Программа завершена.")
                break
            }
            "help" -> {
                println("Список команд:")
                println("exit - завершить программу")
                println("help - показать список команд")
                println("add <Имя> phone <Номер телефона> - добавить контакт с номером телефона")
                println("add <Имя> email <Адрес электронной почты> - добавить контакт с email адресом")
            }
            else -> {
                try {
                    val command = readCommand(input ?: "")
                    if (command.isValid()) {
                        when (command) {
                            is AddCommand -> {
                                contacts.add(command.person)
                                println("Контакт успешно добавлен. $contacts")
                            }
                            is ShowCommand -> {
                                val lastContact = contacts.lastOrNull()
                                println(lastContact ?: "Not initialized")
                            }
                        }
                    } else {
                        println("Некорректные данные для команды. Введите 'help' для списка команд.")
                    }
                } catch (e: IllegalArgumentException) {
                    println("Некорректная команда. Введите 'help' для списка команд.")
                }
            }

        }
    }
}