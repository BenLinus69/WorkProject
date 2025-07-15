import java.time.LocalDate

fun main() {
    var manager = UserManager()
    while(true){
        println("Welcome! Type 1 or 2: ")
        println("1. Login: \n2. Exit")
        when(readln()){
            "1" -> {
                println("Please enter your name: ")
                val inputName = readln()
                while(true) {
                    when {
                        manager.getUsers().find { it.getName() == inputName } != null -> {
                            val user = manager.getUsers().find { it.getName() == inputName }!!
                            println("Welcome back, ${user.getName()}!")
                            val repo = TaskRepositoryImpl(user)
                            println("Type 1, 2 or 3:")
                            println("1. Add new task \n2. Manage tasks\n3. Exit")
                            when (readln()) {
                                "1" -> {
                                    println("Please enter the task title: ")
                                    val title = readln()
                                    println("Please enter the task description: ")
                                    val description = readln()
                                    println("Please enter the due date (YYYY-MM-DD): ")
                                    val dueDate = LocalDate.parse(readln())
                                    repo.addTask(Task(title, description, dueDate, false))
                                    println("Task added successfully!")
                                }

                                "2" -> {
                                    println("Here are your tasks:")
                                    repo.getTasks().sortedBy { it.getComp() }.forEach { task ->
                                        println("Title: ${task.getTitle()}, Description: ${task.getDesc()}, Due Date: ${task.getDate()}, Completed: ${task.getComp()}")
                                    }
                                    println("Type the title of the task you want to manage or type 'exit' to go back:")
                                    when (val input = readln()) {
                                        "exit" -> continue
                                        else -> {
                                            val task = repo.getTasks().find { it.getTitle() == input }
                                            if (task != null) {
                                                println("Managing task: ${task.getTitle()}")
                                                println("1. Update task \n2. Delete task \n3. Complete task")
                                                when (readln()) {
                                                    "1" -> {
                                                        println("Enter new title: ")
                                                        val newTitle = readln()
                                                        println("Enter new description: ")
                                                        val newDesc = readln()
                                                        println("Enter new due date (YYYY-MM-DD): ")
                                                        val newDate = LocalDate.parse(readln())
                                                        repo.updateTask(
                                                            task,
                                                            newTitle,
                                                            newDesc,
                                                            newDate,
                                                            task.getComp()
                                                        )
                                                        println("Task updated successfully!")
                                                    }

                                                    "2" -> {
                                                        repo.deleteTask(task)
                                                        println("Task deleted successfully!")
                                                    }

                                                    "3" -> {
                                                        repo.completeTask(task)
                                                        println("Task marked as completed!")
                                                    }

                                                    else -> println("Invalid option.")
                                                }
                                            } else {
                                                println("Task not found.")
                                            }
                                        }
                                    }
                                }

                                "3" -> break
                                else -> {
                                    println("Wrong number, please try again.")
                                }
                            }
                        }

                        else -> {
                            println("User not found, creating a new user...")
                            println("Please enter your name: ")
                            val name = readln()
                            manager.addUser(name)
                            println("User $name created successfully!")
                            val user = manager.getUsers().find { it.getName() == name }!!
                            val repo = TaskRepositoryImpl(user)
                            println("Type 1, 2 or 3:")
                            println("1. Add new task \n2. Manage tasks\n3. Exit")
                            when (readln()) {
                                "1" -> {
                                    println("Please enter the task title: ")
                                    val title = readln()
                                    println("Please enter the task description: ")
                                    val description = readln()
                                    println("Please enter the due date (YYYY-MM-DD): ")
                                    val dueDate = LocalDate.parse(readln())
                                    repo.addTask(Task(title, description, dueDate, false))
                                    println("Task added successfully!")
                                }

                                "2" -> {
                                    println("Here are your tasks:")
                                    repo.getTasks().forEach { task ->
                                        println("Title: ${task.getTitle()}, Description: ${task.getDesc()}, Due Date: ${task.getDate()}, Completed: ${task.getComp()}")
                                    }
                                    println("Type the title of the task you want to manage or type 'exit' to go back:")
                                    when (val input = readln()) {
                                        "exit" -> continue
                                        else -> {
                                            val task = repo.getTasks().find { it.getTitle() == input }
                                            if (task != null) {
                                                println("Managing task: ${task.getTitle()}")
                                                println("1. Update task \n2. Delete task \n3. Complete task")
                                                when (readln()) {
                                                    "1" -> {
                                                        println("Enter new title: ")
                                                        val newTitle = readln()
                                                        println("Enter new description: ")
                                                        val newDesc = readln()
                                                        println("Enter new due date (YYYY-MM-DD): ")
                                                        val newDate = LocalDate.parse(readln())
                                                        repo.updateTask(
                                                            task,
                                                            newTitle,
                                                            newDesc,
                                                            newDate,
                                                            task.getComp()
                                                        )
                                                        println("Task updated successfully!")
                                                    }

                                                    "2" -> {
                                                        repo.deleteTask(task)
                                                        println("Task deleted successfully!")
                                                    }

                                                    "3" -> {
                                                        repo.completeTask(task)
                                                        println("Task marked as completed!")
                                                    }

                                                    else -> println("Invalid option.")
                                                }
                                            } else {
                                                println("Task not found.")
                                            }
                                        }
                                    }
                                }

                                "3" -> break
                                else -> {
                                    println("Wrong number, please try again.")
                                }
                            }
                        }
                    }
                }
            }
            "2" -> break
            else -> println("Wrong number, please try again.")
        }
    }
}