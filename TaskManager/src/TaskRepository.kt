import java.time.LocalDate

interface TaskRepository {
    fun getTasks() : List<Task>
    fun updateTask(task: Task, newtitle: String = task.getTitle(), newdesc: String = task.getDesc(), newdate: LocalDate = task.getDate(), newcomp: Boolean = task.getComp())
    fun addTask(task: Task)
    fun deleteTask(task: Task)
    fun completeTask(task: Task)
}