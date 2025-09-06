package uz.mrx.doppigramm.presentation.ui.viewmodel.login

import kotlinx.coroutines.flow.Flow
import uz.mrx.doppigramm.data.remote.request.auth.LoginRequest
import uz.mrx.doppigramm.data.remote.response.auth.LoginResponse

interface LoginScreenViewModel {

    fun openFirstProfileScreen()

    fun login(loginRequest: LoginRequest)

    val response:Flow<LoginResponse>
}