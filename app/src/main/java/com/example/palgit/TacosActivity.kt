package com.example.palgit

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
//import androidx.compose.ui.semantics.text
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doOnTextChanged
import org.w3c.dom.Text
lateinit var etcantidadTacoPastor: EditText
lateinit var etcantidadTacoAsada: EditText
lateinit var etcantidadTortaPastor: EditText
lateinit var etcantidadTortaAsada: EditText
lateinit var etcantidadCoca: EditText
lateinit var etcantidadHorchata: EditText
lateinit var tvTotalTacoPastor: TextView
lateinit var tvTotalTacoAsada: TextView
lateinit var tvTotalTortaPastor: TextView
lateinit var tvTotalTortaAsada: TextView
lateinit var tvtotalCoca: TextView
lateinit var tvtotalHorchata: TextView
lateinit var tvTotalCuenta: TextView
lateinit var btnCalcular: Button
class TacosActivity : AppCompatActivity() {
    private val listArray = MutableList<Double>(6){0.0}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tacos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        totales()
        btnCalcular.setOnClickListener { calcular() }
    }
    fun initComponents(){
        etcantidadTacoPastor = findViewById<EditText>(R.id.cantidadTacoPastor)
        etcantidadTacoAsada = findViewById<EditText>(R.id.cantidadTacoAsada)
        etcantidadTortaPastor = findViewById<EditText>(R.id.cantidadTortaPastor)
        etcantidadTortaAsada = findViewById<EditText>(R.id.cantidadTortaAsada)
        etcantidadCoca = findViewById<EditText>(R.id.cantidadCoca)
        etcantidadHorchata = findViewById<EditText>(R.id.cantidadHorchata)
        tvTotalTacoPastor = findViewById<TextView>(R.id.tvTotalTacoPastor)
        tvTotalTacoAsada = findViewById<TextView>(R.id.tvTotalTacoAsada)
        tvTotalTortaPastor = findViewById<TextView>(R.id.tvTotalTortaPastor)
        tvTotalTortaAsada = findViewById<TextView>(R.id.tvTotalTortaAsada)
        tvtotalCoca = findViewById<TextView>(R.id.tvtotalCoca)
        tvtotalHorchata = findViewById<TextView>(R.id.tvtotalHorchata)
        tvTotalCuenta = findViewById< TextView>(R.id.tvTotalCuenta)
        btnCalcular = findViewById<Button>(R.id.btnCalcular)
    }

    fun totales(){
        var precioTacoPastor: Double = 25.00
        var precioTacoAsada: Double = 20.00
        var precioTortaPastor: Double = 65.00
        var precioTortaAsada: Double = 55.00
        var precioCoca: Double = 15.00
        var precioHorchata: Double = 15.00

        etcantidadTacoPastor.doOnTextChanged { text, _, _, _ ->
            // Convertimos lo que el usuario escribe a número
            val cantidadTacosPastor = text.toString().toDoubleOrNull() ?: 0.0
            // Calculamos
            val totalTacosPastor = cantidadTacosPastor * precioTacoPastor
            // Actualizamos el textview
            tvTotalTacoPastor.text = "$${String.format("%.2f", totalTacosPastor)}"
            listArray[0] = totalTacosPastor
        }

        etcantidadTacoAsada.doOnTextChanged { text, _, _, _ ->
            val cantidadTacosAsada = text.toString().toDoubleOrNull() ?: 0.0
            val totalTacosAsada = cantidadTacosAsada * precioTacoAsada
            tvTotalTacoAsada.text = "$${String.format("%.2f", totalTacosAsada)}"
            listArray[1] = totalTacosAsada
        }

        etcantidadTortaPastor.doOnTextChanged { text, _, _, _ ->
            val cantidadTortaPastor = text.toString().toDoubleOrNull() ?: 0.0
            val totalTortaPastor = cantidadTortaPastor * precioTortaPastor
            tvTotalTortaPastor.text = "$${String.format("%.2f", totalTortaPastor)}"
            listArray[2] = totalTortaPastor
        }

        etcantidadTortaAsada.doOnTextChanged { text, _, _, _ ->
            val cantidadTortaAsada = text.toString().toDoubleOrNull() ?: 0.0
            val totalTortaAsada = cantidadTortaAsada * precioTortaAsada
            tvTotalTortaAsada.text = "$${String.format("%.2f", totalTortaAsada)}"
            listArray[3] = totalTortaAsada
        }
        etcantidadCoca.doOnTextChanged { text, _, _, _ ->
            val cantidadCoca = text.toString().toDoubleOrNull() ?: 0.0
            val totalCoca = cantidadCoca * precioCoca
            tvtotalCoca.text = "$${String.format("%.2f", totalCoca)}"
            listArray[4] = totalCoca
        }
        etcantidadHorchata.doOnTextChanged { text, _, _, _ ->
            val cantidadHorchata = text.toString().toDoubleOrNull() ?: 0.0
            val totalHorchata = cantidadHorchata * precioHorchata
            tvtotalHorchata.text = "$${String.format("%.2f", totalHorchata)}"
            listArray[5] = totalHorchata
        }
    }

    fun calcular(){
        val totalTacos = listArray.sum()
        tvTotalCuenta.text = "$${String.format("%.2f", totalTacos)}"
    }
}