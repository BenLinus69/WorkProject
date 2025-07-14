class userManager {
    var users: MutableList<User> = mutableListOf()

    fun addUser (user: User) {
        users.add(user)
    }

    fun getList () : List<User> = users.toList()
}