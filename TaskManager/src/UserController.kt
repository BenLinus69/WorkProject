import java.time.LocalDate
import java.time.format.DateTimeFormatter

class UserController (val userManager: UserManager) {
    val dateformater = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    fun start() {
        println("Welcome! Type 1 or 2: ")
        println("1. Login\n2. Exit")
        while(true) {
            when (readLine()) {
                "1" -> login()
                "2" -> return
                else -> {
                    println("Invalid option. Please try again.")
                }
            }
        }
    }

    private fun login() {
        println("Enter your name: ")
        val name = readln()
        val user = userManager.getUsers().find { it.name == name } ?: run {
            println("Name not found, creating new user.")
            userManager.addUser(name)
            userManager.getUsers().find { it.name == name }!!
        }
        println("Welcome ${user.name}!")
        val repository = TaskRepositoryImpl(user)
        usermenu(repository)
    }

    fun usermenu(repository : TaskRepositoryImpl) {
        while (true) {
            println("Choose an option: ")
            println("1. Add new task \n2. Manage tasks\n3. List all tasks\n4. Exit")
            when (readLine()) {
                "1" -> addTask(repository)
                "2" -> manageTasks(repository)
                "3" -> {
                    println(repository.getTasks().ifEmpty { "No tasks available" })
                }
                "4" -> {println("1. Login\n2. Exit")
                    return}
                else -> {
                    println("Invalid option. Please try again.")
                }
            }
        }
    }

    private fun addTask(repository : TaskRepository) {
        println("Enter task title:")
        val title = readln()
        println("Enter task description:")
        val description = readln()
        println("Enter task due date: (DD-MM-YYYY):")
        val dueDate = LocalDate.parse((readln()), dateformater)
        repository.addTask(Task(title,description,dueDate))
        println("Task added successfully!")
    }

    private fun manageTasks(repository : TaskRepositoryImpl) {
        if (repository.getTasks().isEmpty()) {
            println("You currently have no tasks!")
            return
        }

        println("Here are your tasks: ")
        val tasks = repository.getTasks()
        tasks.forEachIndexed() { index, task ->
            println("${index + 1}.  $task")
        }
        println("Type the number of the task you want to manage! Or type 'exit' to go back to the menu.")
        while (true){
            val readln = readln()
            if (readln.lowercase() == "exit") {
                return
            }
            if (readln.toIntOrNull() == null) {
                println("Please enter a valid number!")
                continue
            }
            val index = readln.toInt()
            if (index < 1 || index > repository.getTasks().size) {
                println("invalid task number try again.")
                continue
            }
            modifytask(repository, index)

        }
    }

    private fun modifytask(repository : TaskRepositoryImpl, index: Int) {
        while (true){
            println("Managing task:")
            println(repository.getTasks()[index - 1])
            println("1. Update task \n2. Delete task \n3. Complete task\n4. Exit")
            when (readln()) {
                "1" -> {
                    val task = repository.getTasks()[index - 1]
                    println("Empty fields won't change")
                    println("Enter task title:")
                    val titleInput = readln()
                    val title = if (titleInput.isBlank()) task.title else titleInput
                    println("Enter task description:")
                    val descriptionInput = readln()
                    val description = if (descriptionInput.isBlank()) task.description else descriptionInput
                    println("Enter task due date: (DD-MM-YYYY):")
                    val dueDateInput = readln()
                    val dueDate =
                        if (dueDateInput.isBlank()) task.dueDate else LocalDate.parse(dueDateInput, dateformater)
                    repository.updateTask(task, title, description, dueDate)
                    println("Task updated successfully!")


                }

                "2" -> {
                    repository.deleteTask(repository.getTasks()[index - 1])
                    println("Task deleted successfully!")

                }

                "3" -> {
                    repository.completeTask(repository.getTasks()[index - 1])
                    println("Task completed successfully!")

                }

                "4" -> {
                    println("Exiting task management.")
                }

                else -> println("Invalid option. Please try again.")
            }
            println("Here are your tasks: ")
            val tasks = repository.getTasks()
            tasks.forEachIndexed() { index, task ->
                println("${index + 1}.  $task")
            }
            println("Type the number of the task you want to manage! Or type 'exit' to go back to the menu.")
            return
        }

    }

}