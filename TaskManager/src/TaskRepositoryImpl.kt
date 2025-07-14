import java.util.*

class TaskRepositoryImpl(user : User) : TaskRepository {
    private val tasks : MutableList<Task> = user.getTasks()
    override fun getTasks() = tasks.toList()

    override fun updateTask(task: Task, newtitle: String, newdesc: String, newdate: Date, newcomp: Boolean) {
        val updatedTask = task.copy(title = newtitle, description = newdesc, dueDate = newdate, isCompleted = newcomp)
        tasks.removeIf { it == task }
        addTask(updatedTask)
    }

    override fun addTask(task: Task) {
        tasks.add(task)
    }

    override fun deleteTask(task: Task) {
        tasks.removeIf{tasks.contains(task)}
    }
}