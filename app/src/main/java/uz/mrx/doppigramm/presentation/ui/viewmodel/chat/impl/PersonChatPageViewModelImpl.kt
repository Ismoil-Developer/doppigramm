package uz.mrx.doppigramm.presentation.ui.viewmodel.chat.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.mrx.doppigramm.data.remote.response.chat.ChatResponse
import uz.mrx.doppigramm.domain.usecase.chat.ChatUseCase
import uz.mrx.doppigramm.presentation.direction.main.MainScreenDirection
import uz.mrx.doppigramm.presentation.ui.viewmodel.chat.PersonChatPageViewModel
import uz.mrx.doppigramm.utils.flow
import javax.inject.Inject

@HiltViewModel
class PersonChatPageViewModelImpl @Inject constructor( private val direction: MainScreenDirection, private val useCase: ChatUseCase):PersonChatPageViewModel, ViewModel() {

    override fun openChatLichkaScreen() {
        viewModelScope.launch {
            direction.openUserChatScreen()
        }
    }

    override val responseChatList = flow<List<ChatResponse>>()


    init {
        viewModelScope.launch {
            useCase.getChatList().collectLatest {
                it.onSuccess {
                    responseChatList.tryEmit(it)
                }
                it.onError {  }
            }
        }
    }

}