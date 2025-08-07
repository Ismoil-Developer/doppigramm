package uz.mrx.doppigramm.data.remote.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.mrx.doppigramm.data.remote.request.auth.LoginRequest
import uz.mrx.doppigramm.data.remote.request.auth.RegisterRequest
import uz.mrx.doppigramm.data.remote.response.auth.LoginResponse
import uz.mrx.doppigramm.data.remote.response.auth.RegisterResponse

interface RegisterApi {

    @POST("/register/")
    suspend fun postRegister(@Body request: RegisterRequest):Response<RegisterResponse>

    @POST("/login/")
    suspend fun postLogin(@Body request: LoginRequest):Response<LoginResponse>

}