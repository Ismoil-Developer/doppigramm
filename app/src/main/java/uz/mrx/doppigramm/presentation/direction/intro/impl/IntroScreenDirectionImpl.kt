package uz.mrx.doppigramm.presentation.direction.intro.impl

import uz.mrx.doppigramm.presentation.direction.intro.IntroScreenDirection
import uz.mrx.doppigramm.presentation.navigation.Navigator
import uz.mrx.doppigramm.presentation.ui.screen.fragment.intro.IntroScreenDirections
import javax.inject.Inject

class IntroScreenDirectionImpl @Inject constructor(private val navigator: Navigator):
    IntroScreenDirection {

    override suspend fun openLoginScreen() {
        navigator.navigateTo(IntroScreenDirections.actionIntroScreenToLoginScreen())
    }

}