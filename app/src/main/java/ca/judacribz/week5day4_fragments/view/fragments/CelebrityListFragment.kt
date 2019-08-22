package ca.judacribz.week5day4_fragments.view.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import ca.judacribz.week5day4_fragments.R
import ca.judacribz.week5day4_fragments.model.Celebrity
import ca.judacribz.week5day4_fragments.view.adapters.CelebrityAdapter
import kotlinx.android.synthetic.main.fragment_celebrity_list.*
import kotlinx.android.synthetic.main.fragment_celebrity_list.view.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [CelebrityListFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */
class CelebrityListFragment : Fragment() {
    private var listener: OnFragmentInteractionListener? = null

    var celebList : ArrayList<Celebrity> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val parcelableArrayList = arguments?.getParcelableArrayList<Celebrity>("key")
        if (parcelableArrayList!= null) {
            celebList = parcelableArrayList
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_celebrity_list, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (celebList.size > 0)
            view.rvList.layoutManager = LinearLayoutManager(activity)
            view.rvList.adapter = CelebrityAdapter(celebList)
    }

    // TODO: Rename method, update argument and hook method into UI event
    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

}
