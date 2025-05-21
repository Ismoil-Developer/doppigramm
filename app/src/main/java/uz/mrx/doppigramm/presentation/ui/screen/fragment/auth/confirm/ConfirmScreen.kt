package uz.mrx.doppigramm.presentation.ui.screen.fragment.auth.confirm

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.mrx.doppigramm.R
import uz.mrx.doppigramm.databinding.ScreenConfirmBinding
import uz.mrx.doppigramm.presentation.ui.viewmodel.confirm.ConfirmScreenViewModel
import uz.mrx.doppigramm.presentation.ui.viewmodel.confirm.impl.ConfirmScreenViewModelImpl

@AndroidEntryPoint
class ConfirmScreen : Fragment(R.layout.screen_confirm) {

    private val binding: ScreenConfirmBinding by viewBinding(ScreenConfirmBinding::bind)
    private val viewModel: ConfirmScreenViewModel by viewModels<ConfirmScreenViewModelImpl>()
    private var countDownTimer: CountDownTimer? = null

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.messageConfirm.setAnimation(R.raw.phone_confirm)

        val editTexts = listOf(
            binding.edt1, binding.edt2, binding.edt3,
            binding.edt4, binding.edt5
        )

        editTexts.forEachIndexed { index, editText ->
            editText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    if (s?.length == 1 && index < editTexts.size - 1) {
                        editTexts[index + 1].requestFocus()
                    } else if (s.isNullOrEmpty() && index > 0) {
                        editTexts[index - 1].requestFocus()
                    }
                    checkCode(editTexts)
                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            })
        }

        startCountdown()

    }

    private fun checkCode(editTexts: List<EditText>) {
        val enteredCode = editTexts.joinToString("") { it.text.toString() }

        if (enteredCode.length == 5) {
            if (enteredCode == "55555") {
                viewModel.openScreen()
                editTexts.forEach { it.setBackgroundResource(R.drawable.back_password_true) }
            } else {
                editTexts.forEach { it.setBackgroundResource(R.drawable.back_password_false) }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun startCountdown() {
        countDownTimer?.cancel()

        binding.imageRepeat.isClickable = false

        countDownTimer = object : CountDownTimer(120000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                val minutes = secondsRemaining / 60
                val seconds = secondsRemaining % 60
                val timeString = String.format("%02d:%02d", minutes, seconds)
                binding.imageRepeat.text = timeString
            }

            override fun onFinish() {
                countDownTimer = null
                binding.imageRepeat.text = "Qayta yuborish"
                binding.imageRepeat.isClickable = true
                binding.imageRepeat.setOnClickListener {
                    startCountdown()
                }
                Toast.makeText(requireContext(), "Vaqt tugadi", Toast.LENGTH_SHORT).show()
            }
        }.start()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        countDownTimer?.cancel()
    }

    override fun onResume() {
        super.onResume()
        binding.edt1.requestFocus()
        val imm = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.edt1, InputMethodManager.SHOW_IMPLICIT)
    }
}
