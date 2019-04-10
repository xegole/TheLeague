package com.bigthinkapps.theleague.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TeamEvent(
    @SerializedName("idEvent") val id: String,
    @SerializedName("strSport") val sport: String,
    @SerializedName("strEvent") val event: String,
    @SerializedName("strLogo") val urlLogo: String,
    @SerializedName("strChannel") val channel: String,
    @SerializedName("strTime") val time: String,
    @SerializedName("dateEvent") val date: String
) : Serializable