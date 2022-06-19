package com.bdscampos.cartaodevisitas.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CartaoRepository (
    private val dao: CartaoDao
        ) {

    fun insert(cartao: Cartao) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(cartao)
        }
    }

    fun getAll() = dao.getAll()
}