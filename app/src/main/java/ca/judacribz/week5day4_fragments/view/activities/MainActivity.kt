package ca.judacribz.week5day4_fragments.view.activities

import android.os.Bundle
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
    GetCelebDetailsTask.CelebDetailsListener,
    CelebrityListFragment.CelebrityClickedListener {

    var detailSet = false;
    lateinit var manager: FragmentManager
    val list: CelebrityListFragment = CelebrityListFragment()
    val detail: CelebrityDetailFragment = CelebrityDetailFragment()

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

    override fun onInfoDownloaded(celebrity: Celebrity) {
        list.addCelebrity(celebrity)

        if (!detailSet) {
            detailSet = true
            onCelebrityClicked(celebrity)
        }
    }

    override fun onCelebrityClicked(celebrity: Celebrity) {
        GetCelebDetailsTask(this).execute(celebrity)
    }

    override fun onDetailsDownloaded(celebrity: Celebrity) {
        detail.updateUI(celebrity)
    }
}
