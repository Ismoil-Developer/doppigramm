package uz.mrx.doppigramm.presentation.ui.viewmodel.contact.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.mrx.doppigramm.data.remote.response.chat.ContactResponse
import uz.mrx.doppigramm.domain.usecase.chat.ChatUseCase
import uz.mrx.doppigramm.presentation.direction.contact.ContactScreenDirection
import uz.mrx.doppigramm.presentation.ui.viewmodel.contact.ContactScreenViewModel
import uz.mrx.doppigramm.utils.flow
import javax.inject.Inject


@HiltViewModel
class ContactScreenViewModelImpl @Inject constructor(private val direction: ContactScreenDirection, private val useCase: ChatUseCase,):ContactScreenViewModel, ViewModel(){


    override fun openContactScreen() {
        viewModelScope.launch {
            direction.openChatScreen()
        }
    }

    override val userResponseList = flow<List<ContactResponse>>()


    init {
        viewModelScope.launch {
            useCase.getUserList().collectLatest {
                it.onError {

                }
                it.onSuccess {
                    userResponseList.tryEmit(it)
                }
            }
        }
    }


}