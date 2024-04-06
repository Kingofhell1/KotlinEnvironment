package KotlinEnvironmentLesson3

class ContactBook {
    val people = mutableMapOf<String, Person>()

    fun addPerson(person: Person) {
        people[person.name] = person
    }

    fun addPhone(name: String, phone: String) {
        people[name]?.addPhone(phone)
    }

    fun addEmail(name: String, email: String) {
        people[name]?.addEmail(email)
    }

    fun show(name: String) {
        println(people[name])
    }

    fun find(value: String) {
        val results = mutableListOf<Person>()
        for (person in people.values) {
            if (person.phone.contains(value) || person.email.contains(value)) {
                results.add(person)
            }
        }
        println("Found: $results")
    }
}