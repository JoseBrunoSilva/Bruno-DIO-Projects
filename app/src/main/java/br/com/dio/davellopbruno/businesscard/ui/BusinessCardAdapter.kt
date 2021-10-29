package br.com.dio.davellopbruno.businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.dio.davellopbruno.businesscard.data.Businesscard
import br.com.dio.davellopbruno.businesscard.databinding.ItemBusinessCardBinding

class BusinessCardAdapter :
    ListAdapter<Businesscard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Businesscard) {
            binding.titleName.text = item.nome
            binding.titleTelefone.text = item.telefone
            binding.titleEmail.text = item.email
            binding.empresa.text = item.empresa
            binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.mcvContent.setOnClickListener {
                listenerShare(it)
            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Businesscard>() {
    override fun areItemsTheSame(oldItem: Businesscard, newItem: Businesscard) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Businesscard, newItem: Businesscard) =
        oldItem.id == newItem.id
}