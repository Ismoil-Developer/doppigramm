package uz.mrx.doppigramm.presentation.ui.viewmodel.chat

import kotlinx.coroutines.flow.Flow
import uz.mrx.doppigramm.data.remote.response.chat.ChatResponse

interface PersonChatPageViewModel  {

    fun openChatLichkaScreen()

    val responseChatList:Flow<List<ChatResponse>>

}