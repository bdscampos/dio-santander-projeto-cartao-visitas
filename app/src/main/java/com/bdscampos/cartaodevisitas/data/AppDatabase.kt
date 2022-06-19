package com.bdscampos.cartaodevisitas.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cartao::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun cartaoDao() : CartaoDao

    companion object {
        @Volatile
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "cartao_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }


}