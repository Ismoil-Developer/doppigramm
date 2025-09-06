package uz.mrx.doppigramm.presentation.ui.screen.fragment.chat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.mrx.doppigramm.R
import uz.mrx.doppigramm.databinding.PagePersonChatBinding
import uz.mrx.doppigramm.presentation.ui.viewmodel.chat.PersonChatPageViewModel
import uz.mrx.doppigramm.presentation.ui.viewmodel.chat.impl.PersonChatPageViewModelImpl

@AndroidEntryPoint
class PersonChatPage:Fragment(R.layout.page_person_chat) {

    private val binding:PagePersonChatBinding by viewBinding(PagePersonChatBinding::bind)
    private val viewModel:PersonChatPageViewModel by viewModels<PersonChatPageViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




    }

}