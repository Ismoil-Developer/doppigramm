package uz.mrx.doppigramm.presentation.ui.screen.fragment.auth.login

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hbb20.CountryCodePicker
import dagger.hilt.android.AndroidEntryPoint
import uz.mrx.doppigramm.R
import uz.mrx.doppigramm.databinding.ScreenLoginBinding
import uz.mrx.doppigramm.presentation.ui.viewmodel.login.LoginScreenViewModel
import uz.mrx.doppigramm.presentation.ui.viewmodel.login.impl.LoginScreenViewModelImpl

@AndroidEntryPoint
class LoginScreen : Fragment(R.layout.screen_login) {

    private val binding: ScreenLoginBinding by viewBinding(ScreenLoginBinding::bind)
    private val viewModel:LoginScreenViewModel by viewModels<LoginScreenViewModelImpl>()

    private lateinit var countrySelector: TextView
    private lateinit var countryCode: TextView
    private lateinit var ccp: CountryCodePicker

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countrySelector = binding.countrySelector
        countryCode = binding.countryCode

        ccp = CountryCodePicker(requireContext())

        countrySelector.setOnClickListener {
            ccp.launchCountrySelectionDialog()
        }

        ccp.setOnCountryChangeListener {
            val countryName = ccp.selectedCountryName
            val countryCodeString = "+${ccp.selectedCountryCode}"
            val countryAlphaCode = ccp.selectedCountryNameCode
            val flagEmoji = getFlagEmoji(countryAlphaCode)

            // 1. Davlat nomi + flag
            countrySelector.text = "$flagEmoji $countryName"

            // 2. Country code ni chiqarish
            countryCode.text = countryCodeString

            // 3. Telefon raqam mask hint
            val hint = getPhoneHintForCountry(ccp.selectedCountryNameCode)
            binding.phoneEditText.hint = hint
        }

        binding.icNext.setOnClickListener {
            viewModel.openConfirmScreen()
        }

    }

    private fun getFlagEmoji(countryCode: String): String {
        return countryCode.uppercase().map {
            Character.toChars(it.code - 0x41 + 0x1F1E6)
        }.joinToString("") { String(it) }
    }

    // Mask hintlar faqat mashhur davlatlar uchun (kerakli davlatlarni qo‘shing)
    private fun getPhoneHintForCountry(countryCode: String): String {
        return when (countryCode.uppercase()) {
            "UZ" -> "00 000 00 00"
            "RU" -> "900 000 00 00"
            "US" -> "000 000 0000"
            "IN" -> "00000 00000"
            "TR" -> "000 000 00 00"
            else -> "Telefon raqami"
        }
    }
}
