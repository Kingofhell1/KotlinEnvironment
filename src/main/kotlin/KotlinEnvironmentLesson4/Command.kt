package KotlinEnvironmentLesson4

import java.io.File


sealed class Command {
    abstract fun execute(phoneBook: ContactBook)
    abstract val isValid: Boolean

    data class AddPerson(val person: Person) : Command() {
        override fun execute(phoneBook: ContactBook) {
            phoneBook.addPerson(person.name)
        }

        override val isValid: Boolean
            get() = person.name.isNotBlank()
    }

    data class AddPhone(val name: String, val phone: String) : Command() {
        override fun execute(phoneBook: ContactBook) {
            phoneBook.addPhone(name, phone)
        }

        override val isValid: Boolean
            get() = name.isNotBlank() && phone.matches(Regex("""^\+?\d+[\d-]*${'$'}"""))
    }

    data class AddEmail(val name: String, val email: String) : Command() {
        override fun execute(phoneBook: ContactBook) {
            phoneBook.addEmail(name, email)
        }

        override val isValid: Boolean
            get() = name.isNotBlank() && email.matches(Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"))
    }

    data class Show(val name: String) : Command() {
        override fun execute(phoneBook: ContactBook) {
            phoneBook.show(name)
        }

        override val isValid: Boolean
            get() = name.isNotBlank()
    }

    data class Find(val value: String) : Command() {
        override fun execute(phoneBook: ContactBook) {
            phoneBook.find(value)
        }

        override val isValid: Boolean
            get() = value.isNotBlank()
    }
    class Export : Command() {
        override fun execute(phoneBook: ContactBook) {
            phoneBook.export()
        }
        override val isValid: Boolean
            get() = true
    }
    object Help : Command() {
        override fun execute(phoneBook: ContactBook) {
            println("Available commands:")
            println("add person <name>")
            println("add phone <name> <phone number>")
            println("add email <name> <email address>")
            println("show <name>")
            println("find <phone number or email address>")
            println("export <file path>")
            println("help")
            println("quit")
        }

        override val isValid: Boolean
            get() = true
    }

    object Quit : Command() {
        override fun execute(phoneBook: ContactBook) {}
        override val isValid: Boolean
            get() = true
    }
}
