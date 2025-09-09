package uz.mrx.doppigramm.data.repository.chat

import kotlinx.coroutines.flow.Flow
import uz.mrx.doppigramm.data.remote.response.auth.LoginResponse
import uz.mrx.doppigramm.data.remote.response.chat.ChatResponse
import uz.mrx.doppigramm.data.remote.response.chat.ContactResponse
import uz.mrx.doppigramm.utils.ResultData

interface ChatRepository {

    suspend fun getUserList(): Flow<ResultData<List<ContactResponse>>>

    suspend fun getChatList():Flow<ResultData<List<ChatResponse>>>

}