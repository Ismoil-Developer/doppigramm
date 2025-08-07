package uz.mrx.doppigramm.presentation.direction.login.impl

import uz.mrx.doppigramm.presentation.direction.login.LoginScreenDirection
import uz.mrx.doppigramm.presentation.navigation.Navigator
import uz.mrx.doppigramm.presentation.ui.screen.fragment.auth.login.LoginScreenDirections
import javax.inject.Inject

class LoginScreenDirectionImpl @Inject constructor(private val navigator: Navigator):LoginScreenDirection {

    override suspend fun openFirstProfileScreen() {
        navigator.navigateTo(LoginScreenDirections.actionLoginScreenToProfileFirstScreen())
    }

}