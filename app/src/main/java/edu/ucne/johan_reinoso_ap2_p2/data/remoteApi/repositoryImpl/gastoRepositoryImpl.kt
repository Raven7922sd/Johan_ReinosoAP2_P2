package edu.ucne.johan_reinoso_ap2_p2.data.remoteApi.repositoryImpl

import edu.ucne.johan_reinoso_ap2_p2.data.remoteApi.GastosDataSource
import edu.ucne.johan_reinoso_ap2_p2.data.remoteApi.Resource.Resource
import edu.ucne.johan_reinoso_ap2_p2.domain.model.Gastos
import edu.ucne.johan_reinoso_ap2_p2.domain.repository.GastosRepository
import edu.ucne.johan_reinoso_ap2_p2.local.mapper.toDomain
import edu.ucne.johan_reinoso_ap2_p2.local.mapper.toDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.collections.emptyList

class gastoRepositoryImpl @Inject constructor(
    val remoteDataSource: GastosDataSource
): GastosRepository {

    override suspend fun getGastos(): Flow<List<Gastos>> = flow {
        try {
            when (val result = remoteDataSource.getGastos()) {
                is Resource.Success -> {
                    val list = result.data?.map { dto -> dto.toDomain() } ?: emptyList()
                    emit(list)
                }
                is Resource.Error -> {
                    emit(emptyList())
                }
                else -> {
                    emit(emptyList())
                }
            }
        } catch (e: Exception) {
            emit(emptyList())
        }
    }

    override suspend fun getGastosById(id: Int): Resource<Gastos?> {
        val result = remoteDataSource.getGastoById(id)
        return when (result) {
            is Resource.Success -> {
                val gastos = result.data?.toDomain()
                Resource.Success(gastos)
            }
            is Resource.Error -> {
                Resource.Error(result.message ?: "Error")
            }
            else -> {
                Resource.Error("Error")
            }
        }
    }

    override suspend fun postGastos(gastos: Gastos): Resource<Gastos> {
        val result = remoteDataSource.postGastos(gastos.toDto())
        return when(result){
            is Resource.Success -> {
                val gastos = result.data?.toDomain()
                Resource.Success(gastos)
            }
            is Resource.Error -> {
                Resource.Error("Error al crear el gasto")
            }
            else -> {
                Resource.Error("Error desconocido")
            }
        }
    }

    override suspend fun putGastos(id: Int, gastos: Gastos): Resource<Unit> {
        val result = remoteDataSource.putGastos(id,gastos.toDto())
        return when(result){
            is Resource.Success -> {
                Resource.Success(Unit)
            }
            is Resource.Error -> {
                Resource.Error("Error al actualizar el gasto")
            }
            else -> Resource.Error("Error desconocido")
        }
    }

    override suspend fun deleteGastos(id: Int): Resource<Unit> {
        val result = remoteDataSource.deleteGasto(id)
        return when(result) {
            is Resource.Success -> {
                Resource.Success(Unit)
            }
            is Resource.Error -> {
                Resource.Error("Error al eliminar el gasto")
            }
            else -> Resource.Error("Error desconocido")
        }
    }

}