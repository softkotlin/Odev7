package com.free.odev7.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.free.odev7.R
import com.free.odev7.databinding.FragmentNotEkleBinding
import com.free.odev7.ui.viewmodel.NotEkleViewModel
import com.free.odev7.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotEkleFragment : Fragment() {
    private lateinit var binding: FragmentNotEkleBinding
    private lateinit var viewModel: NotEkleViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotEkleBinding.inflate(inflater, container, false)

        binding.buttonKaydet.setOnClickListener {
            val kisi_ad = binding.editTextNot.text.toString()
            viewModel.kaydet(kisi_ad)

            Navigation.gecis(it,R.id.notlarGeciss)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:NotEkleViewModel by viewModels()
        viewModel = tempViewModel
    }
}