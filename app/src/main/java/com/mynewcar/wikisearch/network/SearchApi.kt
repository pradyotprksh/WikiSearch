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

package com.mynewcar.wikisearch.network

import com.mynewcar.wikisearch.model.SearchResult
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * The interface which provides methods to get result of webservices
 */
interface SearchApi {

    /**
     * Get the list of the results from the API
     */
    @GET("/api.php?action=query&format=json&prop=info%7Cdescription%7Cpageimages&generator=prefixsearch&redirects=1&formatversion=2&inprop=url&piprop=thumbnail&pithumbsize=50&gpssearch=ios")
    fun getSearchResults() : Observable<ArrayList<SearchResult>>
}