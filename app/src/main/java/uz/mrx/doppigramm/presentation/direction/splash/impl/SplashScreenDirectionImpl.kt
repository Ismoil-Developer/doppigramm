package uz.mrx.doppigramm.presentation.direction.splash.impl

import uz.mrx.doppigramm.presentation.direction.splash.SplashScreenDirection
import uz.mrx.doppigramm.presentation.navigation.Navigator
import uz.mrx.doppigramm.presentation.ui.screen.fragment.splash.SplashScreenDirections
import javax.inject.Inject

class SplashScreenDirectionImpl @Inject constructor(private val navigator: Navigator):
    SplashScreenDirection {

    override suspend fun openMainScreen() {
        navigator.navigateTo(SplashScreenDirections.actionSplashScreenToMainScreen())
    }

    override suspend fun openIntroScreen() {
        navigator.navigateTo(SplashScreenDirections.actionSplashScreenToIntroScreen())
    }

}