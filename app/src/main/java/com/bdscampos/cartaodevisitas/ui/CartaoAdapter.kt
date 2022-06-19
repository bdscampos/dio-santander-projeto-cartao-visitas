package com.bdscampos.cartaodevisitas.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bdscampos.cartaodevisitas.data.Cartao
import com.bdscampos.cartaodevisitas.databinding.ItemCartaoVisitaBinding

class CartaoAdapter : ListAdapter<Cartao, CartaoAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCartaoVisitaBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemCartaoVisitaBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Cartao) {
            binding.txtName.text = item.nome
            binding.txtPhone.text = item.telefone
            binding.txtEmail.text = item.email
            binding.txtEmpresa.text = item.empresa
            binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.fundo))
            binding.mcvContent.setOnClickListener {
                listenerShare(it)
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Cartao>() {
    override fun areItemsTheSame(oldItem: Cartao, newItem: Cartao) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Cartao, newItem: Cartao) = oldItem.id == newItem.id
}
