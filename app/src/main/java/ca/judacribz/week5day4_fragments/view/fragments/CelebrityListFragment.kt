package ca.judacribz.week5day4_fragments.view.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import ca.judacribz.week5day4_fragments.R
import ca.judacribz.week5day4_fragments.model.Celebrity
import ca.judacribz.week5day4_fragments.view.adapters.CelebrityAdapter
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_celebrity_list.view.*

class CelebrityListFragment : Fragment() {

    private var adapter: CelebrityAdapter? = null

    // Interface to pass Celebrity data back to MainActivity
    private var listener: CelebrityClickedListener? = null

    interface CelebrityClickedListener {
        fun onCelebrityClicked(celebrity: Celebrity)
    }

    //=Fragment Override===========================================================================
    // Interface Listener context set to MainActivity context
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is CelebrityClickedListener) {
            listener = context
        }

        // Setting the click listener of celebrity
        adapter = CelebrityAdapter { celebrity: Celebrity -> onCelebrityClicked(celebrity) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_celebrity_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.rvList.layoutManager = LinearLayoutManager(activity)
        view.rvList.adapter = adapter
    }
    //=END=Fragment Override=======================================================================


    //  Helper function to add Celebrity data to the adapter
    fun addCelebrity(celebrity: Celebrity) {
        adapter?.addCelebrity(celebrity)
    }

    // Calls the interface method connected to MainActivity to send data back when an item is
    // clicked on the Celebrity adapter list.
    private fun onCelebrityClicked(celebrity: Celebrity) {
        listener?.onCelebrityClicked(celebrity)
    }
}
