package edu.ucne.johan_reinoso_ap2_p2.local.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.ucne.johan_reinoso_ap2_p2.data.remoteApi.repositoryImpl.gastoRepositoryImpl
import edu.ucne.johan_reinoso_ap2_p2.domain.repository.GastosRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindGastosRepository(
        impl: gastoRepositoryImpl
    ): GastosRepository
}