package com.example.palgit

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import com.example.palgit.coloresfragments.BlueFragment
import com.example.palgit.coloresfragments.GreenFragment
import com.example.palgit.coloresfragments.RedFragment

class RegistroFragment : Fragment(R.layout.fragment_registro) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnEnviar = view.findViewById<Button>(R.id.btnEnviar)
        val etname = view.findViewById<EditText>(R.id.etName)
        val etage = view.findViewById<EditText>(R.id.etEdad)

        btnEnviar.setOnClickListener {
            val radioGroup = view.findViewById<RadioGroup>(R.id.radioGroupColores)
            val nombre = etname.text.toString()
            val edad = etage.text.toString()

            val bundle = Bundle()
            bundle.putString("nombre_key", nombre)
            bundle.putString("edad_key", edad)

            val resultado = when (radioGroup.checkedRadioButtonId) {
                R.id.radioVerde-> {
                    val verdeFragment = GreenFragment()
                    verdeFragment.arguments = bundle

                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, verdeFragment)
                        .addToBackStack(null)
                        .commit()
                }
                R.id.radioAzul -> {
                    val azulFragment = BlueFragment()
                    azulFragment.arguments = bundle

                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, azulFragment)
                        .addToBackStack(null)
                        .commit()}
                R.id.radioRojo -> {
                    val rojoFragment = RedFragment()
                    rojoFragment.arguments = bundle

                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, rojoFragment)
                        .addToBackStack(null)
                        .commit()
                }
                else -> "Nada"
            }
        }
    }
}