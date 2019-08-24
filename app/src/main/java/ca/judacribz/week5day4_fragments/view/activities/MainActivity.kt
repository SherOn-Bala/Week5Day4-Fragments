package ca.judacribz.week5day4_fragments.view.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import ca.judacribz.week5day4_fragments.R
import ca.judacribz.week5day4_fragments.async.GetCelebDetailsTask
import ca.judacribz.week5day4_fragments.async.GetCelebInfoTask
import ca.judacribz.week5day4_fragments.model.Celebrity
import ca.judacribz.week5day4_fragments.view.fragments.CelebrityDetailFragment
import ca.judacribz.week5day4_fragments.view.fragments.CelebrityListFragment

class MainActivity : AppCompatActivity(),
    GetCelebInfoTask.CelebInfoListener,
    CelebrityListFragment.CelebrityClickedListener,
    GetCelebDetailsTask.CelebDetailsListener {

    private val list: CelebrityListFragment = CelebrityListFragment()
    private val detail: CelebrityDetailFragment = CelebrityDetailFragment()

    var detailSet = false
    lateinit var manager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        manager = supportFragmentManager
        manager
            .beginTransaction()
            .add(R.id.flList, list)
            .commit()

        manager
            .beginTransaction()
            .add(R.id.flDetail, detail)
            .commit()

        addCeleb("Dwayne", "Johnson")
        addCeleb("Steve", "Carell")
        addCeleb("Michael", "Johnson")
        addCeleb("Jessica", "Alba")
        addCeleb("Jackie", "Chan")
        addCeleb("Chris", "Tucker")
    }

    private fun addCeleb(firstName: String, lastName: String) {
        GetCelebInfoTask(this).execute(firstName, lastName)
    }

    //=GetCelebInfoTask.CelebInfoListener Override=================================================
    // When Celebrity basic data is downloaded for celebrity list, list fragment is populated
    override fun onInfoDownloaded(celebrity: Celebrity) {
        list.addCelebrity(celebrity)

        if (!detailSet) {
            detailSet = true
            onCelebrityClicked(celebrity)
        }
    }

    //=CelebrityListFragment.CelebrityClickedListener Override=====================================
    // When a celebrity from the list is clicked on, extra details are downloaded
    override fun onCelebrityClicked(celebrity: Celebrity) {
        Log.d("YOO", "IM CLICKED")
        GetCelebDetailsTask(this).execute(celebrity)
    }

    //=GetCelebDetailsTask.CelebDetailsListener Override===========================================
    // When extra details are downloaded, details fragment is populated
    override fun onDetailsDownloaded(celebrity: Celebrity) {
        detail.updateUI(celebrity)
    }
}
