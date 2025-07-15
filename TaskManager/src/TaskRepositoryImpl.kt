import java.time.LocalDate

class TaskRepositoryImpl(user : User) : TaskRepository {
    private val tasks : MutableList<Task> = user.tasks
    override fun getTasks() = tasks.toList()

    override fun updateTask(task: Task, newtitle: String, newdesc: String, newdate: LocalDate) {
        val updatedTask = task.copy(title = newtitle, description = newdesc, dueDate = newdate)
        tasks.removeIf { it == task }
        tasks.add(updatedTask)
    }

    override fun addTask(task: Task) {
        tasks.add(task)
    }

    override fun deleteTask(task: Task) {
        tasks.removeIf{tasks.contains(task)}
    }

    override fun completeTask(task: Task) {
        val completedTask = task.copy(isCompleted = true)
        tasks.removeIf { it == task }
        tasks.add(completedTask)
    }
}