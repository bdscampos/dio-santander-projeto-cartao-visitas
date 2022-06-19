package com.bdscampos.cartaodevisitas.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bdscampos.cartaodevisitas.App
import com.bdscampos.cartaodevisitas.databinding.ActivityMainBinding
import com.bdscampos.cartaodevisitas.util.Image

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    private val adapter by lazy { CartaoAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllCards()
        insertListener()
    }

    private fun insertListener() {
        binding.fabNewCard.setOnClickListener {
            var intent = Intent(this@MainActivity, AddCardActivity::class.java)
            startActivity(intent)
        }

        adapter.listenerShare = { card ->
            Image.share(this, card)
        }
    }

    private fun getAllCards() {
        mainViewModel.getAll().observe(this) { cartoes ->
            adapter.submitList(cartoes)
        }
    }
}