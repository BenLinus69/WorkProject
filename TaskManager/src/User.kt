data class User(
    val name: String,
    val tasks: MutableList<Task> = mutableListOf()
)