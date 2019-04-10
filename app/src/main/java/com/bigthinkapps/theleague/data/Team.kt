package com.bigthinkapps.theleague.data

import com.bigthinkapps.theleague.utils.AppConstants
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Team(
    @SerializedName("idTeam") val id: String,
    @SerializedName("intFormedYear") val formedYear: String,
    @SerializedName("strTeam") val name: String,
    @SerializedName("strStadium") val stadium: String,
    @SerializedName("strAlternate") val longName: String,
    @SerializedName("strDescriptionES") val description: String,
    @SerializedName("strTeamBadge") val urlBadge: String,
    @SerializedName("strTeamJersey") val urlJersey: String,
    @SerializedName("strWebsite") val webSite: String = AppConstants.EMPTY_STRING,
    @SerializedName("strFacebook") val facebook: String = AppConstants.EMPTY_STRING,
    @SerializedName("strTwitter") val twitter: String = AppConstants.EMPTY_STRING,
    @SerializedName("strInstagram") val instagram: String = AppConstants.EMPTY_STRING
) : Serializable