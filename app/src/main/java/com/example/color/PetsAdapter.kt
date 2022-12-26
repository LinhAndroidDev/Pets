package com.example.color

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PetsAdapter(private var listPets : List<Pets>)
    : RecyclerView.Adapter<PetsAdapter.ViewHolderPets>(), Filterable {

    private var listPetsOld : List<Pets>

    init {
        listPetsOld = listPets
    }

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

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(p0: CharSequence?): FilterResults {
                var strSearch : String = p0.toString().lowercase()

                if(strSearch.isEmpty()){
                    listPets = listPetsOld
                }
                else{
                    val list : MutableList<Pets> = mutableListOf()
                    for(pet in listPetsOld){
                        if(pet.ten.lowercase().contains(strSearch)){
                            list.add(pet)
                        }
                    }
                    listPets = list
                }
                var filterResults : FilterResults = FilterResults()
                filterResults.values = listPets

                return filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                if (p1 != null && p1.values != null) {
                    listPets = p1.values as List<Pets>
                    notifyDataSetChanged()
                }
            }

        }
    }
}