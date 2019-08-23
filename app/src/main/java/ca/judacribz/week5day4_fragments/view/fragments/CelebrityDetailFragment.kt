package ca.judacribz.week5day4_fragments.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ca.judacribz.week5day4_fragments.R
import ca.judacribz.week5day4_fragments.model.Celebrity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_celebrity_detail.*

class CelebrityDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_celebrity_detail, container, false)
    }

    fun updateUI(celebrity: Celebrity) {
        Glide.with(this).load(celebrity.pictureUrl).into(ivProfilePic)
        tvName.text = celebrity.getName()
        tvHeight.text = celebrity.getHeightStr()
        tvBirth.text = celebrity.getBirth()

        tvDescription.text = celebrity.description
    }
}
