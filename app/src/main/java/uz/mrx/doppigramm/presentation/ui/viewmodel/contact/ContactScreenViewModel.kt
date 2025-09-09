package uz.mrx.doppigramm.presentation.ui.viewmodel.contact

import kotlinx.coroutines.flow.Flow
import uz.mrx.doppigramm.data.remote.response.chat.ContactResponse

interface ContactScreenViewModel {

    fun openContactScreen()

    val userResponseList: Flow<List<ContactResponse>>

}