package uz.mrx.doppigramm.presentation.ui.screen.fragment.chat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.mrx.doppigramm.R
import uz.mrx.doppigramm.databinding.ScreenUserChatBinding
import uz.mrx.doppigramm.presentation.ui.viewmodel.chat.UserChatScreenViewModel
import uz.mrx.doppigramm.presentation.ui.viewmodel.chat.impl.UserChatScreenViewModelImpl

@AndroidEntryPoint
class UserChatScreen:Fragment(R.layout.screen_user_chat) {

    private val binding:ScreenUserChatBinding by viewBinding(ScreenUserChatBinding::bind)
    private val viewModel:UserChatScreenViewModel by viewModels<UserChatScreenViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }

}