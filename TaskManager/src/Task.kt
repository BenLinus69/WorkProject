import java.time.LocalDate

data class Task(
    private val title : String,
    private val description: String,
    private val dueDate: LocalDate,
    private val isCompleted: Boolean
)
{
    fun getTitle():String = title
    fun getDesc():String = description
    fun getDate():LocalDate = dueDate
    fun getComp():Boolean = isCompleted

}