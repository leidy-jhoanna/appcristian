package com.jhoanna.mispequeossaltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.jhoanna.mispequeossaltamontes.clases.Estudiante
import com.jhoanna.mispequeossaltamontes.clases.Operaciones
import java.lang.NumberFormatException

class ActivityRegistrar : AppCompatActivity() {

    var campoNombre:EditText ?= null
    var campoDocumento:EditText ?= null
    var campoEdad:EditText ?= null
    var campoTelefono:EditText ?= null
    var campoDireccion:EditText ?= null

    var campoMateria1:EditText ?= null
    var campoMateria2:EditText ?= null
    var campoMateria3:EditText ?= null
    var campoMateria4:EditText ?= null
    var campoMateria5:EditText ?= null

    var campoNota1:EditText ?= null
    var campoNota2:EditText ?= null
    var campoNota3:EditText ?= null
    var campoNota4:EditText ?= null
    var campoNota5:EditText ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        iniciarComponentes()
    }

    private fun iniciarComponentes() {
        campoNombre = findViewById(R.id.editName)
        campoDocumento = findViewById(R.id.editTextDocument)
        campoEdad = findViewById(R.id.editTextEdad)
        campoTelefono = findViewById(R.id.editTextTelefono)
        campoDireccion = findViewById(R.id.editTextDireccion)

        campoMateria1 = findViewById(R.id.editTextMateria1)
        campoMateria2 = findViewById(R.id.editTextMateria2)
        campoMateria3 = findViewById(R.id.editTextMateria3)
        campoMateria4 = findViewById(R.id.editTextMateria4)
        campoMateria5 = findViewById(R.id.editTextMateria5)

        campoNota1 = findViewById(R.id.editTextNota1)
        campoNota2 = findViewById(R.id.editTextNota2)
        campoNota3 = findViewById(R.id.editTextNota3)
        campoNota4 = findViewById(R.id.editTextNota4)
        campoNota5 = findViewById(R.id.editTextNota5)

        val btnRegistro: Button = findViewById(R.id.registro)
        val btnAtras: Button = findViewById(R.id.menu)

        btnRegistro.setOnClickListener{onClick(1)}
        btnAtras.setOnClickListener{isFinish()}
    }

    private fun isFinish(){
        finish()
    }

    private fun onClick(boton: Int){
        try {
            var estu: Estudiante = Estudiante()
            estu.documento = campoDocumento?.text.toString()
            estu.nombre = campoNombre?.text.toString()
            estu.edad = campoEdad?.text.toString().toInt()
            estu.telefono = campoTelefono?.text.toString()
            estu.direccion = campoDireccion?.text.toString()

            estu.primerMateria = campoMateria1?.text.toString()
            estu.segundaMateria = campoMateria2?.text.toString()
            estu.tercerMateria = campoMateria3?.text.toString()
            estu.cuartaMateria = campoMateria4?.text.toString()
            estu.quintaMateria = campoMateria5?.text.toString()

            estu.primerNota = campoNota1?.text.toString().toDouble()
            estu.segundaNota = campoNota2?.text.toString().toDouble()
            estu.tercerNota = campoNota3?.text.toString().toDouble()
            estu.cuartaNota = campoNota4?.text.toString().toDouble()
            estu.quintaNota = campoNota5?.text.toString().toDouble()

            estu.promedio = Operaciones.calcularPromedio(estu)
            println(estu.promedio)

            if (estu.documento != ""
                && estu.nombre != ""
                && estu.primerMateria != ""
                && estu.segundaMateria != ""
                && estu.tercerMateria != ""
                && estu.cuartaMateria != ""
                && estu.quintaMateria != "") {
                Operaciones.registrarEstudiante(estu)
            }
            Operaciones.imprimirEstudiantes()

            if(estu.primerNota >5
                || estu.segundaNota>5
                || estu.tercerNota>5
                || estu.cuartaNota>5
                || estu.quintaNota>5){
                Toast.makeText(this,
                    "Las notas no pueden ser mayores a 5", Toast.LENGTH_LONG).show()

            } else if(estu.primerNota >0
                || estu.segundaNota>0
                || estu.tercerNota>0
                || estu.cuartaNota>0
                || estu.quintaNota>0) {
                Toast.makeText(
                    this,
                    "Las notas no pueden ser negativos", Toast.LENGTH_LONG
                ).show()
            } else if (estu.nombre.isNullOrBlank()
                || estu.documento.isNullOrBlank()
                || estu.telefono.isNullOrBlank()
                || estu.direccion.isNullOrBlank()
                || estu.primerMateria.isNullOrBlank()
                || estu.segundaMateria.isNullOrBlank()
                || estu.tercerMateria.isNullOrBlank()
                || estu.cuartaMateria.isNullOrBlank()
                || estu.quintaMateria.isNullOrBlank()){
                Toast.makeText(this,
                    "rellene los campos", Toast.LENGTH_LONG).show()

            }else {
                var mensajes = ""
                if (estu.promedio >= 3.5) {
                    mensajes = "Usted ganó el periodo"

                } else if (estu.promedio > 2.5 && estu.promedio < 3.5) {
                    mensajes = "Usted perdió el periodo pero puede recuperar"

                } else {
                    mensajes = "Usted perdió el periodo"
                }
                estu.resFinal = mensajes

                when (boton) {
                    1 -> {
                        val intent = Intent(this, ActivityInformacion::class.java)
                        var miBundle: Bundle = Bundle()
                        miBundle.putString("Nombre", estu.nombre)
                        miBundle.putString("Documento", estu.documento)
                        miBundle.putInt("Edad", estu.edad)
                        miBundle.putString("Telefono", estu.telefono)
                        miBundle.putString("Direccion", estu.direccion)

                        miBundle.putString("Materia1", estu.primerMateria)
                        miBundle.putString("Materia2", estu.segundaMateria)
                        miBundle.putString("Materia3", estu.tercerMateria)
                        miBundle.putString("Materia4", estu.cuartaMateria)
                        miBundle.putString("Materia5", estu.quintaMateria)

                        miBundle.putDouble("Nota1", estu.primerNota)
                        miBundle.putDouble("Nota2", estu.segundaNota)
                        miBundle.putDouble("Nota3", estu.tercerNota)
                        miBundle.putDouble("Nota4", estu.cuartaNota)
                        miBundle.putDouble("Nota5", estu.quintaNota)

                        miBundle.putDouble("Promedio", estu.promedio)
                        miBundle.putString("Mensaje", mensajes)

                        intent.putExtras(miBundle)
                        startActivity(intent)
                    }
                }
            }
        } catch (e:NumberFormatException){
            Toast.makeText(this,
                "rellene los campos", Toast.LENGTH_LONG).show()
        }
    }
}
