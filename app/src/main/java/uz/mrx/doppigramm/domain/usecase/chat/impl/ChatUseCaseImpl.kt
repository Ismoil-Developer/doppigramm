package uz.mrx.doppigramm.domain.usecase.chat.impl

import kotlinx.coroutines.flow.Flow
import uz.mrx.doppigramm.data.remote.response.chat.ChatResponse
import uz.mrx.doppigramm.data.remote.response.chat.ContactResponse
import uz.mrx.doppigramm.data.repository.chat.ChatRepository
import uz.mrx.doppigramm.domain.usecase.chat.ChatUseCase
import uz.mrx.doppigramm.utils.ResultData
import javax.inject.Inject

class ChatUseCaseImpl @Inject constructor(private val repository: ChatRepository):ChatUseCase {

    override suspend fun getUserList(): Flow<ResultData<List<ContactResponse>>> = repository.getUserList()

    override suspend fun getChatList(): Flow<ResultData<List<ChatResponse>>> = repository.getChatList()

}