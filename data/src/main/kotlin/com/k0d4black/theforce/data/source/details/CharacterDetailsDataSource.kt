package com.k0d4black.theforce.data.source.details

import com.k0d4black.theforce.data.models.entities.CharacterDetailsDataModel

internal interface CharacterDetailsDataSource {

    suspend fun getCharacter(characterId: Int): CharacterDetailsDataModel?

}