package uz.mrx.doppigramm.presentation.ui.screen.fragment.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.mrx.doppigramm.R
import uz.mrx.doppigramm.databinding.ScreenProfileFirstBinding
import uz.mrx.doppigramm.presentation.ui.viewmodel.profile.ProfileFirstScreenViewModel
import uz.mrx.doppigramm.presentation.ui.viewmodel.profile.impl.ProfileFirstScreenViewModelImpl

@AndroidEntryPoint
class ProfileFirstScreen:Fragment(R.layout.screen_profile_first) {

    private val binding:ScreenProfileFirstBinding by viewBinding(ScreenProfileFirstBinding::bind)

    private val viewModel:ProfileFirstScreenViewModel by viewModels<ProfileFirstScreenViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.icNext.setOnClickListener {
            viewModel.openMainScreen()
        }

    }

}