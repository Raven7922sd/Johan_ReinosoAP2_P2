package edu.ucne.johan_reinoso_ap2_p2.domain.usecase

import edu.ucne.johan_reinoso_ap2_p2.domain.repository.GastosRepository
import javax.inject.Inject

class GetGastosUseCase @Inject constructor(
    val repository: GastosRepository
) {
    suspend operator fun invoke() = repository.getGastos()
}