package com.bdscampos.cartaodevisitas.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CartaoDao {

    @Query("SELECT * FROM Cartao")
    fun getAll(): LiveData<List<Cartao>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(cartao: Cartao)
}