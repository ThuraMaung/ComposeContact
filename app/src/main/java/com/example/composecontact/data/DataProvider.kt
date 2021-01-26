package com.example.composecontact.data

import com.example.composecontact.R

object DataProvider {

    val contactList = mutableListOf(

        Contact("Henry Pedersen", "093-2184-9302", R.drawable.avatar_1_raster),
        Contact("Mathias Hoem", "093-827-8230", R.drawable.avatar_2_raster),
        Contact("Jacob Andersen", "094-637-2814", R.drawable.avatar_6_raster),
        Contact("Theresa Hunter", "099-827-8261", R.drawable.avatar_4_raster),
        Contact("Amelia Forsyth", "094-198-8214", R.drawable.avatar_5_raster),

        Contact("Victoria Nolan", "093-342-8764", R.drawable.avatar_3_raster),
        Contact("Emma Allan", "093-337-2819", R.drawable.avatar_6_raster),
        Contact("Lillian Lyman", "093-882-9463", R.drawable.avatar_3_raster),
        Contact("Alexander Manning", "092-289-4738", R.drawable.avatar_4_raster),
        Contact("Matt Tucker", "092-289-2748", R.drawable.avatar_2_raster),

        Contact("Cameron King", "092-284-6197", R.drawable.avatar_1_raster),
        Contact("Tracey North", "095-638-8197", R.drawable.avatar_6_raster),
        Contact("Jessica Manning", "092-918-9385", R.drawable.avatar_3_raster),
        Contact("Connor Roberts", "091-973-7391", R.drawable.avatar_4_raster),
        Contact("Nathan Dowd", "094-4637-8227", R.drawable.avatar_1_raster),
        Contact("Samantha Bond", "093-389-2750", R.drawable.avatar_6_raster),
        Contact("Evan Clarkson", "092-948-4661", R.drawable.avatar_2_raster)
    )


    val callLogs = listOf(
        CallLog(CallType.IncomingCall,120L,"091818181", "01:23 PM"),
        CallLog(CallType.IncomingCall,120L,"091818181", "11:30 PM"),
        CallLog(CallType.OutgoingCall,120L,"091818181", "08:10 AM"),
        CallLog(CallType.IncomingCall,120L,"091818181", "10:45 AM"),
        CallLog(CallType.OutgoingCall,120L,"091818181", "12:00 PM")
    )

}



