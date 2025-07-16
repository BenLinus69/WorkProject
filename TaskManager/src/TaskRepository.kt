import java.time.LocalDate

interface TaskRepository {
    fun getTasks() : List<Task>
    fun updateTask(task: Task, newtitle: String = task.title, newdesc: String = task.description, newdate: LocalDate = task.dueDate)
    fun addTask(task: Task) : Boolean
    fun deleteTask(task: Task) : Boolean
    fun completeTask(task: Task)
}