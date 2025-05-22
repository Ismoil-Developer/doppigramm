package uz.mrx.doppigramm.presentation.ui.screen.chat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.mrx.doppigramm.R
import uz.mrx.doppigramm.databinding.ScreenUserChatBinding

@AndroidEntryPoint
class UserChatScreen:Fragment(R.layout.screen_user_chat) {

    private val binding:ScreenUserChatBinding by viewBinding(ScreenUserChatBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

}