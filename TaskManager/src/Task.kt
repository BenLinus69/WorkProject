import java.util.Date

data class Task(
    private val title : String,
    private val description: String,
    private val dueDate: Date,
    private val isCompleted: Boolean
)
{
    fun getTitle():String = title
    fun getDesc():String = description
    fun getDate():Date = dueDate
    fun getComp():Boolean = isCompleted

}