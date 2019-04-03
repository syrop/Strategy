package pl.org.seva.myapplication.strategy

import org.kodein.di.generic.instance
import pl.org.seva.myapplication.main.kodein.MutableKodeinAware

interface Emphasis {
    fun emphasis(str: String, placeholder: String, replacement: String): CharSequence

    companion object : MutableKodeinAware {
        val instance get() = kodein.instance<Emphasis>()
    }
}
