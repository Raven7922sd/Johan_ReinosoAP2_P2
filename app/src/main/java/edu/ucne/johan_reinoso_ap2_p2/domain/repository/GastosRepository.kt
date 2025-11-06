package edu.ucne.johan_reinoso_ap2_p2.domain.repository

import edu.ucne.johan_reinoso_ap2_p2.data.remoteApi.Resource.Resource
import edu.ucne.johan_reinoso_ap2_p2.domain.model.Gastos
import kotlinx.coroutines.flow.Flow

interface GastosRepository {
    suspend fun getGastos(): Flow<List<Gastos>>
    suspend fun getGastosById(id: Int): Resource<Gastos?>
    suspend fun postGastos(Gastos: Gastos): Resource<Gastos>
    suspend fun putGastos(id: Int, Gastos: Gastos): Resource<Unit>
    suspend fun deleteGastos(id: Int): Resource<Unit>
}