package uz.mrx.doppigramm.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import uz.mrx.doppigramm.data.remote.response.chat.ChatResponse
import uz.mrx.doppigramm.data.remote.response.chat.ContactResponse

interface ChatApi {

    @GET("/users/list/")
    suspend fun getUserList():Response<List<ContactResponse>>

    @GET("/chats/")
    suspend fun getChats():Response<List<ChatResponse>>

}