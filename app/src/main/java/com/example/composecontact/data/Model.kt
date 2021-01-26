package com.example.composecontact.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
        val name: String,
        val phNo : String,
        @DrawableRes
        val profile : Int) : Parcelable

data class CallLog(
        val callType : CallType,
        val duration : Long,
        val phoneNo : String,
        val date : String
)

enum class CallType(val typeName : String) {
        IncomingCall("Incoming"),
        OutgoingCall("Outgoing")
}

