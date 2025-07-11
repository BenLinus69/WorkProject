interface taskRepository {
    fun getTaskById(taskId:String): Task?
    fun getAllTask(): List<Task>
    fun addTask(task:Task): Task
    fun updateTask(task:Task): Task?
    fun deleteTask(taskId: String):Boolean
}