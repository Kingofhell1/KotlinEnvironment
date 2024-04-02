package KotlinEnvironmentLesson2

sealed class Command {
    abstract fun isValid():Boolean
}