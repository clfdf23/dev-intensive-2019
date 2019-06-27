package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.utils.Utils

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user = User("1")
        val user2 = User("2")
        val user3 = User("3")

    }
    @Test
    fun test_factory() {
//        val user = User.makeUser("John Cena")
//        val user2 = User.makeUser("John Wick")
        val user3 = User.makeUser("John Wick")
        println(user3)
    }
    @Test
    fun test_messages() {
        val user = User.makeUser("Ruzanov Vyacheslas")
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type="text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type="image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }
    @Test
    fun test_transliteration() {
        println(Utils.transliterations("Вячеслав Рузанов", "_"))
    }
}
