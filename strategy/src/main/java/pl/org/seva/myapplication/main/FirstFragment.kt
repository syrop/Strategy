package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fr_first.*
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.emphasis
import pl.org.seva.myapplication.main.extension.inflate
import pl.org.seva.myapplication.main.extension.nav
import pl.org.seva.myapplication.main.kodein.MutableKodeinAware
import pl.org.seva.myapplication.strategy.Bold

class FirstFragment : Fragment(), MutableKodeinAware {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflate(R.layout.fr_first, container)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        kodein.addImport(Bold.MODULE, true)
        text.text = getString(R.string.first_fragment_prompt)
                .emphasis(PLACEHOLDER, getString(R.string.first_fragment_replacement))
        next_fab.setOnClickListener { nav(R.id.action_firstFragment_to_secondFragment) }
    }

    companion object {
        const val PLACEHOLDER = "[emphasis]"
    }
}
