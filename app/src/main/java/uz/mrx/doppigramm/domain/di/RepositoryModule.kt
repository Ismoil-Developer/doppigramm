package uz.mrx.doppigramm.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.mrx.doppigramm.data.repository.chat.ChatRepository
import uz.mrx.doppigramm.data.repository.chat.impl.ChatRepositoryImpl
import uz.mrx.doppigramm.data.repository.register.RegisterRepository
import uz.mrx.doppigramm.data.repository.register.impl.RegisterRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindRegisterRepository(impl: RegisterRepositoryImpl): RegisterRepository

    @[Binds Singleton]
    fun bindChatRepository(impl: ChatRepositoryImpl): ChatRepository


}