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

package com.mynewcar.wikisearch.base

import androidx.lifecycle.ViewModel
import com.mynewcar.wikisearch.injection.component.DaggerViewModelInjector
import com.mynewcar.wikisearch.injection.component.ViewModelInjector
import com.mynewcar.wikisearch.injection.module.NetworkModule
import com.mynewcar.wikisearch.ui.search.SearchListViewModel

/**
 * Base view model for the while project
 */
abstract class BaseViewModel : ViewModel() {

    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is SearchListViewModel -> injector.inject(this)
        }
    }

}