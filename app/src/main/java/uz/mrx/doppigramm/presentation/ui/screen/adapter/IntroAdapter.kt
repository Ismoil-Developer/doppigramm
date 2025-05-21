package uz.mrx.doppigramm.presentation.ui.screen.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieDrawable
import uz.mrx.doppigramm.R
import uz.mrx.doppigramm.data.model.IntroItem
import uz.mrx.doppigramm.databinding.ItemIntroBinding

class IntroAdapter(private val items: List<IntroItem>) :
    RecyclerView.Adapter<IntroAdapter.IntroViewHolder>() {

    inner class IntroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemIntroBinding.bind(view)

        fun bind(item: IntroItem) {
            binding.imageIntro.setAnimation(item.lottieFile)
            binding.imageIntro.repeatCount = LottieDrawable.INFINITE
            binding.imageIntro.playAnimation()
            binding.titleIntro.text = item.title
            binding.descIntro.text = item.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_intro, parent, false)
        return IntroViewHolder(view)
    }

    override fun onBindViewHolder(holder: IntroViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}
