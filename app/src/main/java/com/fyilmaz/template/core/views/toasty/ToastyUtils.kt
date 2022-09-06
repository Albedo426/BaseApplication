package com.kale.alarm.core.views.toasty

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.NonNull
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import com.fyilmaz.template.R

internal object ToastyUtils {
    fun tintIcon(@NonNull drawable: Drawable?, @ColorInt tintColor: Int): Drawable? {
        drawable?.setColorFilter(tintColor, PorterDuff.Mode.SRC_IN)
        return drawable
    }

    fun tint9PatchDrawableFrame(@NonNull context: Context?, @ColorInt tintColor: Int): Drawable? {
        val toastDrawable = getDrawable(context, R.drawable.toast_frame)
        return tintIcon(toastDrawable, tintColor)
    }

    fun setBackground(@NonNull view: View, drawable: Drawable?) {
        view.background = drawable
    }

    fun getDrawable(@NonNull context: Context?, @DrawableRes id: Int): Drawable {
        return context?.let { AppCompatResources.getDrawable(it, id) }!!
    }

    fun getColor(@NonNull context: Context?, @ColorRes color: Int): Int {
        return ContextCompat.getColor(context!!, color)
    }
}
