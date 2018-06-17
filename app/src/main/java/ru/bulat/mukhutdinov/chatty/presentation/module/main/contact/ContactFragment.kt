package ru.bulat.mukhutdinov.chatty.presentation.module.main.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import ru.bulat.mukhutdinov.chatty.R
import ru.bulat.mukhutdinov.chatty.databinding.ContactBinding
import ru.bulat.mukhutdinov.chatty.domain.entity.ContactEntity
import ru.bulat.mukhutdinov.chatty.presentation.App
import ru.bulat.mukhutdinov.chatty.presentation.module.base.BaseFragment
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contact.contract.ContactPresenter
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contact.contract.ContactView
import ru.bulat.mukhutdinov.chatty.presentation.util.EXTRA
import javax.inject.Inject

class ContactFragment : BaseFragment<ContactPresenter>(), ContactView {
    private lateinit var binding: ContactBinding

    private lateinit var contact: ContactEntity

    @Inject
    lateinit var presenter_: ContactPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.contact, container, false)
        contact = arguments?.getParcelable(EXTRA)!!

        return binding.root
    }

    override fun getPresenter(): ContactPresenter = presenter_

    override fun injectPresenter() = (activity?.application as App).component.inject(this)
}

