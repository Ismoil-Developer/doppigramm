package uz.mrx.doppigramm.data.remote.response.auth

data class LoginResponse(
    val refresh: String,
    val access: String,
    val user: User
)


