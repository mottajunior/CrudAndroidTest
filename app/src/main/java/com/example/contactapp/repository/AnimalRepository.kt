package com.example.contactapp.repository

import com.example.contactapp.api.getAnimalAPI
import com.example.contactapp.model.Animal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnimalRepository {

    fun buscarTodos(
        onComplete:(List<Animal>?) -> Unit,
        onError: (Throwable?) -> Unit
    ) {
        getAnimalAPI()
            .getAnimals()
            .enqueue(object : Callback<List<Animal>> {
                override fun onFailure(call: Call<List<Animal>>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<List<Animal>>, response: Response<List<Animal>>) {
                    if(response.isSuccessful) {
                        onComplete(response.body())
                    } else {
                        onError(Throwable("Ocorreu um erro ao buscar os dados"))
                    }
                }
            })
    }

    fun salvar(animal: Animal,
               onComplete: (Animal) -> Unit,
               onError: (Throwable?) -> Unit) {
        getAnimalAPI()
            .salvar(animal)
            .enqueue(object : Callback<Animal>{
                override fun onFailure(call: Call<Animal>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<Animal>, response: Response<Animal>) {
                    onComplete(response.body()!!)
                }
            })
    }

}