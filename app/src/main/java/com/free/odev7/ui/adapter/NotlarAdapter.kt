package com.free.odev7.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.free.odev7.data.entity.Notlar
import com.free.odev7.databinding.TasarimBinding
import com.free.odev7.ui.fragment.NotlarFragmentDirections
import com.free.odev7.ui.viewmodel.NotlarViewModel
import com.free.odev7.utils.gecis
import com.google.android.material.snackbar.Snackbar

class NotlarAdapter(var mContext: Context,
                    var notlarListesi:List<Notlar>,
                    var viewModel:NotlarViewModel) : RecyclerView.Adapter<NotlarAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim:TasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = TasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val not = notlarListesi.get(position)
        val t = holder.tasarim
        t.textViewNot.text = not.not

        t.cardViewSatir.setOnClickListener {
            val gecis = NotlarFragmentDirections.notGoruntuleGecis(not = not)
            Navigation.gecis(it,gecis)
        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${not.not} silinsin mi?",Snackbar.LENGTH_SHORT)
                .setAction("EVET"){
                    viewModel.sil(not.not_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return notlarListesi.size
    }
}