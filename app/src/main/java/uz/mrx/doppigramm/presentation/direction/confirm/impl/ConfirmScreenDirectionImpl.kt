package uz.mrx.doppigramm.presentation.direction.confirm.impl

import uz.mrx.doppigramm.presentation.navigation.Navigator
import uz.mrx.doppigramm.presentation.direction.confirm.ConfirmScreenDirection
import uz.mrx.doppigramm.presentation.ui.screen.fragment.auth.confirm.ConfirmScreenDirections
import javax.inject.Inject

class ConfirmScreenDirectionImpl @Inject constructor(
    private val navigator: Navigator
) : ConfirmScreenDirection {

    override suspend fun openMainScreen() {
        navigator.navigateTo(ConfirmScreenDirections.actionConfirmScreenToProfileFirstScreen())
    }

}