package ru.skillbranch.devintensive.models

import android.util.Log


class Bender(var status: Status = Status.NORMAL, var question: Question = Question.NAME) {

    fun askQuestion(): String = when (question) {
        Question.NAME -> Question.NAME.question
        Question.PROFESSION -> Question.PROFESSION.question
        Question.MATERIAL -> Question.MATERIAL.question
        Question.BDAY -> Question.BDAY.question
        Question.SERIAL -> Question.SERIAL.question
        Question.IDLE -> Question.IDLE.question
    }

    fun listenAnswer(answer: String): Pair<String, Triple<Int, Int, Int>> {
        return if (answer.isByFormat()) {
            if (question.answers.contains(answer.toLowerCase())) {
                question = question.nextQuestion()
                "Отлично - ты справился\n${question.question}" to status.color
            } else {
                status = status.nextStatus()
                "Это не правильный ответ\n${question.question}" to status.color
            }
        } else {
            question.formatError() to status.color
        }
    }

    private fun String.isByFormat(): Boolean {
        return when (question) {
            Question.NAME -> this.contains(question.format)
            Question.PROFESSION -> this.contains(question.format)
            Question.MATERIAL -> !this.contains(question.format)
            Question.BDAY -> !this.contains(question.format)
            Question.SERIAL -> this.matches(question.format)
            Question.IDLE -> false
        }
    }

    enum class Status(val color: Triple<Int, Int, Int>) {
        NORMAL(Triple(255, 255, 255)),
        WARNING(Triple(255, 120, 0)),
        DANGER(Triple(255, 60, 60)),
        CRITICAL(Triple(255, 255, 0));

        fun nextStatus(): Status {
            return if (this.ordinal < values().lastIndex) {
                values()[this.ordinal + 1]
            } else {
                values().last()
            }
        }
    }

    enum class Question(val question: String, val answers: List<String>, val format: Regex, val formatAnswer: String) {
        NAME(
            "Как меня зовут?",
            listOf("бендер", "bender"),
            "^[A-Z]".toRegex(),
            "Имя должно начинаться с заглавной буквы"
        ) {
            override fun nextQuestion(): Question = PROFESSION
            override fun formatError(): String = "${this.formatAnswer}\n${this.question}"
        },
        PROFESSION(
            "Назови мою профессию?",
            listOf("сгибальщик", "bender"),
            "^[a-z]".toRegex(),
            "Профессия должна начинаться со строчной буквы"
        ) {
            override fun nextQuestion(): Question = MATERIAL
            override fun formatError(): String = "${this.formatAnswer}\n${this.question}"
        },
        MATERIAL(
            "Из чего я сделан?",
            listOf("metal", "wood", "iron", "дерево", "металл"),
            "\\d+".toRegex(),
            "Материал не должен содержать цифр"
        ) {
            override fun nextQuestion(): Question = BDAY
            override fun formatError(): String = "${this.formatAnswer}\n${this.question}"
        },
        BDAY(
            "Когда меня создали?",
            listOf("2993"),
            "\\D+".toRegex(),
            "Год моего рождения должен содержать только цифры"
        ) {
            override fun nextQuestion(): Question = SERIAL
            override fun formatError(): String = "${this.formatAnswer}\n${this.question}"
        },
        SERIAL(
            "Мой серийный номер?",
            listOf("2716057"),
            "^\\d\\d{5}\\d\$".toRegex(),
            "Серийный номер содержит только цифры, и их 7"
        ) {
            override fun nextQuestion(): Question = IDLE
            override fun formatError(): String = "${this.formatAnswer}\n${this.question}"
        },
        IDLE(
            "На этом все, вопросов больше нет",
            listOf(),
            ".*".toRegex(),
            ""
        ) {
            override fun nextQuestion(): Question = IDLE
            override fun formatError(): String = this.question
        };

        abstract fun nextQuestion(): Question
        abstract fun formatError(): String
    }
}