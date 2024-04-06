package KotlinEnvironmentLesson3

fun main() {
    val phoneBook = ContactBook()

    while (true) {
        print("Введите команду: ")
        val command = readCommand()
        println(command)
        if (!command.isValid) {
            println("Invalid command. Type 'help' for a list of commands.")
            continue
        }

        when (command) {
            is Command.AddPerson -> command.execute(phoneBook)
            is Command.AddPhone -> command.execute(phoneBook)
            is Command.AddEmail -> command.execute(phoneBook)
            is Command.Show -> command.execute(phoneBook)
            is Command.Find -> command.execute(phoneBook)
            Command.Help -> command.execute(phoneBook)
            Command.Quit -> break
        }
    }
}

fun readCommand(): Command {
    val input = readLine() ?: ""
    val parts = input.split(" ")
    return when (parts[0]) {
        "add" -> {
            when (parts[1]) {
                "person" -> Command.AddPerson(Person(parts[2]))
                "phone" -> Command.AddPhone(parts[2], parts[3])
                "email" -> Command.AddEmail(parts[2], parts[3])
                else -> Command.Help
            }
        }
        "show" -> Command.Show(parts[1])
        "find" -> Command.Find(parts[1])
        "help" -> Command.Help
        "quit" -> Command.Quit
        else -> Command.Help
    }
}