package uz.mrx.doppigramm.data.repository.chat.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.mrx.doppigramm.data.remote.api.ChatApi
import uz.mrx.doppigramm.data.remote.response.chat.ChatResponse
import uz.mrx.doppigramm.data.remote.response.chat.ContactResponse
import uz.mrx.doppigramm.data.repository.chat.ChatRepository
import uz.mrx.doppigramm.utils.ResultData
import javax.inject.Inject

class ChatRepositoryImpl @Inject constructor(private val api: ChatApi): ChatRepository {

    override suspend fun getUserList(): Flow<ResultData<List<ContactResponse>>> = flow {
        try {
            val response = api.getUserList()

            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    emit(ResultData.success(body))
                } else {
                    emit(ResultData.error(Throwable("Empty response body")))
                }
            } else {
                emit(ResultData.error(Throwable(response.message())))
            }
        } catch (e: Exception) {
            emit(ResultData.error(e))
        }
    }

    override suspend fun getChatList(): Flow<ResultData<List<ChatResponse>>> = flow {
        try {
            val response = api.getChats()

            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) {
                    emit(ResultData.success(body))
                } else {
                    emit(ResultData.error(Throwable("Empty response body")))
                }
            } else {
                emit(ResultData.error(Throwable(response.message())))
            }
        } catch (e: Exception) {
            emit(ResultData.error(e))
        }
    }

}