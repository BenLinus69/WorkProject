import java.util.*

fun main() {
    var manager = UserManager()
    manager.addUser("Andrei")
    manager.addUser("Georgel")
    var task1 = Task("random1", "desc1", Date(), true)
    var task2 = Task("random1", "desc2", Date(), true)
    var task3 = Task("random3", "desc3", Date(), true)
    var task4 = Task("random4", "desc4", Date(), true)
    for(user in manager.getUsers()){
        val repo = TaskRepositoryImpl(user)
        repo.addTask(task1)
        repo.addTask(task2)
        println("User's tasks:")
        println(manager.listUserTasks(user))
        repo.updateTask(task2, "updated bai")
        println("User's tasks: \n" + manager.listUserTasks(user))
    }
}