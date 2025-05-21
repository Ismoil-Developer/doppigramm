package uz.mrx.doppigramm.presentation.ui.screen.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.mrx.doppigramm.presentation.ui.screen.chat.GroupChatPage
import uz.mrx.doppigramm.presentation.ui.screen.chat.PersonChatPage

class ChatViewPager (fm: FragmentActivity) : FragmentStateAdapter(fm) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PersonChatPage()
            1 -> GroupChatPage()
            else -> PersonChatPage()
        }
    }

}