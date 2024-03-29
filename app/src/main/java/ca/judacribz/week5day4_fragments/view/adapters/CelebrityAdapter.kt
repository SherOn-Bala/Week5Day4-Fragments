package ca.judacribz.week5day4_fragments.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.judacribz.week5day4_fragments.R
import ca.judacribz.week5day4_fragments.model.Celebrity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_celebrity.view.*

class CelebrityAdapter(private val clickListener: (Celebrity) -> Unit) :
    RecyclerView.Adapter<CelebrityAdapter.CelebViewHolder>() {

    private val celebrityList: ArrayList<Celebrity> = ArrayList()

    //=RecyclerView.Adapter Override===============================================================
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CelebViewHolder =
        CelebViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_celebrity,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = celebrityList.size

    override fun onBindViewHolder(holder: CelebViewHolder, position: Int) =
        holder.bindValues(celebrityList[position], clickListener)
    //=END=RecyclerView.Adapter Override===========================================================


    // Function to add Celebrity data to the adapter list
    fun addCelebrity(celebrity: Celebrity) {
        celebrityList.add(celebrity)
        notifyItemInserted(itemCount)
    }


    // Custom Celebrity ViewHolder
    class CelebViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindValues(celebrity: Celebrity, clickListener: (Celebrity) -> Unit) {
            Glide.with(itemView.context).load(celebrity.pictureUrl).into(itemView.ivProfilePic)

            itemView.tvFirstName.text = celebrity.firstName
            itemView.tvLastName.text = celebrity.lastName

            // Using lambda function to set clickListener interface
            itemView.setOnClickListener { clickListener(celebrity) }
        }
    }
}