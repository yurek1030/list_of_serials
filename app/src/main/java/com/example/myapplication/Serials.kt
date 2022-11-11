package com.example.myapplication

import android.os.Parcel
import android.os.Parcelable

data class Serials(val image: Int, val name: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Serials> {
        override fun createFromParcel(parcel: Parcel): Serials {
            return Serials(parcel)
        }

        override fun newArray(size: Int): Array<Serials?> {
            return arrayOfNulls(size)
        }
    }
}
