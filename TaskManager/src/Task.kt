import java.time.LocalDate

data class Task(val title: String, val description: String, val dueDate: LocalDate, val isCompleted: Boolean = false){
    override fun toString(): String {
        return "Task{\n" +
                "title='$title',\n" +
                "description='$description',\n" +
                "dueDate=$dueDate,\n" +
                "isCompleted=$isCompleted)\n}"
    }}