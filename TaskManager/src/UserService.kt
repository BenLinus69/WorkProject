interface UserService {
    fun addUser(name: String, tasks: MutableList<Task> = mutableListOf())
    fun listUserTasks(user: User) : MutableList<Task>
}