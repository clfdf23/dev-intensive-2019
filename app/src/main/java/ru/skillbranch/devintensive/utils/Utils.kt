package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        //TODO FIX NULL OUTPUT
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)
        return firstName to lastName
    }

    fun transliterations(payload: String, divider: String = " "): String {
        var output: String = ""
        for (char in payload) {
            output+=when(char) {
                'а', 'А' -> {if (char == 'а') "a" else "A"}
                'б', 'Б' -> {if (char == 'б') "b" else "B"}
                'в', 'В' -> {if (char == 'в') "v" else "V"}
                'г', 'Г' -> {if (char == 'г') "g" else "G"}
                'д', 'Д' -> {if (char == 'д') "d" else "D"}
                'е', 'Е', 'Ё', 'ё', 'Э', 'э' -> {if (char == 'е' || char == 'ё' || char == 'э') "e" else "E"}
                'ж', 'Ж' -> {if (char == 'ж') "zh" else "Zh"}
                'з', 'З' -> {if (char == 'з') "z" else "Z"}
                'и', 'И', 'й', 'Й', 'ы' -> {if (char == 'й' || char == 'и' || char == 'ы') "i" else "I"}
                'к', 'К' -> {if (char == 'к') "k" else "K"}
                'л', 'Л' -> {if (char == 'л') "l" else "L"}
                'м', 'М' -> {if (char == 'м') "m" else "M"}
                'н', 'Н' -> {if (char == 'н') "n" else "N"}
                'о', 'О' -> {if (char == 'о') "o" else "O"}
                'п', 'П' -> {if (char == 'п') "p" else "P"}
                'р', 'Р' -> {if (char == 'р') "r" else "R"}
                'с', 'С' -> {if (char == 'с') "s" else "S"}
                'т', 'Т' -> {if (char == 'т') "t" else "T"}
                'у', 'У' -> {if (char == 'у') "u" else "U"}
                'ф', 'Ф' -> {if (char == 'ф') "f" else "F"}
                'х', 'Х' -> {if (char == 'х') "h" else "H"}
                'ц', 'Ц' -> {if (char == 'ц') "c" else "C"}
                'ч', 'Ч' ->  {if (char == 'ч') "ch" else "Ch"}
                'ш', 'Ш', 'Щ', 'щ' -> {if (char == 'ш' || char == 'щ') "sh" else "Sh"}
                'ъ', 'ь' -> ""
                'ю', 'Ю' -> {if (char == 'ю') "yu" else "Yu"}
                'я', 'Я' -> {if (char == 'я') "ya" else "Ya"}
                ' ' -> divider
                else -> char.toString()
            }
        }
        return output
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}