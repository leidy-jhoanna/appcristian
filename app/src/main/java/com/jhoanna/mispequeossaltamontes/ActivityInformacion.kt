package com.jhoanna.mispequeossaltamontes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class ActivityInformacion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)

        val btnSalir: Button = findViewById(R.id.salir)
        btnSalir.setOnClickListener{onClick()}

        val campoNombre: TextView = findViewById(R.id.resNombre)
        val campoDocumento: TextView= findViewById(R.id.resDocumento)
        val campoEdad: TextView= findViewById(R.id.resEdad)
        val campoTelefono: TextView= findViewById(R.id.resTelefono)
        val campoDireccion: TextView= findViewById(R.id.resDireccion)

        val campoMateria1: TextView= findViewById(R.id.resMateria1)
        val campoMateria2: TextView= findViewById(R.id.resMateria2)
        val campoMateria3: TextView= findViewById(R.id.resMateria3)
        val campoMateria4: TextView= findViewById(R.id.resMateria4)
        val campoMateria5: TextView= findViewById(R.id.resMateria5)

        val campoNota1: TextView= findViewById(R.id.resNota1)
        val campoNota2: TextView= findViewById(R.id.resNota2)
        val campoNota3: TextView= findViewById(R.id.resNota3)
        val campoNota4: TextView= findViewById(R.id.resNota4)
        val campoNota5: TextView= findViewById(R.id.resNota5)
        val campoPromedio: TextView= findViewById(R.id.resPromedio)
        val campoResultado: TextView= findViewById(R.id.resFinal)

        var miBundle: Bundle? = this.intent.extras
        if(miBundle != null){
            campoNombre.text="Nombre: ${miBundle.getString("Nombre")} "
            campoDocumento.text="Documento: ${miBundle.getString("Documento")} "
            campoEdad.text="Edad: ${miBundle.getInt("Edad")} "
            campoTelefono.text="Telefono: ${miBundle.getInt("Telefono")} "
            campoDireccion.text="Direccion: ${miBundle.getString("Direccion")} "

            campoMateria1.text="${miBundle.getString("Materia1")} "
            campoMateria2.text="${miBundle.getString("Materia2")} "
            campoMateria3.text="${miBundle.getString("Materia3")} "
            campoMateria4.text="${miBundle.getString("Materia4")} "
            campoMateria5.text="${miBundle.getString("Materia5")} "

            campoNota1.text="${miBundle.getDouble("Nota1")} "
            campoNota2.text="${miBundle.getDouble("Nota2")} "
            campoNota3.text="${miBundle.getDouble("Nota3")} "
            campoNota4.text="${miBundle.getDouble("Nota4")} "
            campoNota5.text="${miBundle.getDouble("Nota5")} "

            campoPromedio.text="Promedio: ${miBundle.getDouble("Promedio")} "
            campoResultado.text="Resultado Final: ${miBundle.getString("Mensaje")} "
        }else{
            Toast.makeText(this, "Los datos están vacios", Toast.LENGTH_LONG).show()
        }
    }

    private fun onClick(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}