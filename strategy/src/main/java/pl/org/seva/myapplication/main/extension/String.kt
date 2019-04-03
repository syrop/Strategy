package pl.org.seva.myapplication.main.extension

import pl.org.seva.myapplication.strategy.Emphasis

fun String.emphasis(placeholder: String, replacement: String): CharSequence {
    val emphasis by Emphasis.instance
    return emphasis.emphasis(this, placeholder, replacement)
}
