package KotlinEnvironmentLesson4

class JsonObject(val obj: MutableMap<String, Any>) {
    operator fun set(key: String, value: Any) {
        obj[key] = value
    }

    override fun toString(): String {
        return obj.toString()
    }
}

fun json(init: JsonObject.() -> Unit): String {
    val obj = JsonObject(mutableMapOf())
    obj.init()
    return obj.toString()
}
