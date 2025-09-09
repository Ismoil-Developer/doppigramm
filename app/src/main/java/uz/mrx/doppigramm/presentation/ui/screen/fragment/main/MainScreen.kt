package uz.mrx.doppigramm.presentation.ui.screen.fragment.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import uz.mrx.doppigramm.R
import uz.mrx.doppigramm.data.local.shp.MySharedPreference
import uz.mrx.doppigramm.databinding.ScreenMainBinding
import uz.mrx.doppigramm.presentation.adapter.ChatViewPager
import uz.mrx.doppigramm.presentation.ui.viewmodel.main.MainScreenViewModel
import uz.mrx.doppigramm.presentation.ui.viewmodel.main.impl.MainScreenViewModelImpl
import javax.inject.Inject

@AndroidEntryPoint
class MainScreen:Fragment(R.layout.screen_main) {

    private val binding:ScreenMainBinding by viewBinding(ScreenMainBinding::bind)
    private val viewModel:MainScreenViewModel by viewModels<MainScreenViewModelImpl>()

    @Inject
    lateinit var sharedPreference: MySharedPreference

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.icMenu.setOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        binding.contact.setOnClickListener {
            viewModel.openContactScreen()
        }

        Log.d("TOKEN", "onViewCreated: ${sharedPreference.token}")

        setupTabLayout()

    }

    private fun setupTabLayout() {

        val tabTitles = listOf("Личные", "Группы") // Shaxsiy va Guruh chatlar
        binding.viewPager.adapter = ChatViewPager(requireActivity())
        binding.viewPager.isUserInputEnabled = false // Faqat tab bosilsa o'zgaradi

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

}