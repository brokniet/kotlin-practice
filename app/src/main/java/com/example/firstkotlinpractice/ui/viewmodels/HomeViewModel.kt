package com.example.firstkotlinpractice.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstkotlinpractice.data.models.Image
import com.example.firstkotlinpractice.data.repositories.ImageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val imageRepository: ImageRepository
): ViewModel() {

    private val _imageList = MutableLiveData<List<Image>>()
    val imageList: LiveData<List<Image>> = _imageList

    init {
        loadImages()
    }

    public fun loadImages() {
        viewModelScope.launch {
            try {
                //agregarle algo para el paginado, ir sumando los ids a la query de la url, etc
                _imageList.postValue(imageRepository.getImages().body())
            } catch (e: Exception) {
                //agregar manejo
            }
        }
    }

}