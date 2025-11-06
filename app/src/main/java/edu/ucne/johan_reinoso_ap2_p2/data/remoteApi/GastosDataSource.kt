package edu.ucne.johan_reinoso_ap2_p2.data.remoteApi

import edu.ucne.johan_reinoso_ap2_p2.data.remoteApi.Resource.Resource
import edu.ucne.johan_reinoso_ap2_p2.data.remoteApi.dto.gastosDto
import javax.inject.Inject

class GastosDataSource @Inject constructor(
    private val api: GastosApiService
) {
    suspend fun getGastos(): Resource<List<gastosDto>> {
        return try {
            val response = api.getGastos()
            if (response.isSuccessful) {
                response.body().let { Resource.Success(it) }
                    ?: Resource.Error("Respuesta inválida")
            } else {
                return Resource.Error("Error ${response.code()}: ${response.message()}")
            }
        } catch (e: Exception) {
            return Resource.Error("Error: ${e.localizedMessage ?: "Ocurrió un error"}")
        }
    }

    suspend fun getGastoById(id: Int): Resource<gastosDto> {
        return try{
            val response = api.getGastosById(id)
            if(response.isSuccessful){
                response.body().let { Resource.Success(it)}
                    ?: Resource.Error("Respuesta inválida")
            }else{
                return Resource.Error("Error ${response.code()}: ${response.message()}")
            }
        }catch (e: Exception) {
            return Resource.Error("Error: ${e.localizedMessage ?: "Ocurrió un error"}")
        }
    }

    suspend fun postGastos(gastosDto: gastosDto): Resource<gastosDto> {
        return try {
            val response = api.postGastos(gastosDto)
            if(response.isSuccessful){
                response.body().let { Resource.Success(it) }
                    ?: Resource.Error("Respuesta inválida")
            }else{
                Resource.Error("Error ${response.code()}: ${response.message()}")
            }
        }catch (e: Exception){
            return Resource.Error("Error: ${e.localizedMessage ?: "Ocurrió un error"}")
        }
    }

    suspend fun putGastos(id: Int, gastosDto: gastosDto): Resource<Unit> {
        return try {
            val response = api.putGastos(id, gastosDto)
            if(response.isSuccessful){
                Resource.Success(Unit)
            }else{
                Resource.Error("Error ${response.code()}: ${response.message()}")
            }
        }catch (e: Exception){
            return Resource.Error("Error: ${e.localizedMessage ?: "Ocurrió un error"}")
        }
    }

    suspend fun deleteGasto(id: Int): Resource<Unit> {
        return try{
            val response = api.deleteGastos(id)
            if(response.isSuccessful){
                Resource.Success(Unit)
            }else{
                Resource.Error("Error ${response.code()}: ${response.message()}")
            }
        }catch(e: Exception){
            return Resource.Error("Error: ${e.localizedMessage ?: "Ocurrió un error"}")
        }
    }
}