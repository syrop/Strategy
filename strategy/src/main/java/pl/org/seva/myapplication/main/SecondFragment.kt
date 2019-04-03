package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fr_second.*
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.emphasis
import pl.org.seva.myapplication.main.extension.inflate
import pl.org.seva.myapplication.main.kodein.MutableKodeinAware
import pl.org.seva.myapplication.strategy.Italic

class SecondFragment : Fragment(), MutableKodeinAware {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflate(R.layout.fr_second, container)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        kodein.addImport(Italic.MODULE, true)
        text.text = getString(R.string.second_fragment_prompt)
                .emphasis(PLACEHOLDER, getString(R.string.second_fragment_replacement))
    }

    companion object {
        const val PLACEHOLDER = "[emphasis]"
    }
}
