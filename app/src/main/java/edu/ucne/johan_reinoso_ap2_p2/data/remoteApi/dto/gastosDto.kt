package edu.ucne.johan_reinoso_ap2_p2.data.remoteApi.dto

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class gastosDto(
    val gastosid: Int,
    val fecha: String,
    val suplidor: String,
    val nfc: String,
    val itbis: Int =0,
    val monto: Int =0
)