package com.jhoanna.mispequeossaltamontes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ActivityAyuda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda)

        val btnAtras: Button = findViewById(R.id.btnAtras)
        btnAtras.setOnClickListener{isFinish()}
    }

    private fun isFinish(){
        finish()
    }

    }