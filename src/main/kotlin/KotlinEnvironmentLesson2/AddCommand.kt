package KotlinEnvironmentLesson2

class AddCommand(val person: Person): Command(){
    override fun isValid(): Boolean {
        return person.phone.matches(Regex("""^\+?\d+[\d-]*${'$'}""")) || person.email.matches(Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"))
    }

}