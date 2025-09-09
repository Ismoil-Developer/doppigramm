package uz.mrx.doppigramm.data.remote.response.auth

data class RegisterResponse(
    val refresh: String,
    val access: String,
    val user: User
)

data class User(
    val id: Int,
    val full_name: String,
    val phone: String
)

