package uz.mrx.doppigramm.presentation.ui.viewmodel.confirm.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.mrx.doppigramm.presentation.direction.confirm.ConfirmScreenDirection
import uz.mrx.doppigramm.presentation.ui.viewmodel.confirm.ConfirmScreenViewModel
import javax.inject.Inject

@HiltViewModel
class ConfirmScreenViewModelImpl @Inject constructor(
    private val direction: ConfirmScreenDirection,
) : ConfirmScreenViewModel, ViewModel() {

    override fun openScreen() {
        viewModelScope.launch {
            direction.openMainScreen()
        }
    }

}