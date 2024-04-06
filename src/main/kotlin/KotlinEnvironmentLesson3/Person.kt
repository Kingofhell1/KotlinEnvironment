package KotlinEnvironmentLesson3

data class Person(val name:String){
    val phone: MutableList<String> = mutableListOf()
    val email: MutableList<String> = mutableListOf()
    fun addPhone(phones: String) {
        phone.add(phones)
    }

    fun addEmail(emails: String) {
        email.add(emails)
    }

    override fun toString(): String {
        return "Name: $name\nPhones: $phone\nEmails: $email"
    }
}