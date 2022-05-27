package com.blackgreen.volley_rickandmorty

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.blackgreen.volley_rickandmorty.modelo.Personaje
import com.blackgreen.volley_rickandmorty.personajeadapter.PersonajeAdapter

class MainActivity : AppCompatActivity() {

    lateinit var miRecyclerView: RecyclerView
    lateinit var listaPersonajes:ArrayList<Personaje>
    lateinit var adapter: PersonajeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        miRecyclerView = findViewById(R.id.RecyclearPersonajes)
        listaPersonajes = ArrayList<Personaje>()
        adapter = PersonajeAdapter(listaPersonajes)
        miRecyclerView.adapter = adapter
        getData()
        miRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
    }

    private fun getData(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://rickandmortyapi.com/api/character/"

        val objectRequest = JsonObjectRequest(
            Request.Method.GET,
            url,
            null,
            Response.Listener { response ->
                val personajeJson = response.getJSONArray("results")
                for(indice in 0..personajeJson.length()-1){
                    val perIndJson = personajeJson.getJSONObject(indice)
                    val personaje = Personaje(perIndJson.getString("name"),
                                              perIndJson.getString("status"),
                                              perIndJson.getString("species"),
                                              perIndJson.getString("image"),
                                              perIndJson.getString("gender"))



                    listaPersonajes.add(personaje)
                }
            },
            Response.ErrorListener{
                Log.e("PersonajesAPI","Error")
            }
        )
        queue.add(objectRequest)
    }
}