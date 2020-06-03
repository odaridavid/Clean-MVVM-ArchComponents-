/**
 *
 * Copyright 2020 David Odari
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *            http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 *
 **/
package com.k0d4black.theforce.fakes

import com.k0d4black.theforce.domain.models.Favorite
import com.k0d4black.theforce.domain.models.Film
import com.k0d4black.theforce.domain.usecases.GetFavoriteByIdBaseUseCase
import com.k0d4black.theforce.utils.UiState
import kotlinx.coroutines.flow.Flow


class FakeGetFavoriteByIdUseCase(
    uiState: UiState
) : BaseTestUseCase<Favorite>(uiState), GetFavoriteByIdBaseUseCase {

    override suspend fun invoke(params: Int): Flow<Favorite> = execute()

    override fun getValue(): Favorite =
        Favorite(
            1,
            "Hans",
            "12 BBY",
            "123",
            "planet",
            "100000",
            "specie",
            "language",
            listOf(Film("title", "crawl"))
        )

}