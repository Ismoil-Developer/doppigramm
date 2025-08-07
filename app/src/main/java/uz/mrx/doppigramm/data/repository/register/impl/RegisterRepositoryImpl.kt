package uz.mrx.doppigramm.data.repository.register.impl

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.channelFlow
import uz.mrx.doppigramm.data.remote.api.RegisterApi
import uz.mrx.doppigramm.data.remote.request.auth.LoginRequest
import uz.mrx.doppigramm.data.remote.request.auth.RegisterRequest
import uz.mrx.doppigramm.data.remote.response.auth.LoginResponse
import uz.mrx.doppigramm.data.remote.response.auth.RegisterResponse
import uz.mrx.doppigramm.data.repository.register.RegisterRepository
import uz.mrx.doppigramm.utils.ResultData
import javax.inject.Inject

class RegisterRepositoryImpl @Inject constructor(private val api: RegisterApi):RegisterRepository {

    override suspend fun postRegister(request: RegisterRequest) = channelFlow<ResultData<RegisterResponse>> {
        try {
            val response = api.postRegister(request)
            if (response.isSuccessful) {
                val baseResponse = response.body()
                if (baseResponse != null) {
                    send(ResultData.success(baseResponse))
                } else {
                    send(ResultData.messageText("Unknown error"))
                }
            } else {
                val errorMessage = response.errorBody()?.string() ?: "Device failed"
                send(ResultData.error(Throwable(errorMessage)))
            }
        } catch (e: Exception) {
            send(ResultData.error(e))
        }
    }.catch { emit(ResultData.error(it)) }

    override suspend fun postLogin(request: LoginRequest) = channelFlow<ResultData<LoginResponse>> {
        try {
            val response = api.postLogin(request)
            if (response.isSuccessful) {
                val baseResponse = response.body()
                if (baseResponse != null) {
                    send(ResultData.success(baseResponse))
                } else {
                    send(ResultData.messageText("Unknown error"))
                }
            } else {
                val errorMessage = response.errorBody()?.string() ?: "Device failed"
                send(ResultData.error(Throwable(errorMessage)))
            }
        } catch (e: Exception) {
            send(ResultData.error(e))
        }
    }.catch { emit(ResultData.error(it)) }

}