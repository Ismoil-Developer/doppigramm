package uz.mrx.doppigramm.presentation.ui.screen.fragment.auth.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.mrx.doppigramm.R
import uz.mrx.doppigramm.databinding.ScreenLoginBinding
import uz.mrx.doppigramm.presentation.ui.viewmodel.login.LoginScreenViewModel
import uz.mrx.doppigramm.presentation.ui.viewmodel.login.impl.LoginScreenViewModelImpl

@AndroidEntryPoint
class LoginScreen : Fragment(R.layout.screen_login) {

    private val binding: ScreenLoginBinding by viewBinding(ScreenLoginBinding::bind)
    private val viewModel:LoginScreenViewModel by viewModels<LoginScreenViewModelImpl>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.mbSentSmsCode.setOnClickListener {
            viewModel.openFirstProfileScreen()
        }


    }


}
