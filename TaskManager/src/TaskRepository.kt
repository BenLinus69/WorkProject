import java.time.LocalDate
import javax.management.Descriptor

interface TaskRepository {
    fun getTasks() : List<Task>
    fun updateTask(task: Task, newTitle: String = task.getTitle(), newDescriptor: String = task.getDescription(), newDate: LocalDate = task.getDate(), newIsCompleted: Boolean = task.getIsCompleted())
    fun addTask(task: Task)
    fun deleteTask(task: Task)
}