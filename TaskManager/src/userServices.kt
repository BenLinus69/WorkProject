interface userServices {
    fun addNewUser(name: String, tasks: MutableList<Task> = mutableListOf())
    fun listAllTasks(user: User)
}