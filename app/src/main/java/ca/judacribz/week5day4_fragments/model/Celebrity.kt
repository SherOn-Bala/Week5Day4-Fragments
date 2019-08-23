package ca.judacribz.week5day4_fragments.model

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class Celebrity(
    val firstName: String?,
    val lastName: String?
) : Parcelable {
    var description: String? = null
    var pictureUrl: String? = null
    var detailsUrl: String? = null
    var birthday: String? = null
    var birthLocation: String? = null
    var height: String? = null

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
        description = parcel.readString()
        pictureUrl = parcel.readString()
        detailsUrl = parcel.readString()
        birthday = parcel.readString()
        birthLocation = parcel.readString()
        height = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(description)
        parcel.writeString(pictureUrl)
        parcel.writeString(detailsUrl)
        parcel.writeString(birthday)
        parcel.writeString(birthLocation)
        parcel.writeString(height)
    }

    override fun describeContents(): Int {
        return 0
    }


    fun getName() : String {
        return String.format(
            Locale.US,
            "%s %s",
            firstName,
            lastName
        )
    }

    fun getHeightStr() : String {
        return String.format(
            Locale.US,
            "Height: %s",
            height
        )
    }

    fun getBirth(): String {
        return String.format(
            Locale.US,
            "Born: %s in %s",
            birthday,
            birthLocation
        )
    }

    companion object CREATOR : Parcelable.Creator<Celebrity> {
        override fun createFromParcel(parcel: Parcel): Celebrity {
            return Celebrity(parcel)
        }

        override fun newArray(size: Int): Array<Celebrity?> {
            return arrayOfNulls(size)
        }
    }
}
