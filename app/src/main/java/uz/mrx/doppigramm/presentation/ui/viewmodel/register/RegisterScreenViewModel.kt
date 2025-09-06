package uz.mrx.doppigramm.presentation.ui.viewmodel.register

import kotlinx.coroutines.flow.Flow
import uz.mrx.doppigramm.data.remote.request.auth.RegisterRequest
import uz.mrx.doppigramm.data.remote.response.auth.RegisterResponse


interface RegisterScreenViewModel {

    fun openLoginScreen()

    fun postRegister(request: RegisterRequest)

    val registerResponse:Flow<RegisterResponse>


}