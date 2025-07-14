class UserManager : UserService {
    private val users : MutableList<User> = mutableListOf()

    override fun addUser(name: String, tasks: MutableList<Task>){
        users.add(User(name, tasks))
    }

    override fun listUserTasks(user: User): MutableList<Task> {
        return user.getTasks()
    }

    fun getUsers() = users

}