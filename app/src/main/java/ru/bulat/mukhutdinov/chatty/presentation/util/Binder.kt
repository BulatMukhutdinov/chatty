package ru.bulat.mukhutdinov.chatty.presentation.util

import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import ru.bulat.mukhutdinov.chatty.R
import java.util.*

object Binder {

    @BindingAdapter("android:src")
    @JvmStatic
    fun setImageUrl(view: CircleImageView, url: String?) {
        if (!url.isNullOrBlank()) {
            Picasso.get().load(url).placeholder(R.drawable.icon_placeholder).into(view)
        }
    }

    @BindingAdapter("android:backgroundTint")
    @JvmStatic
    fun setBackground(text: TextView, hasIcon: Boolean) {
        if (!hasIcon) {
            val colors = intArrayOf(R.color.red300, R.color.lime600, R.color.deepPurple300, R.color.green300, R.color.indigo300)

            val rand = Random()
            val colorIndex = rand.nextInt(colors.size)

            text.backgroundTintList = ContextCompat.getColorStateList(text.context, colors[colorIndex])
        }
    }
}