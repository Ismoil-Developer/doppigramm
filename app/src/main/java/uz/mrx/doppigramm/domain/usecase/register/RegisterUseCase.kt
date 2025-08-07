package uz.mrx.doppigramm.domain.usecase.register

import kotlinx.coroutines.flow.Flow
import uz.mrx.doppigramm.data.remote.request.auth.LoginRequest
import uz.mrx.doppigramm.data.remote.request.auth.RegisterRequest
import uz.mrx.doppigramm.data.remote.response.auth.LoginResponse
import uz.mrx.doppigramm.data.remote.response.auth.RegisterResponse
import uz.mrx.doppigramm.utils.ResultData

interface RegisterUseCase {

    suspend fun postRegister(request: RegisterRequest): Flow<ResultData<RegisterResponse>>

    suspend fun postLogin(request: LoginRequest): Flow<ResultData<LoginResponse>>

}