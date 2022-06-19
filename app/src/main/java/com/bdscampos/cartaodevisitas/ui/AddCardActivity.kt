package com.bdscampos.cartaodevisitas.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bdscampos.cartaodevisitas.App
import com.bdscampos.cartaodevisitas.R
import com.bdscampos.cartaodevisitas.data.Cartao
import com.bdscampos.cartaodevisitas.databinding.ActivityAddCardBinding
import com.github.dhaval2404.colorpicker.ColorPickerDialog
import com.github.dhaval2404.colorpicker.model.ColorShape

class AddCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddCardBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {
        var pickedColor: String = ""
        binding.btnClose.setOnClickListener{
            finish()
        }

        binding.btnColor.setOnClickListener{
            ColorPickerDialog
                .Builder(this)
                .setTitle("Escolha a cor para o cartão")
                .setColorShape(ColorShape.SQAURE)
                .setColorListener { color, colorHex ->
                    pickedColor = colorHex
                }
                .show()
        }

        binding.btnConfirm.setOnClickListener{
            val cartao = Cartao(
                nome = binding.tilName.editText?.text.toString(),
                telefone = binding.tilPhone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                empresa = binding.tilCompany.editText?.text.toString(),
                fundo = pickedColor
            )
            mainViewModel.insert(cartao)
            Toast.makeText(this, R.string.sucesso, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}