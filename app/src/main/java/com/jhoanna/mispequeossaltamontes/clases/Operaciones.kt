package com.jhoanna.mispequeossaltamontes.clases
import java.io.Serializable

class Operaciones: Serializable {
    companion object {
        var listaEstudiante = arrayListOf<Estudiante>()

        fun registrarEstudiante(estudiante: Estudiante) {
            listaEstudiante.add(estudiante)
        }

        fun imprimirEstudiantes() {
            for (estu in listaEstudiante) {
                println("\n\n${estu}\n\n")
            }
        }

        fun calcularPromedio(estu: Estudiante):Double {
            var prom = (estu.primerNota + estu.segundaNota
                    + estu.tercerNota + estu.cuartaNota + estu.quintaNota) / 5

            return prom
        }
    }

}