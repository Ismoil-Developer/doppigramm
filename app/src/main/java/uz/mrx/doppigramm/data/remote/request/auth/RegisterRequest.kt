package uz.mrx.doppigramm.data.remote.request.auth

data class RegisterRequest(
    val full_name:String,
    val phone:String,
    val password:String,
    val password_confirmation:String
)