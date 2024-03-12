package com.free.odev7.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.free.odev7.R
import com.free.odev7.databinding.FragmentNotlarBinding
import com.free.odev7.ui.adapter.NotlarAdapter
import com.free.odev7.ui.viewmodel.NotlarViewModel
import com.free.odev7.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotlarFragment : Fragment() {
    private lateinit var binding: FragmentNotlarBinding
    private lateinit var viewModel: NotlarViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNotlarBinding.inflate(inflater, container, false)

        viewModel.notlarListesi.observe(viewLifecycleOwner){
            val notlarAdapter = NotlarAdapter(requireContext(),it,viewModel)
            binding.notlarRv.adapter = notlarAdapter
        }

        binding.notlarRv.layoutManager = LinearLayoutManager(requireContext())

        binding.fab.setOnClickListener {
            Navigation.gecis(it,R.id.notEkleGecis)
        }

        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.ara(query)
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: NotlarViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.notlariYukle()
    }
}