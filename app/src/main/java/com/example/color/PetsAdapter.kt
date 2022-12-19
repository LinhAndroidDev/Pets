package com.example.color

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PetsAdapter(private val listPets : List<Pets>)
    : RecyclerView.Adapter<PetsAdapter.ViewHolderPets>() {

        class ViewHolderPets(itemView: View) : RecyclerView.ViewHolder(itemView){
            val anh : ImageView = itemView.findViewById(R.id.anhPets);
            val name : TextView = itemView.findViewById(R.id.namePets);
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPets {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_pets,parent,false);
        return ViewHolderPets(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolderPets, position: Int) {
        var pets : Pets = listPets.get(position)
        holder.anh.setBackgroundResource(pets.image)
        holder.name.text = pets.ten
    }

    override fun getItemCount(): Int {
        return listPets.size
    }
}