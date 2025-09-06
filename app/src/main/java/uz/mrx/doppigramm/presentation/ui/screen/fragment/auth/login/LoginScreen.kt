package uz.mrx.doppigramm.presentation.ui.screen.fragment.auth.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.mrx.doppigramm.R
import uz.mrx.doppigramm.data.local.shp.MySharedPreference
import uz.mrx.doppigramm.data.remote.request.auth.LoginRequest
import uz.mrx.doppigramm.databinding.ScreenLoginBinding
import uz.mrx.doppigramm.presentation.ui.viewmodel.login.LoginScreenViewModel
import uz.mrx.doppigramm.presentation.ui.viewmodel.login.impl.LoginScreenViewModelImpl
import javax.inject.Inject

@AndroidEntryPoint
class LoginScreen : Fragment(R.layout.screen_login) {

    private val binding: ScreenLoginBinding by viewBinding(ScreenLoginBinding::bind)
    private val viewModel: LoginScreenViewModel by viewModels<LoginScreenViewModelImpl>()

    @Inject
    lateinit var sharedPreference: MySharedPreference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.mbSentSmsCode.setOnClickListener {
            val phone = binding.edtGmail.text.toString().trim()
            val password = binding.tietPassword.text.toString().trim()

            if (phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(requireContext(), "Login va parolni kiriting!", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            viewModel.login(LoginRequest(phone, password))
        }

        // 📌 Response kuzatish
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.response.collectLatest { response ->
                // tokenni saqlash
                sharedPreference.token = response.access

                Toast.makeText(requireContext(), "Kirish muvaffaqiyatli!", Toast.LENGTH_SHORT)
                    .show()

                // Keyingi ekranga o‘tish
                viewModel.openFirstProfileScreen()
            }
        }
    }


}
