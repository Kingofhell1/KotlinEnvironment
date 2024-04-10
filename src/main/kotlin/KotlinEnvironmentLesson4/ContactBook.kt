package KotlinEnvironmentLesson4

import java.io.File
import java.io.FileOutputStream
import javax.swing.UIManager.put


class ContactBook {
    val people = mutableListOf<Person>()

    fun addPerson(name : String) {
        val person = people.firstOrNull {it.name == name} ?: Person(name)
        person.name
        if (person !in people) people.add(person)
    }
    fun addPhone(name: String, phone: String) {
        val person = people.find { it.name == name } ?: Person(name)
        person.phone.add(phone)
        if (person !in people) people.add(person)
    }

    fun addEmail(name: String, email: String) {
        val person = people.find { it.name == name } ?: Person(name)
        person.email.add(email)
        if (person !in people) people.add(person)
    }

    fun show(name: String) {
        val person = people.find { it.name == name } ?: return
        println("Phones: ${person.phone.joinToString()}")
        println("Emails: ${person.email.joinToString()}")
    }

    fun find(value: String) {
        val result = people.filter { it.phone.contains(value) || it.email.contains(value) }
        if (result.isEmpty()) {
            println("No results found")
        } else {
            println("Found:")
            result.forEach { println(it.name) }
        }
    }
    fun export() {
        val json = """
            {
                "people": [
                    ${people.joinToString(",\n") { "{\"name\": \"${it.name}\", \"phones\": \"[${it.phone.joinToString(",")}]\", \"emails\": \"[${it.email.joinToString(",")}]\"}" }}
                ]

            }
        """.trimIndent()

            File("phonebook.json").writeText(json)
            println("    Экпорт выполнен успешно. Смотри файл phonebook.json.")
        }
    }

// ---------------------------------------------------------------СТАРЫЙ КОД-----------------------------------------------------------------
//        val json = json {
//            array {
//                for (person in people.values) {
//                    obj {
//                        "name" to person.name
//                        "phones" to person.phone
//                        "emails" to person.email
//                    }
//                }
//            }
//        }
//        val json = people.joinToString(prefix = "[", postfix = "]") {
//            """{ "name" : "${it.name}", "phones" : ${it.phone}, "emails" : ${it.email} }"""
//        }
//        File("phone_book.json").writeText(json)
//    }

//        val json = JsonObject()
//        json.put("", people)
//        json.json {
//
//        }
//        File(file).writeText(json.toString())

//    fun addPerson(person: Person) {
//         people[person.name] = person
//    }
//
//    fun addPhone(name: String, phone: String) {
//        people[name]?.addPhone(phone)
//    }
//
//    fun addEmail(name: String, email: String) {
//        people[name]?.addEmail(email)
//    }
//
//    fun show(name: String) {
//        println(people[name])
//    }
//
//    fun find(value: String) {
//        val results = mutableListOf<Person>()
//        for (person in people.values) {
//            if (person.phone.contains(value) || person.email.contains(value)) {
//                results.add(person)
//            }
//        }
//        println("Found: $results")
//    }








