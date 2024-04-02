package KotlinEnvironmentLesson1

fun main() {
    val contacts = ArrayList<Pair<String, String>>()
            while (true) {
                print("Введите команду: ")
                val input = readLine()

                when {
                    input == "exit" -> {
                        println("Программа завершена.")
                        break
                    }
                    input == "help" -> {
                        println("Список команд:")
                        println("exit - завершить программу")
                        println("help - показать список команд")
                        println("add <Имя> phone <Номер телефона> - добавить контакт с номером телефона")
                        println("add <Имя> email <Адрес электронной почты> - добавить контакт с email адресом")
                    }
                    input?.startsWith("add") == true -> {
                        val regex = Regex("""add (\D+) (phone|email) (.+)""")
                        val matchResult = regex.find(input!!)

                        if (matchResult != null) {
                            val name = matchResult.groupValues[1]
                            val type = matchResult.groupValues[2]
                            val value = matchResult.groupValues[3]

                            if (type == "phone") {
                                if (value.matches(Regex("""^\+?\d+[\d-]*${'$'}"""))) {
                                    contacts.add(Pair(name, value))
                                    println("Контакт успешно добавлен. $contacts")
                                } else {
                                    println("Некорректный номер телефона.")
                                }
                            } else if (type == "email") {
                                if (value.matches(Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"))) {
                                    contacts.add(Pair(name, value))
                                    println("Контакт успешно добавлен. $contacts")
                                } else {
                                    println("Некорректный адрес электронной почты.")
                                }
                            }
                        } else {
                            println("Некорректный формат команды.")
                        }
                    }
                    else -> println("Некорректная команда. Введите 'help' для списка команд.")
                }
            }
}