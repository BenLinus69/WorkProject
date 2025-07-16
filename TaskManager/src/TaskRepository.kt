import java.time.LocalDate

interface TaskRepository {
    fun getTasks() : List<Task>
    fun updateTask(task: Task, newTitle: String = task.title, newDesc: String = task.description, newDate: LocalDate = task.dueDate)
    fun addTask(task: Task) : Boolean
    fun deleteTask(task: Task) : Boolean
    fun completeTask(task: Task)
}