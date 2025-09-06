package uz.mrx.doppigramm.presentation.ui.viewmodel.login.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.mrx.doppigramm.data.remote.request.auth.LoginRequest
import uz.mrx.doppigramm.data.remote.response.auth.LoginResponse
import uz.mrx.doppigramm.domain.usecase.register.RegisterUseCase
import uz.mrx.doppigramm.presentation.direction.login.LoginScreenDirection
import uz.mrx.doppigramm.presentation.ui.viewmodel.login.LoginScreenViewModel
import uz.mrx.doppigramm.utils.flow
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModelImpl @Inject constructor(private val direction:LoginScreenDirection, private val useCase: RegisterUseCase):LoginScreenViewModel, ViewModel() {

    override fun openFirstProfileScreen() {
        viewModelScope.launch {
            direction.openFirstProfileScreen()
        }
    }

    override fun login(loginRequest: LoginRequest) {
        viewModelScope.launch {
            useCase.postLogin(loginRequest).collectLatest {
                it.onSuccess {
                    response.tryEmit(it)

                }
                it.onError {

                }
            }
        }
    }

    override val response = flow<LoginResponse>()

}