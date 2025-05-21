package uz.mrx.doppigramm.presentation.ui.screen.fragment.splash

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import uz.mrx.doppigramm.R
import uz.mrx.doppigramm.databinding.ScreenSplashBinding
import uz.mrx.doppigramm.presentation.ui.viewmodel.splash.SplashScreenViewModel
import uz.mrx.doppigramm.presentation.ui.viewmodel.splash.impl.SplashScreenViewModelImpl

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashScreen : Fragment(R.layout.screen_splash) {

    private val binding: ScreenSplashBinding by viewBinding(ScreenSplashBinding::bind)
    private val viewModel: SplashScreenViewModel by viewModels<SplashScreenViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.openIntroScreen()

    }
}