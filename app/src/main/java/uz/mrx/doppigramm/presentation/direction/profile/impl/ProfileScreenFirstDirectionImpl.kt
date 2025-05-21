package uz.mrx.doppigramm.presentation.direction.profile.impl

import uz.mrx.doppigramm.presentation.direction.profile.ProfileScreenFirstDirection
import uz.mrx.doppigramm.presentation.navigation.Navigator
import uz.mrx.doppigramm.presentation.ui.screen.fragment.profile.ProfileFirstScreenDirections
import javax.inject.Inject

class ProfileScreenFirstDirectionImpl @Inject constructor(private val navigator: Navigator):ProfileScreenFirstDirection {
    override suspend fun openMainScreen() {
        navigator.navigateTo(ProfileFirstScreenDirections.actionProfileFirstScreenToMainScreen())
    }
}