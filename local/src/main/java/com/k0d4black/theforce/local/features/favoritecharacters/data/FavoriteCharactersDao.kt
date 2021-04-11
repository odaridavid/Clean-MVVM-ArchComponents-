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
package com.k0d4black.theforce.local.features.favoritecharacters.data

import androidx.room.*
import com.k0d4black.theforce.local.features.favoritecharacters.models.FavoriteCharacterEntity

@Dao
interface FavoriteCharactersDao {

    @Query("DELETE FROM favorites")
    suspend fun deleteAll(): Int

    @Query("DELETE FROM favorites WHERE name=:name")
    suspend fun deleteByName(name: String): Int

    @Transaction
    @Query("SELECT * FROM favorites WHERE name=:name")
    suspend fun getByName(name: String): FavoriteCharacterEntity

    @Transaction
    @Query("SELECT * FROM favorites")
    suspend fun getAll(): List<FavoriteCharacterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(favoriteCharacterEntity: FavoriteCharacterEntity): Long
}