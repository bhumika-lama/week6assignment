package model

import android.os.Parcel
import android.os.Parcelable

class Students (
    val Name: String?,
    val Age: Int?,
    val Gender: String?,
    val Address: String?,
    val Image: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Name)
        parcel.writeValue(Age)
        parcel.writeString(Gender)
        parcel.writeString(Address)
        parcel.writeString(Image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Students> {
        override fun createFromParcel(parcel: Parcel): Students {
            return Students(parcel)
        }

        override fun newArray(size: Int): Array<Students?> {
            return arrayOfNulls(size)
        }
    }
}