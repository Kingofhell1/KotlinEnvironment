package KotlinEnvironmentLesson2

fun readCommand(input: String): Command{
    val regexAdd = Regex("""add (\D+) (phone|email) (.+)""")

    return when {
        input == "show" -> ShowCommand(null)

        regexAdd.matches(input) -> {
            val matchResult = regexAdd.find(input)!!
            val name = matchResult.groupValues[1]
            val type = matchResult.groupValues[2]
            val value = matchResult.groupValues[3]

            when (type) {
                "phone" -> AddCommand(Person(name, value, ""))
                "email" -> AddCommand(Person(name, "", value))
                else -> throw IllegalArgumentException("Invalid command format")
            }
        }
        else -> throw IllegalArgumentException("Invalid command format")
    }
}