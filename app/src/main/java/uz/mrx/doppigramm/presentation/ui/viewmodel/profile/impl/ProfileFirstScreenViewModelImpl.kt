package uz.mrx.doppigramm.presentation.ui.viewmodel.profile.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.mrx.doppigramm.presentation.direction.profile.ProfileScreenFirstDirection
import uz.mrx.doppigramm.presentation.ui.viewmodel.profile.ProfileFirstScreenViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileFirstScreenViewModelImpl @Inject constructor(private val direction: ProfileScreenFirstDirection):ProfileFirstScreenViewModel, ViewModel() {

    override fun openMainScreen() {
        viewModelScope.launch {
            direction.openMainScreen()
        }
    }

}