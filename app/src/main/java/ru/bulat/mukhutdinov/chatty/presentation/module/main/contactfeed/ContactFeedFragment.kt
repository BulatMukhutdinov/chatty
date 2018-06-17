package ru.bulat.mukhutdinov.chatty.presentation.module.main.contactfeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import ru.bulat.mukhutdinov.chatty.R
import ru.bulat.mukhutdinov.chatty.databinding.ContactFeedBinding
import ru.bulat.mukhutdinov.chatty.domain.entity.ContactEntity
import ru.bulat.mukhutdinov.chatty.presentation.App
import ru.bulat.mukhutdinov.chatty.presentation.module.base.BaseFragment
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contactfeed.contract.ContactFeedPresenter
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contactfeed.contract.ContactFeedView
import javax.inject.Inject

class ContactFeedFragment : BaseFragment<ContactFeedPresenter>(), ContactFeedView {

    private lateinit var binding: ContactFeedBinding

    @Inject
    lateinit var presenter_: ContactFeedPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.contact_feed, container, false)

        return binding.root
    }

    override fun showContacts(contacts: List<ContactEntity>) {
        binding.list.adapter = ContactFeedAdapter(contacts, presenter)
    }

    override fun getPresenter(): ContactFeedPresenter = presenter_

    override fun injectPresenter() = (activity?.application as App).component.inject(this)
}