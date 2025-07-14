import java.time.LocalDate

data class Task(
    private val title : String,
    private val description: String,
    private val dueDate: LocalDate,
    private val isCompleted: Boolean
)
{
    fun getIsCompleted() : Boolean = isCompleted
    fun getDescription(): String = description
    fun getTitle():String = title
    fun getDate():LocalDate = dueDate
}