package uz.mrx.doppigramm.data.remote.request.auth

data class LoginRequest(
    val phone:String,
    val password:String
)