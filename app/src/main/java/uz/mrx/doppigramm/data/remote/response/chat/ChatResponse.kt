package uz.mrx.doppigramm.data.remote.response.chat

data class ChatResponse(
    val id: Int,
    val user: User,
    val last_message: LastMessage,
    val created_at: String
)

data class User(
    val id: Int,
    val full_name: String,
    val avatar: String?
)

data class LastMessage(
    val text: String,
    val timestamp: String,
    val sender_id: Int,
    val is_read: Boolean
)
