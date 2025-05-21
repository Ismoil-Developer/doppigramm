package uz.mrx.doppigramm.presentation.ui.viewmodel.splash.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.mrx.doppigramm.presentation.direction.splash.SplashScreenDirection
import uz.mrx.doppigramm.presentation.ui.viewmodel.splash.SplashScreenViewModel
import javax.inject.Inject


@HiltViewModel
class SplashScreenViewModelImpl @Inject constructor(private val direction: SplashScreenDirection):SplashScreenViewModel, ViewModel() {

    override fun openIntroScreen() {
        viewModelScope.launch {
            delay(2000)
            direction.openIntroScreen()
        }
    }

    override fun openMainScreen() {
        viewModelScope.launch {
            direction.openMainScreen()
        }
    }

}