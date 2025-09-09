package uz.mrx.doppigramm.presentation.direction.main.impl

import uz.mrx.doppigramm.presentation.direction.main.MainScreenDirection
import uz.mrx.doppigramm.presentation.navigation.Navigator
import uz.mrx.doppigramm.presentation.ui.screen.fragment.main.MainScreenDirections
import javax.inject.Inject

class MainScreenDirectionImpl @Inject constructor(private val navigator: Navigator):MainScreenDirection {

    override suspend fun openContactScreen() {
        navigator.navigateTo(MainScreenDirections.actionMainScreenToContactScreen())
    }

    override suspend fun openUserChatScreen() {
        navigator.navigateTo(MainScreenDirections.actionMainScreenToUserChatScreen())
    }
}