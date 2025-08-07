package uz.mrx.doppigramm.presentation.ui.screen.fragment.auth.register

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.mrx.doppigramm.R
import uz.mrx.doppigramm.databinding.ScreenRegisterBinding
import uz.mrx.doppigramm.presentation.ui.viewmodel.confirm.RegisterScreenViewModel
import uz.mrx.doppigramm.presentation.ui.viewmodel.confirm.impl.RegisterScreenViewModelImpl

@AndroidEntryPoint
class RegisterScreen : Fragment(R.layout.screen_register) {

    private val binding: ScreenRegisterBinding by viewBinding(ScreenRegisterBinding::bind)
    private val viewModel: RegisterScreenViewModel by viewModels<RegisterScreenViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.mbSentSmsCode.setOnClickListener {
            viewModel.openLoginScreen()
        }


    }
}
