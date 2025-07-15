import java.time.LocalDate

interface TaskRepository {
    fun getTasks() : List<Task>
    fun updateTask(task: Task, newtitle: String = task.title, newdesc: String = task.description, newdate: LocalDate = task.dueDate)
    fun addTask(task: Task)
    fun deleteTask(task: Task)
    fun completeTask(task: Task)
}