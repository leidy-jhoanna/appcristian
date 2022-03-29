package com.jhoanna.mispequeossaltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.jhoanna.mispequeossaltamontes.clases.Operaciones

class ActivityEstadistica : AppCompatActivity() {

    var campoProcesados: TextView?=null
    var campoGanan: TextView?=null
    var campoPierden: TextView?=null
    var campoRecuperan: TextView?=null

    var lista = Operaciones.listaEstudiante

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estadistica)

        iniciarComponentes()

        var btnSalir: Button = findViewById(R.id.salir)
        btnSalir.setOnClickListener{salir()}
        }

    private fun iniciarComponentes(){

        var cantidadTotal = lista.size
        var cantidadGanados:Int = totalGanadores()
        var cantidadPerdedores:Int = totalPerdedores()
        var cantidadRecuperacion:Int = totalRecuperacion()

        campoProcesados = findViewById(R.id.textProcesados)
        campoGanan = findViewById(R.id.textGanan)
        campoPierden = findViewById(R.id.textPierden)
        campoRecuperan = findViewById(R.id.textRecuperan)

        campoProcesados?.text = "$cantidadTotal"
        campoGanan?.text = "$cantidadGanados"
        campoPierden?.text = "$cantidadPerdedores"
        campoRecuperan?.text = "$cantidadRecuperacion"

    }

    private fun totalRecuperacion(): Int {
        var cantidad = 0
        for (est in lista){
            if (est.resFinal.equals("Usted perdió el periodo pero puede recuperar")){
                cantidad =+ 1
            }
        }
        return cantidad
    }

    private fun totalPerdedores(): Int {
        var cantidad = 0
        for (est in lista){
            if (est.resFinal.equals("Usted perdió el periodo")){
                cantidad =+ 1
            }
        }
        return cantidad
    }

    private fun totalGanadores(): Int {
        var cantidad = 0
        for (est in lista){
            if (est.resFinal.equals("Usted ganó el periodo")){
                cantidad = cantidad + 1
            }
        }
        return cantidad
    }


    private fun salir(){
        var intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}