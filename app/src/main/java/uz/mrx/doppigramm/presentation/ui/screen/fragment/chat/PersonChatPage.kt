package uz.mrx.doppigramm.presentation.ui.screen.fragment.chat

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.mrx.doppigramm.R
import uz.mrx.doppigramm.databinding.PagePersonChatBinding
import uz.mrx.doppigramm.presentation.adapter.PersonChatAdapter
import uz.mrx.doppigramm.presentation.ui.viewmodel.chat.PersonChatPageViewModel
import uz.mrx.doppigramm.presentation.ui.viewmodel.chat.impl.PersonChatPageViewModelImpl

@AndroidEntryPoint
class PersonChatPage : Fragment(R.layout.page_person_chat) {

    private val binding: PagePersonChatBinding by viewBinding(PagePersonChatBinding::bind)

    private val viewModel: PersonChatPageViewModel by viewModels<PersonChatPageViewModelImpl>()

    lateinit var adapter: PersonChatAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = PersonChatAdapter {
            viewModel.openChatLichkaScreen()
        }


        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.responseChatList.collectLatest {
                adapter.submitList(it)
            }
        }

        binding.personRv.adapter = adapter

    }

}