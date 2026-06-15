package com.example.palgit.coloresfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.palgit.R

class GreenFragment: Fragment(R.layout.fragment_green){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvtexto = view.findViewById<TextView>(R.id.tvTexto)
        val nombre = arguments?.getString("nombre_key")
        val edad = arguments?.getString("edad_key")

        tvtexto.text = "Selecciono la pantalla verde, su nombre es $nombre y su edad es $edad"
    }
}