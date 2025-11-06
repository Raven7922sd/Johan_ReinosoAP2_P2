package edu.ucne.johan_reinoso_ap2_p2.local.presentation

import edu.ucne.johan_reinoso_ap2_p2.domain.model.Gastos

data class GastosUiState (
    val isLoading: Boolean = false,
    val isDeleting: Boolean = false,
    val canBeDelete: Boolean = false,
    val userMessage: String? = null,
    val showSheet: Boolean = false,
    val gastos: List<Gastos> = emptyList(),
    val id: Int = 0,
    val fecha: String = "",
    val suplidor: String = "",
    val nfc: String = "",
    val itbis: Int =0,
    val monto: Int =0,
)