package uz.mrx.doppigramm.domain.usecase.register.impl

import kotlinx.coroutines.flow.Flow
import uz.mrx.doppigramm.data.remote.request.auth.LoginRequest
import uz.mrx.doppigramm.data.remote.request.auth.RegisterRequest
import uz.mrx.doppigramm.data.remote.response.auth.LoginResponse
import uz.mrx.doppigramm.data.remote.response.auth.RegisterResponse
import uz.mrx.doppigramm.data.repository.register.RegisterRepository
import uz.mrx.doppigramm.domain.usecase.register.RegisterUseCase
import uz.mrx.doppigramm.utils.ResultData
import javax.inject.Inject

class RegisterUseCaseImpl @Inject constructor(private val repository: RegisterRepository) :
    RegisterUseCase {

    override suspend fun postRegister(request: RegisterRequest): Flow<ResultData<RegisterResponse>> =
        repository.postRegister(request)

    override suspend fun postLogin(request: LoginRequest): Flow<ResultData<LoginResponse>> =
        repository.postLogin(request)

}