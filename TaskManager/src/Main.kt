fun main() {
    val manager = UserManager()
    val controller = UserController(manager)
    controller.start()
}