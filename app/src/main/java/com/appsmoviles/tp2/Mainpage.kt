package com.appsmoviles.tp2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random
import android.widget.Button
import android.widget.TextView
import android.util.Log


class Mainpage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mainpage)
        Log.d("Mainpage", "Layout cargado correctamente")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val actual = findViewById<TextView>(R.id.actual)
        val pRecord = findViewById<TextView>(R.id.record)
        val prefs = getSharedPreferences("MisDatos", MODE_PRIVATE)
        val editor = prefs.edit()

        var contador = 0
        var numero: Int = 0
        var record: Int = prefs.getInt("puntajeRecord", 0)

        pRecord.text = record.toString()
        
        fun random(seleccion: Int){
            findViewById<TextView>(R.id.numero).text = numero.toString()
            numero = Random.nextInt(1,6)
            if (seleccion == numero){
                contador += 10
                actual.text = contador.toString()
                if (contador > record){
                    record = contador
                    pRecord.text = record.toString()
                    editor.putInt("puntajeRecord", record)
                    editor.apply()
                }
            }else{
                contador = 0
                actual.text = "0"
            }
        }

        val boton1= findViewById<Button>(R.id.button1)
        val boton2= findViewById<Button>(R.id.button2)
        val boton3= findViewById<Button>(R.id.button3)
        val boton4= findViewById<Button>(R.id.button4)
        val boton5= findViewById<Button>(R.id.button5)

        boton1.setOnClickListener{
            random(1)
        }
        boton2.setOnClickListener{
            random(2)
        }
        boton3.setOnClickListener{
            random(3)
        }
        boton4.setOnClickListener{
            random(4)
        }
        boton5.setOnClickListener{
            random(5)
        }
    }

}