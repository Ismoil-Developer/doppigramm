package uz.mrx.doppigramm.presentation.ui.viewmodel.register.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.mrx.doppigramm.data.remote.request.auth.RegisterRequest
import uz.mrx.doppigramm.data.remote.response.auth.RegisterResponse
import uz.mrx.doppigramm.domain.usecase.register.RegisterUseCase
import uz.mrx.doppigramm.presentation.direction.register.RegisterScreenDirection
import uz.mrx.doppigramm.presentation.ui.viewmodel.register.RegisterScreenViewModel
import uz.mrx.doppigramm.utils.flow
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewModelImpl @Inject constructor(
    private val direction: RegisterScreenDirection,
    private val useCase: RegisterUseCase
) : RegisterScreenViewModel, ViewModel() {

    override fun openLoginScreen() {
        viewModelScope.launch {
            direction.openLoginScreen()
        }
    }

    override fun postRegister(request: RegisterRequest) {
        viewModelScope.launch {
            useCase.postRegister(request).collectLatest {
                it.onError {

                }
                it.onSuccess {
                    registerResponse.tryEmit(it)
                }
            }
        }
    }

    override val registerResponse = flow<RegisterResponse>()

}