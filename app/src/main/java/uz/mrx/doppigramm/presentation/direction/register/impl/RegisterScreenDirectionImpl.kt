package uz.mrx.doppigramm.presentation.direction.register.impl

import uz.mrx.doppigramm.presentation.navigation.Navigator
import uz.mrx.doppigramm.presentation.direction.register.RegisterScreenDirection
import uz.mrx.doppigramm.presentation.ui.screen.fragment.auth.register.RegisterScreenDirections
import javax.inject.Inject

class RegisterScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : RegisterScreenDirection {

    override suspend fun openLoginScreen() {
        navigator.navigateTo(RegisterScreenDirections.actionRegisterScreenToLoginScreen())
    }

}