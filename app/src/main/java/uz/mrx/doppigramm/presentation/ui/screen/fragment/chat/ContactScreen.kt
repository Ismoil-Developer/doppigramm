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
import uz.mrx.doppigramm.databinding.ScreenContactBinding
import uz.mrx.doppigramm.presentation.adapter.ContactAdapter
import uz.mrx.doppigramm.presentation.ui.viewmodel.contact.ContactScreenViewModel
import uz.mrx.doppigramm.presentation.ui.viewmodel.contact.impl.ContactScreenViewModelImpl

@AndroidEntryPoint
class ContactScreen:Fragment(R.layout.screen_contact) {

    private val binding:ScreenContactBinding by viewBinding(ScreenContactBinding::bind)

    private val viewModel:ContactScreenViewModel by viewModels<ContactScreenViewModelImpl>()

    lateinit var adapter: ContactAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        adapter = ContactAdapter{
            viewModel.openContactScreen()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.userResponseList.collectLatest {
                adapter.submitList(it)
            }
        }

        binding.rvContact.adapter = adapter


    }


}