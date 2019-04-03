package pl.org.seva.myapplication.strategy

import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

class Italic : Emphasis {
    override fun emphasis(str: String, placeholder: String, replacement: String): CharSequence {
        val idName = str.indexOf(placeholder)
        val idEndName = idName + replacement.length
        val boldSpan = StyleSpan(Typeface.ITALIC)
        return SpannableStringBuilder(str.replace(placeholder, replacement)).apply {
            setSpan(boldSpan, idName, idEndName, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        }
    }

    companion object {
        private const val MODULE_LABEL = "italic"
        val MODULE = Kodein.Module(MODULE_LABEL) {
            try {
                bind<Emphasis>() with singleton { Italic() }
            }
            catch (ex: Kodein.OverridingException) {
                bind<Emphasis>(overrides = true) with singleton { Italic() }
            }
        }
    }
}
