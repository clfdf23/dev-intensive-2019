package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.*
import ru.skillbranch.devintensive.models.BaseMessage
import ru.skillbranch.devintensive.models.Chat
import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

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
        val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type="text", date = Date().add(-20, TimeUnits.MINUTE))
        val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type="image")

        println(txtMessage.formatMessage())
        println(imgMessage.formatMessage())
    }
    @Test
    fun test_transliteration() {
        println(Utils.transliteration("Вячеслав Рузанов", "_"))
    }

    @Test
    fun test_dateHumanization() {
        val user = User.makeUser("John Wick")
        val user2 = user.copy(lastVisit = Date().add(465, TimeUnits.DAY))
        user2.toUserView().printMe()
        println(user2)
    }

    @Test
    fun test_toInitials() {
        println(Utils.toInitials("ывапф", "аузанов"))
    }

    @Test
    fun test_parseFullName() {
        println(Utils.parseFullName("Jonh"))
    }

    @Test
    fun test_dateFormat() {
        println(Date().format("HH:mm"))
    }
    @Test
    fun temp() {
        val x = 1
        when (x) {
            in 0..1 -> println(1)
            in 1..2 -> println(2)
        }
    }
    @Test
    fun test_builder() {
        var user = User.Builder().id("324234")
            .firstName("Вячеслав")
            .lastName("Пузанов")
            .avatar("url")
            .rating(10)
            .lastVisit(Date().add(-30))
            .build()
        user.toUserView().printMe()
    }
    @Test
    fun test_stripHtml() {
        println("${"<p class=\"title\">  Образовательное                IT-сообщество Skill   Branch     </p>".stripHtml()}@")
    }

    @Test
    fun test_plural() {
        println(TimeUnits.DAY.plural(436723424))
    }

    @Test
    fun test_truncate() {
        assertEquals("Bender Bending R...", "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate())
        assertEquals("Bender Bending...", "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15))
        assertEquals("A", "A     ".truncate(3))

        /* additional tests */
        assertEquals("too lo...", "   too long line with lots of spaces before".truncate(6))
        assertEquals("too short", "too short".truncate(20))
        assertEquals("12345", "12345".truncate(5))
        assertEquals("1234...", "12345".truncate(4))
        assertEquals("12345", "12345  ".truncate(5))
        assertEquals("tab", "tab    ".truncate(5))
        assertEquals("dots......", "dots... a lot".truncate(7))
        assertEquals("abc", "abc    ".truncate(15))
        assertEquals("123456...", "123456789".truncate(6))
        assertEquals("123456789", "123456789".truncate(9))
        assertEquals("Bender Bending R...", "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate())
        assertEquals("Bender Bending...", "Bender Bending Rodriguez — дословно «Сгибальщик Сгибающий Родригес»".truncate(15))
        assertEquals("1", "1     ".truncate(3))
    }
}
