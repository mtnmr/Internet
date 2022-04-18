package com.example.github.model

import com.squareup.moshi.Json
import java.util.*

data class Repo (
    val id : Int,
    val name : String,
    @Json(name = "full_name") val fullName : String,
    @Json(name = "html_url") val htmlUrl : String,
    val description : String,
    val language : String,
    @Json(name = "default_branch") val defaultBranch : Date,
    @Json(name = "pushed_at")val pushedAt : Date,
    @Json(name = "created_at") val createdAt : Date,
    @Json(name = "updated_at") val updatedAt : Date
    )