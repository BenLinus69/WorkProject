import java.time.LocalDate

class TaskRepositoryImpl(user : User) : TaskRepository {
    private val tasks: MutableList<Task> = user.getTasks()
    override fun getTasks() = tasks.toList()

    override fun updateTask(task: Task, newTitle: String, newDescriptor: String, newDate: LocalDate, newIsCompleted: Boolean) {
        val index = tasks.indexOf(task)
        if (index != -1) {
            tasks[index] = task.copy(title = newTitle, description = newDescriptor, dueDate = newDate, isCompleted = newIsCompleted)
        }
    }

    override fun addTask(task: Task) {
        tasks.add(task)
    }

    override fun deleteTask(task: Task) {
        tasks.remove(task)
    }
}