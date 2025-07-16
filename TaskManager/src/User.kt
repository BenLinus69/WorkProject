data class User(
    private val name : String,
    private val tasks : MutableList<Task> = mutableListOf()
)
{
    fun getTasks(): MutableList<Task> = tasks
    fun getName(): String = name
}