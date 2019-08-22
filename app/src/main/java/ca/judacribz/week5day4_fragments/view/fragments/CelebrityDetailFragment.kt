package ca.judacribz.week5day4_fragments.view.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ca.judacribz.week5day4_fragments.R

/**
 * A simple [Fragment] subclass.
 */
class CelebrityDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_celebrity_detail, container, false)
    }


}
