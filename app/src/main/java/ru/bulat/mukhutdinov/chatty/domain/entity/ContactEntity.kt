package ru.bulat.mukhutdinov.chatty.domain.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.databinding.BaseObservable
import ru.bulat.mukhutdinov.chatty.data.dto.ContactDto

class ContactEntity(var icon: String? = null,
                    var firstName: String? = null,
                    var lastName: String? = null,
                    var messages: List<String> = ArrayList()) : Parcelable {

    constructor(contact: ContactDto) : this(contact.icon, contact.fistName, contact.lastName, contact.messages.toList())

    fun getFullName(): String {
        var fullName: String = if (firstName == null) "" else "$firstName"
        fullName += if (lastName == null) "" else " $lastName"

        return fullName
    }

    fun getLastMessage(): String = if (messages.isNotEmpty()) messages[0] else ""

    fun getIconPlaceholder() = firstName?.substring(0, 1)?.toUpperCase() + lastName?.substring(0, 1)?.toUpperCase()

    fun hasIcon(): Boolean = !icon.isNullOrBlank()

    constructor(parcel: Parcel) : this() {
        icon = parcel.readString()
        firstName = parcel.readString()
        lastName = parcel.readString()
        messages = parcel.createStringArrayList()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(icon)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeStringList(messages)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ContactEntity> {
        override fun createFromParcel(parcel: Parcel): ContactEntity {
            return ContactEntity(parcel)
        }

        override fun newArray(size: Int): Array<ContactEntity?> {
            return arrayOfNulls(size)
        }
    }
}