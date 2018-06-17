package ru.bulat.mukhutdinov.chatty.presentation.module.main.contactfeed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import ru.bulat.mukhutdinov.chatty.R
import ru.bulat.mukhutdinov.chatty.databinding.ContactItemBinding
import ru.bulat.mukhutdinov.chatty.domain.entity.ContactEntity
import ru.bulat.mukhutdinov.chatty.presentation.util.OnContactClickListener

class ContactFeedAdapter(private val contacts: List<ContactEntity>, private val onClickListener: OnContactClickListener) :
        RecyclerView.Adapter<ContactFeedAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ContactFeedAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ContactItemBinding = DataBindingUtil.inflate(inflater, R.layout.contact_item, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contacts[position])
    }

    override fun getItemCount() = contacts.size

    inner class ViewHolder(private val binding: ContactItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            binding.root.setOnClickListener(this)
        }

        fun bind(contact: ContactEntity) {
            binding.contact = contact
            binding.executePendingBindings()
        }

        override fun onClick(p0: View?) {
            onClickListener.onClick(binding.contact!!)
        }
    }
}