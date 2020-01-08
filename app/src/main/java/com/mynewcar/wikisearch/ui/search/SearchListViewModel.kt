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

package com.mynewcar.wikisearch.ui.search

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.mynewcar.wikisearch.base.BaseViewModel
import com.mynewcar.wikisearch.network.SearchApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Search view model to call the
 * api
 */
class SearchListViewModel: BaseViewModel() {

    @Inject
    lateinit var searchApi: SearchApi

    private lateinit var mSubscription: Disposable
    private val mLoadingVisibility : MutableLiveData<Int> = MutableLiveData()

    init{
        loadSearch()
    }

    private fun loadSearch(){
        mSubscription = searchApi.getSearchResults()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveSearchListStart() }
            .doOnTerminate { onRetrieveSearchListFinish() }
            .subscribe(
                { onRetrieveSearchListSuccess() },
                { onRetrieveSearchListError() }
            )
    }

    private fun onRetrieveSearchListError() {

    }

    private fun onRetrieveSearchListSuccess() {

    }

    private fun onRetrieveSearchListFinish() {
        mLoadingVisibility.value = View.GONE
    }

    private fun onRetrieveSearchListStart() {
        mLoadingVisibility.value = View.VISIBLE
    }

    override fun onCleared() {
        super.onCleared()
        mSubscription.dispose()
    }
    
}