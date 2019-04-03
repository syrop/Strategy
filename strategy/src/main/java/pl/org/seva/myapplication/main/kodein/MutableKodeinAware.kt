package pl.org.seva.myapplication.main.kodein

import org.kodein.di.KodeinAware
import org.kodein.di.conf.ConfigurableKodein

private val mutableKodein = ConfigurableKodein(true)

interface MutableKodeinAware : KodeinAware {

    override val kodein get() = mutableKodein
}
