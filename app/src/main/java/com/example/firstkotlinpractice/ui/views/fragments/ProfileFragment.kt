package com.example.firstkotlinpractice.ui.views.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.firstkotlinpractice.R
import com.example.firstkotlinpractice.databinding.FragmentProfileBinding
import com.example.firstkotlinpractice.ui.viewmodels.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val profileViewModel: ProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)

        val fab = binding.fab
        val tvName = binding.tvName
        val tvGender = binding.tvGender
        val tvAge = binding.tvAge
        val tvCountry = binding.tvCountry

        profileViewModel.randomUser.observe(viewLifecycleOwner, Observer { user ->
            tvName.text = profileViewModel.getFullName()
            tvGender.text = profileViewModel.getGender()
            tvAge.text = profileViewModel.getAge()
            tvCountry.text = profileViewModel.getCountry()
        })

        fab.setOnClickListener{
            profileViewModel.loadRandomUser()
        }

        return binding.root
    }
}