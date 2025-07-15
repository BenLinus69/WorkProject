data class User(
    private val name : String,
    private val tasks : MutableList<Task> = mutableListOf()
)
{
    fun getName(): String = name
    fun getTasks() = tasks
}