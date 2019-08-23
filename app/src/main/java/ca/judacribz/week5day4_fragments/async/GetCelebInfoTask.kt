package ca.judacribz.week5day4_fragments.async

import android.os.AsyncTask
import android.util.Log
import ca.judacribz.week5day4_fragments.model.Celebrity

import org.jsoup.Jsoup

import java.io.IOException

class GetCelebInfoTask(val celebInfoListener: CelebInfoListener) :
    AsyncTask<String, Void, Celebrity>() {

    interface CelebInfoListener {
        fun onInfoDownloaded(celebrity: Celebrity)
    }

    override fun doInBackground(vararg names: String): Celebrity {
        val celebrity = Celebrity(names[0], names[1])
        val info = arrayOf("", "")

        try {
            var document = Jsoup.connect(
                String.format(
                    URL_IMDB_SEARCH,
                    names[0],
                    names[1]
                )
            ).get()

            if (document.getElementsByClass("findNoResults").size == 0) {
                val urlPart = document
                    .getElementsByClass("primary_photo").get(0)
                    .getElementsByTag("a").get(0)
                    .attr("href")
                val url = String.format(
                    URL_IMDB,
                    urlPart
                )
                document = Jsoup.connect(url).get()
                var element = document.getElementById("name-poster")
                if (element != null) {
                    info[0] = element.attr("src")
                }
                element = document.getElementsByClass("name-trivia-bio-text").get(0)
                    .getElementsByTag("span").get(0).getElementsByTag("a").get(0)
                info[1] = urlPart.substring(0, urlPart.indexOf("?"))
                Log.d("YOOO", info[1])

                celebrity.pictureUrl = info[0]
                celebrity.description = info[1]
                celebrity.detailsUrl = String.format(URL_IMDB, element.attr("href"))

            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return celebrity
    }

    override fun onPostExecute(celebrity: Celebrity) {
        celebInfoListener.onInfoDownloaded(celebrity)
    }

    companion object {
        private val URL_IMDB = "https://www.imdb.com%s"
        private val URL_IMDB_SEARCH = String.format(
            URL_IMDB,
            "/find?ref_=nv_sr_fn&q=%s+%s"
        )
    }
}