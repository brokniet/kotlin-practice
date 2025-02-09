package com.example.firstkotlinpractice.ui.views.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.firstkotlinpractice.databinding.FragmentHomeBinding
import com.example.firstkotlinpractice.ui.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        /*
        homeViewModel.imageList.observe(viewLifecycleOwner, Observer { imageList ->
            //aca eventualmente armar el loop de consultas y carga de imagenes ?
        })*/
        homeViewModel.loadImages()

        return binding.root
    }
}