package uz.mrx.doppigramm.presentation.ui.screen.fragment.intro

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import uz.mrx.doppigramm.R
import uz.mrx.doppigramm.data.model.IntroItem
import uz.mrx.doppigramm.databinding.ScreenIntroBinding
import uz.mrx.doppigramm.presentation.adapter.IntroAdapter
import uz.mrx.doppigramm.presentation.ui.viewmodel.intro.IntroScreenViewModel
import uz.mrx.doppigramm.presentation.ui.viewmodel.intro.impl.IntroScreenViewModelImpl

@AndroidEntryPoint
class IntroScreen : Fragment(R.layout.screen_intro) {

    private val binding: ScreenIntroBinding by viewBinding(ScreenIntroBinding::bind)
    private val viewModel: IntroScreenViewModel by viewModels<IntroScreenViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val introItems = listOf(
            IntroItem(R.raw.fast, "Sifatli Mahsulotlar", "Doimiy yangilanib turadigan mahsulotlar bilan ta'minlaymiz."),
            IntroItem(R.raw.free, "Tez Yetkazib berish", "Buyurtmangizni tez va ishonchli yetkazamiz."),
            IntroItem(R.raw.infinity, "Kuchli", "Sizning media fayilaringizni cheklamaydi."),
            IntroItem(R.raw.secure, "Qulay Narxlar", "Hamyonbop va raqobatbardosh narxlar."),
            IntroItem(R.raw.cloud, "Bulutli", "Siz har qanday telfon qurilmada yozisha olasiz.")
        )

        val adapter = IntroAdapter(introItems)
        binding.viewPagerIntro.adapter = adapter

        // ✅ ViewPager2 bilan ishlovchi TabLayoutMediator
        TabLayoutMediator(
            binding.tabLayoutClinicIndicator,
            binding.viewPagerIntro
        ) { tab, position ->
            // Tab text kerak bo'lmasa hech nima yozmasligingiz mumkin
        }.attach()

        binding.btnContinue.setOnClickListener {
            viewModel.openLoginScreen()
        }
    }
}
