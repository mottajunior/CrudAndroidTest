package com.example.contactapp.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.contactapp.R
import com.example.contactapp.model.Animal
import kotlinx.android.synthetic.main.contact_item.view.*

class MainListAdapter(
    val context: Context,
    val animais: List<Animal>,
    val clickLista: (Animal) -> Unit
) :
    RecyclerView.Adapter<MainListAdapter.NotaViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NotaViewHolder {

        val itemView = LayoutInflater.from(context)
            .inflate(R.layout.contact_item, p0, false)

        return NotaViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return animais.size
    }

    override fun onBindViewHolder(p0: NotaViewHolder, position: Int) {
        val nota = animais[position]
        p0.bindView(nota, clickLista)
    }


    class NotaViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        fun bindView(
            animal: Animal,
            clickLista: (Animal) -> Unit
        ) = with(itemView) {
            tvNome.text = animal.Nome
            tvIdade.text = animal.Idade.toString()

            setOnClickListener { clickLista(animal) }
        }

    }
}