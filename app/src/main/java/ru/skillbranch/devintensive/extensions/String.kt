package ru.skillbranch.devintensive.extensions

fun String.stripHtml(): String {
    val escape = "&[^;]+;".toRegex()
    val space = " {2,}".toRegex()
    val tag = "<[^>]+>".toRegex()
    return this.replace(escape, "").replace(space, " ").replace(tag, "")
}

fun String.truncate(num: Int = 16): String {
    if (num >= this.length - 1)
        return this
    return when (this[num]) {
        ' ' -> "${this.substring(0 until num)}..."
        else -> "${this.substring(0..num)}..."
    }
}