import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Task(val title: String, val description: String, val dueDate: LocalDate, val isCompleted: Boolean = false){
    override fun toString(): String {
        return "$title | ${dueDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))} | ${if (isCompleted) "Completed" else "In Progress"}\n" +
                "Description: $description"
    }}