package com.k0d4black.theforce.data.models.response

import com.squareup.moshi.Json

data class SpeciesResponse(@field:Json(name = "species") val specieUrls: List<String>)

data class SpecieDetailResponse(val name: String, val language: String)