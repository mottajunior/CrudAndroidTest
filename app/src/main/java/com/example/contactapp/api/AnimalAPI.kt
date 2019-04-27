package com.example.contactapp.api

import com.example.contactapp.model.Animal
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AnimalAPI {

    @GET("/api/animals")
    fun getAnimals() : Call<List<Animal>>

    @POST("/api/animals")
    fun salvar(@Body animal: Animal): Call<Animal>

}