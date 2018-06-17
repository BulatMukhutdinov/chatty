package ru.bulat.mukhutdinov.chatty.presentation.module.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.google.android.material.bottomappbar.BottomAppBar.FAB_ALIGNMENT_MODE_END
import com.google.android.material.bottomsheet.BottomSheetBehavior
import ru.bulat.mukhutdinov.chatty.R
import ru.bulat.mukhutdinov.chatty.databinding.ActivityMainBinding
import ru.bulat.mukhutdinov.chatty.domain.entity.ContactEntity
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contact.ContactFragment
import ru.bulat.mukhutdinov.chatty.presentation.module.main.contactfeed.ContactFeedFeedFragment

class MainActivity : AppCompatActivity(), MainRouter {

    private object Constants {
        const val CONTACT_PAGE = 1
    }

    private lateinit var binding: ActivityMainBinding

    private lateinit var bottomDrawerBehavior: BottomSheetBehavior<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.bottomAppBar.replaceMenu(R.menu.menu_main)
        binding.bottomAppBar.hideOnScroll = true

        bottomDrawerBehavior = BottomSheetBehavior.from(binding.bottomDrawer)
        bottomDrawerBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        binding.bottomAppBar.setNavigationOnClickListener { _ ->
            if (supportFragmentManager.backStackEntryCount == Constants.CONTACT_PAGE) {
                onBackPressed()
            } else {
                bottomDrawerBehavior.setState(BottomSheetBehavior.STATE_HALF_EXPANDED)
            }
        }

        binding.navigationView.setNavigationItemSelectedListener { _ ->
            bottomDrawerBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            false
        }
        showContactFeed()
    }

    override fun showContactFeed() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, ContactFeedFeedFragment())
                .commit()
    }

    override fun showContact(contact: ContactEntity) {
        if (bottomDrawerBehavior.state != BottomSheetBehavior.STATE_HIDDEN) {
            bottomDrawerBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        }
        val animDrawable = AnimatedVectorDrawableCompat.create(this, R.drawable.anim_from_menu_to_arrow)
        binding.bottomAppBar.navigationIcon = animDrawable
        (binding.bottomAppBar.navigationIcon as AnimatedVectorDrawableCompat).start()

        binding.bottomAppBar.fabAlignmentMode = FAB_ALIGNMENT_MODE_END

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, ContactFragment.newInstance(contact))
                .addToBackStack(null)
                .commit()
    }

}