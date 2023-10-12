package com.juanma.juanmapokedex.data.model

import com.google.gson.annotations.SerializedName

data class PokeApiResponse (
    @SerializedName("count") val count: Int,
    @SerializedName("next") val next: String,
    @SerializedName("previous") val previous: String,
    @SerializedName("results") val results: List<PokeResult>
)