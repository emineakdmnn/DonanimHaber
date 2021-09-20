package com.emineakduman.donanmhaber.model.news

import com.google.gson.annotations.SerializedName

data class NewsResponse (
    @SerializedName("Data")
    val results: List<NewsResults>

        )
