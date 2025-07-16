import java.time.LocalDate

class TaskRepositoryImpl(user : User) : TaskRepository {
    private val tasks : MutableList<Task> = user.tasks
    override fun getTasks() = tasks.toList()

    override fun updateTask(task: Task, newtitle: String, newdesc: String, newdate: LocalDate) {
        val updatedTask = task.copy(title = newtitle, description = newdesc, dueDate = newdate)
        tasks.remove(task)
        tasks.add(updatedTask)
    }

    override fun addTask(task: Task) : Boolean {
        return tasks.add(task)
    }

    override fun deleteTask(task: Task) : Boolean {
        return tasks.remove(task)
    }

    override fun completeTask(task: Task) {
        val completedTask = task.copy(isCompleted = true)
        tasks.remove(task)
        tasks.add(completedTask)
    }
}