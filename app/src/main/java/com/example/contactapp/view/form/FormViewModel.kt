package com.example.contactapp.view.form

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.contactapp.model.Animal
import com.example.contactapp.model.ResponseStatus
import com.example.contactapp.repository.AnimalRepository

class FormViewModel : ViewModel() {

    val AnimalRepository = AnimalRepository()
    val responseStatus: MutableLiveData<ResponseStatus> = MutableLiveData()

    val isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun salvar(
        id: Int,
        nome: String,
        idade: Int
    ) {
        isLoading.value = true
        val nota = Animal(Id = id, Nome = nome, Idade = idade)
        AnimalRepository.salvar(nota,
            onComplete = {
                isLoading.value = false
                responseStatus.value = ResponseStatus(
                    true,
                    "Dado gravado com sucesso"
                )
            }, onError = {
                isLoading.value = false
                responseStatus.value = ResponseStatus(
                    false,
                    it?.message!!
                )
            })

    }

}