import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Task(val title: String, val description: String, val dueDate: LocalDate, val isCompleted: Boolean = false){
    override fun toString(): String {
        return "Task{\n" +
                "title='$title',\n" +
                "description='$description',\n" +
                "dueDate={${dueDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))}},\n" +
                "isCompleted=$isCompleted)\n}"
    }}