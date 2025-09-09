package uz.mrx.doppigramm.domain.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import uz.mrx.doppigramm.domain.usecase.chat.ChatUseCase
import uz.mrx.doppigramm.domain.usecase.chat.impl.ChatUseCaseImpl
import uz.mrx.doppigramm.domain.usecase.register.RegisterUseCase
import uz.mrx.doppigramm.domain.usecase.register.impl.RegisterUseCaseImpl

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    @Binds
    fun bindRegisterUseCase(impl: RegisterUseCaseImpl): RegisterUseCase

    @Binds
    fun bindChatUseCase(impl: ChatUseCaseImpl): ChatUseCase

}