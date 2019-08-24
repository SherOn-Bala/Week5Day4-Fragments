package ca.judacribz.week5day4_fragments.async

import android.os.AsyncTask
import android.util.Log
import ca.judacribz.week5day4_fragments.model.Celebrity
import org.jsoup.Jsoup
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class GetCelebDetailsTask(private val celebDetailsListener: CelebDetailsListener) :
    AsyncTask<Celebrity, Void, Celebrity>() {

    interface CelebDetailsListener {
        fun onDetailsDownloaded(celebrity: Celebrity)
    }

    override fun doInBackground(vararg celebrities: Celebrity): Celebrity {
        val celebrity = celebrities[0]
        try {
            val document = Jsoup.connect(celebrity.detailsUrl).get()
            val trTags = document.getElementById("overviewTable").getElementsByTag("tr")

            // Birthday
            val date: Date? = Companion.inDateFormat.parse(
                trTags[0]
                    .getElementsByTag("time")
                    .attr("datetime")
            )
            if (date != null) {
                celebrity.birthday = Companion.outDateFormat.format(date)
            }

            // Birth Location
            val aTags = trTags[0].getElementsByTag("a")
            celebrity.birthLocation = aTags[aTags.size - 1].text()

            // Height
            celebrity.height = trTags[trTags.size-1].getElementsByTag("td")[1].text()

            // Description
            celebrity.description = document
                .getElementsByClass("soda")[0]
                .getElementsByTag("p")[0]
                .text()


        } catch (e: IOException) {
            e.printStackTrace()
        }

        return celebrity
    }

    override fun onPostExecute(celebrity: Celebrity) {
        celebDetailsListener.onDetailsDownloaded(celebrity)
    }

    companion object {
        private val inDateFormat = SimpleDateFormat("yyyy-M-d", Locale.US)
        private val outDateFormat = SimpleDateFormat("MMM dd, yyyy", Locale.US)
    }
}