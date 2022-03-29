package com.jhoanna.mispequeossaltamontes.clases

import java.io.Serializable

class Estudiante : Serializable{
    var documento:String = ""
    var nombre:String= ""
    var edad:Int = 0
    var telefono:String = ""
    var direccion:String = ""

    var primerMateria:String = ""
    var segundaMateria:String = ""
    var tercerMateria:String = ""
    var cuartaMateria:String = ""
    var quintaMateria:String = ""

    var primerNota:Double = 0.0
    var segundaNota:Double = 0.0
    var tercerNota:Double = 0.0
    var cuartaNota:Double = 0.0
    var quintaNota:Double = 0.0

    var promedio:Double = 0.0
    var resFinal:String ?= null

    override fun toString(): String {
        return "Estudiante(documento='$documento', nombre='$nombre'," +
                "edad='$edad', telefoo='$telefono', direccion='$direccion'," +
                "primerMateria='$primerMateria', segundaMateria='$segundaMateria'," +
                "tercerMateria='$tercerMateria', cuartaMateria='$cuartaMateria'" +
                "quintaMateria='$quintaMateria', nota1='$primerNota', nota2='$segundaNota'," +
                "nota3='$tercerNota', nota4='$cuartaNota', nota5='$quintaNota'," +
                "promedio='$promedio')"
    }
}