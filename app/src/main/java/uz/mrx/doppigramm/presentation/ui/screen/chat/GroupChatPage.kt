package uz.mrx.doppigramm.presentation.ui.screen.chat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.mrx.doppigramm.R
import uz.mrx.doppigramm.databinding.PageGroupChatBinding

@AndroidEntryPoint
class GroupChatPage:Fragment(R.layout.page_group_chat) {

    private val binding:PageGroupChatBinding by viewBinding(PageGroupChatBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}