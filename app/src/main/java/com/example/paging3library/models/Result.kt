package com.example.paging3library


import com.google.gson.annotations.SerializedName

data class QuoteList(
    @SerializedName("count")
    val count: Int,
    @SerializedName("lastItemIndex")
    val lastItemIndex: Int,
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Results>,
    @SerializedName("totalCount")
    val totalCount: Int,
    @SerializedName("totalPages")
    val totalPages: Int
)

data class Results(
    @SerializedName("author")
    val author: String,
    @SerializedName("authorSlug")
    val authorSlug: String,
    @SerializedName("content")
    val content: String,
    @SerializedName("dateAdded")
    val dateAdded: String,
    @SerializedName("dateModified")
    val dateModified: String,
    @SerializedName("_id")
    val id: String,
    @SerializedName("length")
    val length: Int,
    @SerializedName("tags")
    val tags: List<String>
)