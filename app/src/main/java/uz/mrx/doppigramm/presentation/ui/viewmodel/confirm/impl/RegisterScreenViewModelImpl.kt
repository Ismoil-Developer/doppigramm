package uz.mrx.doppigramm.presentation.ui.viewmodel.confirm.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.mrx.doppigramm.presentation.direction.register.RegisterScreenDirection
import uz.mrx.doppigramm.presentation.ui.viewmodel.confirm.RegisterScreenViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterScreenViewModelImpl @Inject constructor(
    private val direction: RegisterScreenDirection,
) : RegisterScreenViewModel, ViewModel() {

    override fun openLoginScreen() {
        viewModelScope.launch {
            direction.openLoginScreen()
        }
    }

}