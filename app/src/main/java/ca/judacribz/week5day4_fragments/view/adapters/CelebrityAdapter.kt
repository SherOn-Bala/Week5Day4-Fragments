package ca.judacribz.week5day4_fragments.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ca.judacribz.week5day4_fragments.R
import ca.judacribz.week5day4_fragments.model.Celebrity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_celebrity.view.*

class CelebrityAdapter(val clickListener: (Celebrity) -> Unit) :
    RecyclerView.Adapter<CelebrityAdapter.ViewHolder>() {

    public val celebrityList: ArrayList<Celebrity> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_celebrity,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = celebrityList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bindValues(celebrityList[position], clickListener)

    fun addCelebrity(celebrity: Celebrity) {
        celebrityList.add(celebrity)
        notifyItemInserted(itemCount)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bindValues(celebrity: Celebrity, clickListener: (Celebrity) -> Unit) {
            Glide.with(itemView.context).load(celebrity.pictureUrl).into(itemView.ivProfilePic)
            itemView.tvFirstName.text = celebrity.firstName
            itemView.tvLastName.text = celebrity.lastName
            itemView.setOnClickListener{clickListener(celebrity)}
        }

    }
}