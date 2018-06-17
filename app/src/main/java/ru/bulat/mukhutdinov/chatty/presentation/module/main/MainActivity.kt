package ru.bulat.mukhutdinov.chatty.presentation.module.main

import android.os.Bundle
import android.view.View
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.google.android.material.bottomappbar.BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
import com.google.android.material.bottomappbar.BottomAppBar.FAB_ALIGNMENT_MODE_END
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_HALF_EXPANDED
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_HIDDEN
import ru.bulat.mukhutdinov.chatty.R
import ru.bulat.mukhutdinov.chatty.databinding.ActivityMainBinding
import ru.bulat.mukhutdinov.chatty.domain.entity.ContactEntity
import ru.bulat.mukhutdinov.chatty.presentation.util.EXTRA

class MainActivity : AppCompatActivity(), MainRouter {

    private lateinit var binding: ActivityMainBinding

    private lateinit var bottomDrawerBehavior: BottomSheetBehavior<View>

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.container);

        binding.bottomAppBar.replaceMenu(R.menu.menu_main)
        binding.bottomAppBar.hideOnScroll = true

        bottomDrawerBehavior = BottomSheetBehavior.from(binding.bottomDrawer)
        bottomDrawerBehavior.state = STATE_HIDDEN

        binding.bottomAppBar.setNavigationOnClickListener { _ ->
            if (navController.currentDestination.id == R.id.contactFragment) {
                showContactFeed()
            } else {
                bottomDrawerBehavior.state = STATE_HALF_EXPANDED
            }
        }

        binding.navigationView.setNavigationItemSelectedListener { _ ->
            bottomDrawerBehavior.state = STATE_HIDDEN
            false
        }
    }

    override fun showContactFeed() {
        binding.bottomAppBar.fabAlignmentMode = FAB_ALIGNMENT_MODE_CENTER

        animateNavigationIcon(R.drawable.anim_from_arrow_to_menu)

        navController.popBackStack(R.id.contactFeedFragment, false)
    }

    override fun showContact(contact: ContactEntity) {
        bottomDrawerBehavior.state = STATE_HIDDEN
        binding.bottomAppBar.fabAlignmentMode = FAB_ALIGNMENT_MODE_END

        animateNavigationIcon(R.drawable.anim_from_menu_to_arrow)

        val extras = Bundle()
        extras.putParcelable(EXTRA, contact)
        navController.navigate(R.id.action_contactFeedFragment_to_contactFragment, extras)
    }

    override fun onBackPressed() {
        if (bottomDrawerBehavior.state != BottomSheetBehavior.STATE_HIDDEN) {
            bottomDrawerBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            return
        }

        if (navController.currentDestination.id == R.id.contactFragment) {
            showContactFeed()
            return;
        }

        super.onBackPressed()
    }

    private fun animateNavigationIcon(@DrawableRes animationId: Int) {
        val animDrawable = AnimatedVectorDrawableCompat.create(this, animationId)
        binding.bottomAppBar.navigationIcon = animDrawable
        (binding.bottomAppBar.navigationIcon as AnimatedVectorDrawableCompat).start()
    }
}