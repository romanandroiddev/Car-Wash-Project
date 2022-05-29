package uz.project.mycarwashproject.presenter.vehicle

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable


data class ObjectClass(
    var img_car: Int,
    var companyName: String,
    var modelName: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel?, p1: Int) {
        p0?.writeInt(img_car)
        p0?.writeString(companyName)
        p0?.writeString(modelName)
    }

    companion object CREATOR : Parcelable.Creator<ObjectClass> {
        override fun createFromParcel(parcel: Parcel): ObjectClass {
            return ObjectClass(parcel)
        }

        override fun newArray(size: Int): Array<ObjectClass?> {
            return arrayOfNulls(size)
        }
    }
}