import java.time.LocalDate

class TaskRepositoryImpl(user : User) : TaskRepository {
    private val tasks : MutableList<Task> = user.tasks
    override fun getTasks() = tasks.toList()

    override fun updateTask(task: Task, newTitle: String, newDesc: String, newDate: LocalDate) {
        val updatedTask = task.copy(title = newTitle, description = newDesc, dueDate = newDate)
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