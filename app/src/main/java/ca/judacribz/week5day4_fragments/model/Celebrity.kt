package ca.judacribz.week5day4_fragments.model

import android.os.Parcel
import android.os.Parcelable

data class Celebrity(
    val firstName: String?,
    val lastName: String?
) : Parcelable {
    var description: String? = null
    var pictureUrl: String? = null

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
        description = parcel.readString()
        pictureUrl = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(description)
        parcel.writeString(pictureUrl)
    }

    override fun describeContents(): Int {
        return 0
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
