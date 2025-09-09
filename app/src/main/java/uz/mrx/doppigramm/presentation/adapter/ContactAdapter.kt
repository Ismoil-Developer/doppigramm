package uz.mrx.doppigramm.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.mrx.doppigramm.data.remote.response.chat.ContactResponse
import uz.mrx.doppigramm.databinding.ItemContactBinding

class ContactAdapter(private var onItemClickListener: (ContactResponse) -> Unit) :
    ListAdapter<ContactResponse, ContactAdapter.ViewHolder>(ContactResponseDiffUtilCallback) {

    inner class ViewHolder(private val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind() {

            val shop = getItem(absoluteAdapterPosition)

            binding.namePrf.text = shop.full_name

            itemView.setOnClickListener {
                onItemClickListener.invoke(shop)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemContactBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.onBind()

    object ContactResponseDiffUtilCallback : DiffUtil.ItemCallback<ContactResponse>() {
        override fun areItemsTheSame(oldItem: ContactResponse, newItem: ContactResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ContactResponse, newItem: ContactResponse): Boolean {
            return oldItem == newItem
        }
    }

}