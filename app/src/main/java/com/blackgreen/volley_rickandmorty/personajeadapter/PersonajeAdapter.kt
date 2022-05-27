package com.blackgreen.volley_rickandmorty.personajeadapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blackgreen.volley_rickandmorty.R
import com.blackgreen.volley_rickandmorty.modelo.Personaje
import com.squareup.picasso.Picasso

data class PersonajeAdapter(val listPersonajes: ArrayList<Personaje>):RecyclerView.Adapter<PersonajeAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vistapersonajes,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNombre.text = listPersonajes[position].name
        holder.tvStatus.text = "Status: ${listPersonajes[position].status}"
        holder.tvSpecie.text = "Specie: ${listPersonajes[position].species}"
        Picasso.get().load(listPersonajes[position].image).into(holder.ivFoto)
        holder.tvGender.text = "Gender: ${listPersonajes[position].gender}"


    }

    override fun getItemCount(): Int {
        return listPersonajes.size
    }

    class ViewHolder(vista: View):RecyclerView.ViewHolder(vista) {
        val tvNombre: TextView
        val tvStatus: TextView
        val tvSpecie: TextView
        val ivFoto: ImageView
        val tvGender: TextView




        init {
            tvNombre = vista.findViewById(R.id.tvName)
            tvStatus = vista.findViewById(R.id.tvStatus)
            tvGender = vista.findViewById(R.id.tvGender)
            tvSpecie = vista.findViewById(R.id.tvSpecies)
            ivFoto = vista.findViewById(R.id.ivImage)
        }

    }

}
