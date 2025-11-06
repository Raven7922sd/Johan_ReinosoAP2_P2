package edu.ucne.johan_reinoso_ap2_p2.data.remoteApi

import edu.ucne.johan_reinoso_ap2_p2.data.remoteApi.dto.gastosDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface GastosApiService {
    @GET("api/Gastos")
    suspend fun getGastos(): Response<List<gastosDto>>

    @GET("api/Gastos/{id}")
    suspend fun getGastosById(@Path("id") id: Int): Response<gastosDto>

    @POST("api/Gastos")
    suspend fun postGastos(@Body gastoDto: gastosDto): Response<gastosDto>

    @PUT("api/Gastos/{id}")
    suspend fun putGastos(@Path("id") id: Int, @Body gastosDto: gastosDto): Response<Unit>

    @DELETE("api/Gastos/{id}")
    suspend fun deleteGastos(@Path("id") id: Int): Response<Unit>
}