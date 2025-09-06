package uz.mrx.doppigramm.presentation.ui.screen.fragment.auth.register

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.mrx.doppigramm.R
import uz.mrx.doppigramm.data.remote.request.auth.RegisterRequest
import uz.mrx.doppigramm.databinding.ScreenRegisterBinding
import uz.mrx.doppigramm.presentation.ui.viewmodel.register.RegisterScreenViewModel
import uz.mrx.doppigramm.presentation.ui.viewmodel.register.impl.RegisterScreenViewModelImpl

@AndroidEntryPoint
class RegisterScreen : Fragment(R.layout.screen_register) {

    private val binding: ScreenRegisterBinding by viewBinding(ScreenRegisterBinding::bind)
    private val viewModel: RegisterScreenViewModel by viewModels<RegisterScreenViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.mbSentSmsCode.setOnClickListener {
            val phone = binding.edtGmail.text.toString().trim()
            val fullName = binding.edtINN.text.toString().trim()
            val password = binding.tietPassword.text.toString().trim()
            val confirmPassword = binding.tietConfirmPassword.text.toString().trim()

            if (!binding.checkboxAcceptTerms.isChecked) {
                Toast.makeText(requireContext(), "Ofertaga rozilik belgilang!", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            if (phone.isEmpty() || fullName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Barcha maydonlarni to‘ldiring!",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(requireContext(), "Parollar bir xil emas!", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            // ViewModel orqali register qilish
            val request = RegisterRequest(
                full_name = fullName,
                phone = phone,
                password = password,
                password_confirmation = confirmPassword
            )
            viewModel.postRegister(request)
        }

        // 📌 Response kuzatish
        lifecycleScope.launchWhenStarted {
            viewModel.registerResponse.collect { response ->
                Toast.makeText(
                    requireContext(),
                    "Ro‘yxatdan o‘tish muvaffaqiyatli!",
                    Toast.LENGTH_SHORT
                ).show()

                viewModel.openLoginScreen()
            }
        }
    }


}
