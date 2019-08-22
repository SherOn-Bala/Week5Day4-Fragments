package ca.judacribz.week5day4_fragments.view.activities

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import ca.judacribz.week5day4_fragments.R
import ca.judacribz.week5day4_fragments.async.GetCelebInfoTask
import ca.judacribz.week5day4_fragments.model.Celebrity
import ca.judacribz.week5day4_fragments.view.adapters.CelebrityAdapter
import ca.judacribz.week5day4_fragments.view.fragments.CelebrityListFragment
import kotlinx.android.synthetic.main.fragment_celebrity_list.*

class MainActivity : AppCompatActivity(), GetCelebInfoTask.CelebInfoListener,
    CelebrityListFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    val celebList: ArrayList<Celebrity> = ArrayList()
    lateinit var manager : FragmentManager
    val list: CelebrityListFragment = CelebrityListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = supportFragmentManager


        addCeleb("Dwayne", "Johnson")
        addCeleb("Dwayne", "Johnson")
        addCeleb("Dwayne", "Johnson")
        addCeleb("Dwayne", "Johnson")
        addCeleb("Dwayne", "Johnson")
        addCeleb("Dwayne", "Johnson")
        addCeleb("Dwayne", "Johnson")
    }

    private fun addCeleb(firstName: String, lastName: String) {
        GetCelebInfoTask(this).execute(firstName, lastName)
    }

    override fun onInfoDownloaded(celebrity: Celebrity) {
        celebList.add(celebrity)

        val bundle = Bundle()
        bundle.putParcelableArrayList("key", celebList)
        list.arguments = bundle

        manager.popBackStack()
        val transaction = manager.beginTransaction()
        transaction.add(R.id.flList, list, "TAG")
        transaction.commit()

    }

}
