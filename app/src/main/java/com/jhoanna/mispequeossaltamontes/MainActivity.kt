package com.jhoanna.mispequeossaltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val miBoton: Button =findViewById(R.id.btnRegistrar)
        miBoton.setOnClickListener{onClick(1)}

        val miBoton2: Button =findViewById(R.id.btnEstaditica2)
        miBoton2.setOnClickListener{onClick(2)}

        val miBoton3: Button =findViewById(R.id.btnAyuda3)
        miBoton3.setOnClickListener{onClick(3)}
    }
    private fun onClick(boton: Int){
        when(boton){

            1 ->{
                val intent = Intent( this, ActivityRegistrar::class.java)
                startActivity(intent)
            }
            2 ->{
                val intent = Intent( this, ActivityEstadistica::class.java)
                startActivity(intent)
            }
            3 ->{
                val intent = Intent( this, ActivityAyuda::class.java)
                startActivity(intent)
            }
        }
    }
}