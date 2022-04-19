package cl.uandes.catloversapp.model

class Users {
  companion object {
    fun createUserList(): MutableList<User> {
      val users = ArrayList<User>()
      users.add(User("user1@email.com", "123456"))
      users.add(User("user2@email.com", "123456"))

      return users.toMutableList()
    }
  }
}
