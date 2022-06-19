package com.bdscampos.cartaodevisitas

import android.app.Application
import com.bdscampos.cartaodevisitas.data.AppDatabase
import com.bdscampos.cartaodevisitas.data.CartaoRepository

class App : Application() {
    val database by lazy {AppDatabase.getDatabase(this)}
    val repository by lazy { CartaoRepository(database.cartaoDao()) }
}