/*
 * Copyright 2019 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mynewcar.wikisearch.model

import com.google.gson.annotations.SerializedName

data class PagesItem(@SerializedName("touched")
                     val touched: String = "",
                     @SerializedName("thumbnail")
                     val thumbnail: Thumbnail,
                     @SerializedName("ns")
                     val ns: Int = 0,
                     @SerializedName("canonicalurl")
                     val canonicalurl: String = "",
                     @SerializedName("contentmodel")
                     val contentmodel: String = "",
                     @SerializedName("fullurl")
                     val fullurl: String = "",
                     @SerializedName("pagelanguagehtmlcode")
                     val pagelanguagehtmlcode: String = "",
                     @SerializedName("length")
                     val length: Int = 0,
                     @SerializedName("index")
                     val index: Int = 0,
                     @SerializedName("description")
                     val description: String = "",
                     @SerializedName("pageid")
                     val pageid: Int = 0,
                     @SerializedName("title")
                     val title: String = "",
                     @SerializedName("lastrevid")
                     val lastrevid: Int = 0,
                     @SerializedName("descriptionsource")
                     val descriptionsource: String = "",
                     @SerializedName("pagelanguage")
                     val pagelanguage: String = "",
                     @SerializedName("pagelanguagedir")
                     val pagelanguagedir: String = "",
                     @SerializedName("editurl")
                     val editurl: String = "")

data class Query(@SerializedName("pages")
                 val pages: List<PagesItem>?)

data class SearchResult(@SerializedName("batchcomplete")
                        val batchcomplete: Boolean = false,
                        @SerializedName("continue")
                        val continueData: Continue,
                        @SerializedName("query")
                        val query: Query)

data class Continue(@SerializedName("continue")
                    val continueString: String = "",
                    @SerializedName("gpsoffset")
                    val gpsoffset: Int = 0)

data class Thumbnail(@SerializedName("width")
                     val width: Int = 0,
                     @SerializedName("source")
                     val source: String = "",
                     @SerializedName("height")
                     val height: Int = 0)