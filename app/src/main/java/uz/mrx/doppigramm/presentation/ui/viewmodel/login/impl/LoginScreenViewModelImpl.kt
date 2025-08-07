package uz.mrx.doppigramm.presentation.ui.viewmodel.login.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.mrx.doppigramm.presentation.direction.login.LoginScreenDirection
import uz.mrx.doppigramm.presentation.ui.viewmodel.login.LoginScreenViewModel
import javax.inject.Inject

@HiltViewModel
class LoginScreenViewModelImpl @Inject constructor(private val direction:LoginScreenDirection):LoginScreenViewModel, ViewModel() {

    override fun openFirstProfileScreen() {
        viewModelScope.launch {
            direction.openFirstProfileScreen()
        }
    }

}