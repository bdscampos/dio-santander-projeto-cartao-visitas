package com.bdscampos.cartaodevisitas.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bdscampos.cartaodevisitas.data.Cartao
import com.bdscampos.cartaodevisitas.data.CartaoRepository

class MainViewModel (
    private val cartaoRepository: CartaoRepository
        ) : ViewModel() {

    fun insert(cartao: Cartao) {
        cartaoRepository.insert(cartao)
    }

    fun getAll() : LiveData<List<Cartao>> {
        return cartaoRepository.getAll()
    }

}

class MainViewModelFactory(
    private val repository: CartaoRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknow View Model Class")
    }
}