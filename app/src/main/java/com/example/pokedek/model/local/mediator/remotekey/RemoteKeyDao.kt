package com.example.pokedek.model.local.mediator.remotekey

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RemoteKeyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllKeys(remoteKey: List<RemoteKeys>)

    @Query("SELECT * FROM RemoteKeysPokemon WHERE id = :id")
    suspend fun getRemoteKeysId(id: Int): RemoteKeys?

    @Query("DELETE FROM RemoteKeysPokemon")
    suspend fun deleteRemoteKeys()
}