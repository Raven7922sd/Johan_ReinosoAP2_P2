package edu.ucne.johan_reinoso_ap2_p2.local.mapper

import edu.ucne.johan_reinoso_ap2_p2.domain.model.Gastos
import edu.ucne.johan_reinoso_ap2_p2.data.remoteApi.dto.gastosDto

fun Gastos.toDto() : gastosDto = gastosDto (
    gastosid = gastoid,
    fecha=fecha,
    suplidor=suplidor,
    nfc=nfc,
    itbis=itbis,
    monto=monto
)

fun gastosDto.toDomain(): Gastos = Gastos (
    gastoid=gastosid,
    fecha=fecha,
    suplidor=suplidor,
    nfc=nfc,
    itbis=itbis,
    monto=monto
)