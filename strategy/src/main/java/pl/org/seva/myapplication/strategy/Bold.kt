/*
 * Copyright (C) 2019 Wiktor Nizio
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * If you like this program, consider donating bitcoin: bc1qncxh5xs6erq6w4qz3a7xl7f50agrgn3w58dsfp
 */

package pl.org.seva.myapplication.strategy

import android.graphics.Typeface
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton


class Bold : Emphasis {
    override fun emphasis(str: String, placeholder: String, replacement: String): CharSequence {
        val idName = str.indexOf(placeholder)
        val idEndName = idName + replacement.length
        val boldSpan = StyleSpan(Typeface.BOLD)
        return SpannableStringBuilder(str.replace(placeholder, replacement)).apply {
            setSpan(boldSpan, idName, idEndName, Spanned.SPAN_INCLUSIVE_EXCLUSIVE)
        }
    }

    companion object {
        private const val MODULE_LABEL = "bold"
        val MODULE = Kodein.Module(MODULE_LABEL) {
            try {
                bind<Emphasis>() with singleton { Bold() }
            }
            catch (ex: Kodein.OverridingException) {
                bind<Emphasis>(overrides = true) with singleton { Bold() }
            }
        }
    }
}
