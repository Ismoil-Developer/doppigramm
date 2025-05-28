package uz.mrx.doppigramm.data.model

data class ChatMessage(
    val senderId: Int,
    val message: String,
    val timestamp: String // Vaqtni saqlash uchun yangi maydon
)
