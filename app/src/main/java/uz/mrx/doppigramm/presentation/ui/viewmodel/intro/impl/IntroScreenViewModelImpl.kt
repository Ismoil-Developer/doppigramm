package uz.mrx.doppigramm.presentation.ui.viewmodel.intro.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.mrx.doppigramm.presentation.direction.intro.IntroScreenDirection
import uz.mrx.doppigramm.presentation.ui.viewmodel.intro.IntroScreenViewModel
import javax.inject.Inject

@HiltViewModel
class IntroScreenViewModelImpl @Inject constructor(private val direction: IntroScreenDirection):IntroScreenViewModel, ViewModel() {

    override fun openLoginScreen() {
        viewModelScope.launch {
            direction.openLoginScreen()
        }
    }

}