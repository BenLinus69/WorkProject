import java.time.LocalDate
import java.util.Scanner
import java.time.format.DateTimeFormatter

fun main() {
    val scanner = Scanner(System.`in`)
    val manager = UserManager()
    val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")

    println("\nTask Manager Menu:")
    println("1. Add User")
    println("2. Add Task")
    println("3. List User Tasks")
    println("4. Update Task")
    println("5. Delete Task")
    println("6. List Users")
    println("7. Exit")
    println("=====================================")

    while (true) {
        print("Choose an option: ")


        when (scanner.nextLine().toIntOrNull()) {
            1 -> {
                print("Enter username: ")
                val username = scanner.nextLine()
                manager.addUser(username)
                println("User '$username' added.")
            }
            2 -> {
                print("Enter username: ")
                val username = scanner.nextLine()
                val user = manager.getUsers().find { it.getName() == username }
                if (user != null) {
                    val repo = TaskRepositoryImpl(user)
                    print("Enter task title: ")
                    val title = scanner.nextLine()
                    print("Enter task description: ")
                    val description = scanner.nextLine()
                    print("Enter due date (dd-MM-yyyy): ")
                    val dueDate = LocalDate.parse(scanner.nextLine(), dateFormatter)
                    print("Is the task completed? (true/false): ")
                    val isCompleted = scanner.nextLine().toBoolean()
                    val task = Task(title, description, dueDate, isCompleted)
                    repo.addTask(task)
                    println("Task added for user '$username'.")
                } else {
                    println("User not found.")
                }
            }
            3 -> {
                print("Enter username: ")
                val username = scanner.nextLine()
                val user = manager.getUsers().find { it.getName() == username }
                if (user != null) {
                    println("Tasks for user '$username':")
                    println(manager.listUserTasks(user))
                } else {
                    println("User not found.")
                }
            }
            4 -> {
                print("Enter username: ")
                val username = scanner.nextLine()
                val user = manager.getUsers().find { it.getName() == username }
                if (user != null) {
                    val repo = TaskRepositoryImpl(user)
                    println("Tasks for user '$username':")
                    val tasks = repo.getTasks()
                    tasks.forEachIndexed { index, task -> println("$index: $task") }
                    print("Enter task index to update: ")
                    val index = scanner.nextLine().toIntOrNull()
                    if (index != null && index in tasks.indices) {
                        val task = tasks[index]
                        print("Enter new title (leave blank to keep '${task.getTitle()}'): ")
                        val newTitle = scanner.nextLine().ifBlank { task.getTitle() }
                        print("Enter new description (leave blank to keep '${task.getDescription()}'): ")
                        val newDescription = scanner.nextLine().ifBlank { task.getDescription() }
                        print("Enter new due date (dd-MM-yyyy, leave blank to keep '${task.getDate()}'): ")
                        val newDate = scanner.nextLine().ifBlank { task.getDate().toString() }
                        print("Is the task completed? (true/false, leave blank to keep '${task.getIsCompleted()}'): ")
                        val newIsCompleted = scanner.nextLine().ifBlank { task.getIsCompleted().toString() }
                        repo.updateTask(
                            task,
                            newTitle,
                            newDescription,
                            LocalDate.parse(newDate, dateFormatter),
                            newIsCompleted.toBoolean()
                        )
                        println("Task updated.")
                    } else {
                        println("Invalid task index.")
                    }
                } else {
                    println("User not found.")
                }
            }
            5 -> {
                print("Enter username: ")
                val username = scanner.nextLine()
                val user = manager.getUsers().find { it.getName() == username }
                if (user != null) {
                    val repo = TaskRepositoryImpl(user)
                    println("Tasks for user '$username':")
                    val tasks = repo.getTasks()
                    tasks.forEachIndexed { index, task -> println("$index: $task") }
                    print("Enter task index to delete: ")
                    val index = scanner.nextLine().toIntOrNull()
                    if (index != null && index in tasks.indices) {
                        val task = tasks[index]
                        repo.deleteTask(task)
                        println("Task deleted.")
                    } else {
                        println("Invalid task index.")
                    }
                } else {
                    println("User not found.")
                }
            }
            6 -> {
                println("Registered users:")
                manager.getUsers().forEach { println(it.getName()) }
            }
            7 -> {
                println("Exiting Task Manager. Goodbye!")
                break
            }
            else -> println("Invalid option. Please try again.")
        }
    }
}
