package com.free.odev7.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.free.odev7.R
import com.free.odev7.databinding.FragmentNotGoruntuleBinding
import com.free.odev7.ui.viewmodel.NotGoruntulemeViewModel
import com.free.odev7.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotGoruntuleFragment : Fragment() {
    private lateinit var binding: FragmentNotGoruntuleBinding
    private lateinit var viewModel: NotGoruntulemeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotGoruntuleBinding.inflate(inflater, container, false)

        val bundle:NotGoruntuleFragmentArgs by navArgs()
        val gelenNot = bundle.not

        binding.editTextNot.setText(gelenNot.not)

        binding.buttonGuncelle.setOnClickListener {
            val not = binding.editTextNot.text.toString()
            viewModel.guncelle(gelenNot.not_id,not)

            Navigation.gecis(it,R.id.notlarGecis)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: NotGoruntulemeViewModel by viewModels()
        viewModel = tempViewModel
    }
}