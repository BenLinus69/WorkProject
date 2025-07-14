import java.time.LocalDate

interface TaskRepository {
    fun getTasks() : List<Task>
    fun updateTask(task: Task, newtitle: String = task.getTitle(), newdesc: String = task.getDescription(), newdate: LocalDate = task.getDate(), newcomp: Boolean = task.getIsCompleted())
    fun addTask(task: Task)
    fun deleteTask(task: Task)
}