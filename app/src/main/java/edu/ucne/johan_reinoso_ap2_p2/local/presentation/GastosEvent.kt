package edu.ucne.johan_reinoso_ap2_p2.local.presentation

import edu.ucne.johan_reinoso_ap2_p2.domain.model.Gastos

sealed interface GastosEvent {
    data class loadGasto(val id: Int): GastosEvent
    data class onFechaChanged(val fecha: String): GastosEvent
    data class onsuplidorChanged(val suplidor: String): GastosEvent
    data class onnfcChanged(val nfc: String): GastosEvent
    data class onitbisChanged(val itbis: Int): GastosEvent
    data class onMontoChanged(val monto: Int): GastosEvent
    object saveGasto: GastosEvent
    object deleteGasto: GastosEvent
    object ShowSheet: GastosEvent
    object HideSheet: GastosEvent
    object UserMessageShown: GastosEvent
    data class SelectGasto(val gastos: Gastos) : GastosEvent
}