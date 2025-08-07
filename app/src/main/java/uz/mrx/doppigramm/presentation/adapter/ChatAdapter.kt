package uz.mrx.doppigramm.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.mrx.doppigramm.data.model.ChatMessage
import uz.mrx.doppigramm.databinding.ItemReceiverMessageBinding
import uz.mrx.doppigramm.databinding.ItemSenderMessageBinding


class ChatAdapter(private val userId: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val messages = mutableListOf<ChatMessage>()
    private var otherUserId: Int? = null

    companion object {
        private const val VIEW_TYPE_SENT = 1
        private const val VIEW_TYPE_RECEIVED = 2
    }

    fun setOtherUserId(id: Int) {
        otherUserId = id
        notifyDataSetChanged()
    }

    fun setMessages(newMessages: List<ChatMessage>) {
        messages.clear()
        messages.addAll(newMessages)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        val senderId = messages[position].senderId
        return if (senderId == userId) {
            VIEW_TYPE_SENT
        } else {
            VIEW_TYPE_RECEIVED
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_SENT) {
            val binding =
                ItemSenderMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            SentMessageViewHolder(binding)
        } else {
            val binding = ItemReceiverMessageBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            ReceivedMessageViewHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messages[position]
        if (holder is SentMessageViewHolder) {
            holder.bind(message)
        } else if (holder is ReceivedMessageViewHolder) {
            holder.bind(message)
        }
    }

    override fun getItemCount(): Int = messages.size

    class SentMessageViewHolder(private val binding: ItemSenderMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: ChatMessage) {
            binding.chatTextView.text = message.message
            binding.chatDate.text = extractTime(message.timestamp)
        }
    }

    class ReceivedMessageViewHolder(private val binding: ItemReceiverMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: ChatMessage) {
            binding.chatTextView.text = message.message
            binding.chatDate.text = extractTime(message.timestamp)
        }
    }
}

fun extractTime(timestamp: String): String {
    return try {
        val timePart = timestamp.substringAfter("T").substring(0, 5) // "13:26"
        timePart
    } catch (e: Exception) {
        "--:--"
    }
}

