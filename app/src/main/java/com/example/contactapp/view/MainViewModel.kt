package com.example.contactapp.view

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.contactapp.model.Animal
import com.example.contactapp.repository.AnimalRepository

class MainViewModel : ViewModel() {
    val notaRepository = AnimalRepository()

    val animals : MutableLiveData<List<Animal>> = MutableLiveData()
    val mensagemErro : MutableLiveData<String> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun buscarTodos () {
        isLoading.value = true
        notaRepository.buscarTodos(
            onComplete = {
                isLoading.value = false
                animals.value = it

            },
            onError = {
                isLoading.value = false
                mensagemErro.value = it?.message
            }
        )
    }
}