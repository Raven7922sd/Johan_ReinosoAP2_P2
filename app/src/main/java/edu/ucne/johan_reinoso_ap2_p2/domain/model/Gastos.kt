package edu.ucne.johan_reinoso_ap2_p2.domain.model

class Gastos(
    val gastoid: Int,
    val fecha: String,
    val suplidor: String,
    val nfc: String,
    val itbis: Int =0,
    val monto: Int =0
    ) {
}