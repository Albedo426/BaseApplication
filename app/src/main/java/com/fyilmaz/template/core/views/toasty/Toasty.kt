package com.fyilmaz.template.core.views.toasty

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Configuration
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.*
import com.fyilmaz.template.R

@SuppressLint("InflateParams")
object Toasty {
    private val LOADED_TOAST_TYPEFACE = Typeface.create("sans-serif-condensed", Typeface.NORMAL)
    private var currentTypeface = LOADED_TOAST_TYPEFACE
    private var textSize = 16 // in SP
    private var tintIcon = true
    private var allowQueue = true
    private var toastGravity = -1
    private var xOffset = -1
    private var yOffset = -1
    private var supportDarkTheme = true
    private var isRTL = false
    private var lastToast: Toast? = null
    const val LENGTH_SHORT = Toast.LENGTH_SHORT
    const val LENGTH_LONG = Toast.LENGTH_LONG

    @CheckResult
    fun normal(context: Context, @StringRes message: Int): Toast {
        return normal(context, context.getString(message), Toast.LENGTH_SHORT, null, false)
    }

    @CheckResult
    fun normal(context: Context, message: CharSequence): Toast {
        return normal(context, message, Toast.LENGTH_SHORT, null, false)
    }

    @CheckResult
    fun normal(context: Context, @StringRes message: Int, icon: Drawable?): Toast {
        return normal(context, context.getString(message), Toast.LENGTH_SHORT, icon, true)
    }

    @CheckResult
    fun normal(context: Context, message: CharSequence, icon: Drawable?): Toast {
        return normal(context, message, Toast.LENGTH_SHORT, icon, true)
    }

    @CheckResult
    fun normal(context: Context, @StringRes message: Int, duration: Int): Toast {
        return normal(context, context.getString(message), duration, null, false)
    }

    @CheckResult
    fun normal(context: Context, message: CharSequence, duration: Int): Toast {
        return normal(context, message, duration, null, false)
    }

    @CheckResult
    fun normal(
        context: Context,
        @StringRes message: Int,
        duration: Int,
        icon: Drawable?
    ): Toast {
        return normal(context, context.getString(message), duration, icon, true)
    }

    @CheckResult
    fun normal(
        context: Context,
        message: CharSequence,
        duration: Int,
        icon: Drawable?
    ): Toast {
        return normal(context, message, duration, icon, true)
    }

    @CheckResult
    fun normal(
        context: Context,
        @StringRes message: Int,
        duration: Int,
        icon: Drawable?,
        withIcon: Boolean
    ): Toast {
        return normalWithDarkThemeSupport(
            context,
            context.getString(message),
            icon,
            duration,
            withIcon
        )
    }

    @CheckResult
    fun normal(
        context: Context,
        message: CharSequence,
        duration: Int,
        icon: Drawable?,
        withIcon: Boolean
    ): Toast {
        return normalWithDarkThemeSupport(context, message, icon, duration, withIcon)
    }

    @CheckResult
    fun warning(context: Context, @StringRes message: Int): Toast {
        return warning(context, context.getString(message), Toast.LENGTH_SHORT, true)
    }

    @CheckResult
    fun warning(context: Context, message: CharSequence): Toast {
        return warning(context, message, Toast.LENGTH_SHORT, true)
    }

    @CheckResult
    fun warning(context: Context, @StringRes message: Int, duration: Int): Toast {
        return warning(context, context.getString(message), duration, true)
    }

    @CheckResult
    fun warning(context: Context, message: CharSequence, duration: Int): Toast {
        return warning(context, message, duration, true)
    }

    @CheckResult
    fun warning(
        context: Context,
        @StringRes message: Int,
        duration: Int?,
        withIcon: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            ToastyUtils.getDrawable(context, R.drawable.ic_error_outline_white_24dp),
            ToastyUtils.getColor(context, R.color.warningColor),
            ToastyUtils.getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun warning(context: Context, message: CharSequence, duration: Int, withIcon: Boolean): Toast {
        return custom(
            context,
            message,
            ToastyUtils.getDrawable(context, R.drawable.ic_error_outline_white_24dp),
            ToastyUtils.getColor(context, R.color.warningColor),
            ToastyUtils.getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun info(context: Context, @StringRes message: Int): Toast {
        return info(context, context.getString(message), Toast.LENGTH_SHORT, true)
    }

    @CheckResult
    fun info(context: Context, message: CharSequence): Toast {
        return info(context, message, Toast.LENGTH_SHORT, true)
    }

    @CheckResult
    fun info(context: Context, @StringRes message: Int, duration: Int): Toast {
        return info(context, context.getString(message), duration, true)
    }

    @CheckResult
    fun info(context: Context, message: CharSequence, duration: Int): Toast {
        return info(context, message, duration, true)
    }

    @CheckResult
    fun info(context: Context, @StringRes message: Int, duration: Int, withIcon: Boolean): Toast {
        return custom(
            context,
            context.getString(message),
            ToastyUtils.getDrawable(context, R.drawable.ic_info_outline_white_24dp),
            ToastyUtils.getColor(context, R.color.infoColor),
            ToastyUtils.getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun info(context: Context, message: CharSequence, duration: Int, withIcon: Boolean): Toast {
        return custom(
            context,
            message,
            ToastyUtils.getDrawable(context, R.drawable.ic_info_outline_white_24dp),
            ToastyUtils.getColor(context, R.color.infoColor),
            ToastyUtils.getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun success(context: Context, @StringRes message: Int): Toast {
        return success(context, context.getString(message), Toast.LENGTH_SHORT, true)
    }

    @CheckResult
    fun success(context: Context, message: CharSequence): Toast {
        return success(context, message, Toast.LENGTH_SHORT, true)
    }

    @CheckResult
    fun success(context: Context, @StringRes message: Int, duration: Int): Toast {
        return success(context, context.getString(message), duration, true)
    }

    @CheckResult
    fun success(context: Context, message: CharSequence, duration: Int): Toast {
        return success(context, message, duration, true)
    }

    @CheckResult
    fun success(
        context: Context,
        @StringRes message: Int,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            ToastyUtils.getDrawable(context, R.drawable.ic_check_white_24dp),
            ToastyUtils.getColor(context, R.color.successColor),
            ToastyUtils.getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun success(context: Context, message: CharSequence, duration: Int, withIcon: Boolean): Toast {
        return custom(
            context,
            message,
            ToastyUtils.getDrawable(context, R.drawable.ic_check_white_24dp),
            ToastyUtils.getColor(context, R.color.successColor),
            ToastyUtils.getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun error(context: Context, @StringRes message: Int): Toast {
        return error(context, context.getString(message), Toast.LENGTH_SHORT, true)
    }

    @CheckResult
    fun error(context: Context, message: CharSequence): Toast {
        return error(context, message, Toast.LENGTH_SHORT, true)
    }

    @CheckResult
    fun error(context: Context, @StringRes message: Int, duration: Int): Toast {
        return error(context, context.getString(message), duration, true)
    }

    @CheckResult
    fun error(context: Context, message: CharSequence, duration: Int): Toast {
        return error(context, message, duration, true)
    }

    @CheckResult
    fun error(context: Context, @StringRes message: Int, duration: Int, withIcon: Boolean): Toast {
        return custom(
            context,
            context.getString(message),
            ToastyUtils.getDrawable(context, R.drawable.ic_clear_white_24dp),
            ToastyUtils.getColor(context, R.color.errorColor),
            ToastyUtils.getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun error(context: Context, message: CharSequence, duration: Int, withIcon: Boolean): Toast {
        return custom(
            context,
            message,
            ToastyUtils.getDrawable(context, R.drawable.ic_clear_white_24dp),
            ToastyUtils.getColor(context, R.color.errorColor),
            ToastyUtils.getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            true
        )
    }

    @CheckResult
    fun custom(
        context: Context,
        @StringRes message: Int,
        icon: Drawable?,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            icon,
            -1,
            ToastyUtils.getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            false
        )
    }

    @CheckResult
    fun custom(
        context: Context,
        message: CharSequence,
        icon: Drawable?,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return custom(
            context, message, icon, -1, ToastyUtils.getColor(context, R.color.defaultTextColor),
            duration, withIcon, false
        )
    }

    @CheckResult
    fun custom(
        context: Context,
        @StringRes message: Int,
        @DrawableRes iconRes: Int,
        @ColorRes tintColorRes: Int,
        duration: Int,
        withIcon: Boolean,
        shouldTint: Boolean
    ): Toast {
        return custom(
            context,
            context.getString(message),
            ToastyUtils.getDrawable(context, iconRes),
            ToastyUtils.getColor(context, tintColorRes),
            ToastyUtils.getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            shouldTint
        )
    }

    @CheckResult
    fun custom(
        context: Context,
        message: CharSequence,
        @DrawableRes iconRes: Int,
        @ColorRes tintColorRes: Int,
        duration: Int,
        withIcon: Boolean,
        shouldTint: Boolean
    ): Toast {
        return custom(
            context,
            message,
            ToastyUtils.getDrawable(context, iconRes),
            ToastyUtils.getColor(context, tintColorRes),
            ToastyUtils.getColor(context, R.color.defaultTextColor),
            duration,
            withIcon,
            shouldTint
        )
    }

    @CheckResult
    fun custom(
        context: Context,
        @StringRes message: Int,
        icon: Drawable?,
        @ColorRes tintColorRes: Int,
        duration: Int,
        withIcon: Boolean,
        shouldTint: Boolean
    ): Toast {
        return custom(
            context, context.getString(message), icon, ToastyUtils.getColor(context, tintColorRes),
            ToastyUtils.getColor(context, R.color.defaultTextColor), duration, withIcon, shouldTint
        )
    }

    @CheckResult
    fun custom(
        context: Context,
        @StringRes message: Int,
        icon: Drawable?,
        @ColorRes tintColorRes: Int,
        @ColorRes textColorRes: Int,
        duration: Int,
        withIcon: Boolean,
        shouldTint: Boolean
    ): Toast {
        return custom(
            context, context.getString(message), icon, ToastyUtils.getColor(context, tintColorRes),
            ToastyUtils.getColor(context, textColorRes), duration, withIcon, shouldTint
        )
    }

    @SuppressLint("ShowToast")
    @CheckResult
    fun custom(
        context: Context,
        message: CharSequence,
        icon: Drawable?,
        @ColorInt tintColor: Int?,
        @ColorInt textColor: Int?,
        duration: Int?,
        withIcon: Boolean,
        shouldTint: Boolean
    ): Toast {
        val currentToast = Toast.makeText(context, "", duration!!)
        val toastLayout: View =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(R.layout.view_toast_layout, null)
        val toastRoot = toastLayout.findViewById<LinearLayout>(R.id.toast_root)
        val toastIcon = toastLayout.findViewById<ImageView>(R.id.toast_icon)
        val toastTextView = toastLayout.findViewById<TextView>(R.id.toast_text)
        val drawableFrame: Drawable? = if (shouldTint) ToastyUtils.tint9PatchDrawableFrame(
            context,
            tintColor!!
        ) else ToastyUtils.getDrawable(context, R.drawable.toast_frame)
        ToastyUtils.setBackground(toastLayout, drawableFrame)
        if (withIcon) {
            requireNotNull(icon) { "Avoid passing 'icon' as null if 'withIcon' is set to true" }
            if (isRTL) toastRoot.layoutDirection =
                View.LAYOUT_DIRECTION_RTL
            ToastyUtils.setBackground(
                toastIcon,
                if (tintIcon) textColor?.let { ToastyUtils.tintIcon(icon, it) } else icon
            )
        } else {
            toastIcon.visibility = View.GONE
        }
        toastTextView.text = message
        if (textColor != null) {
            toastTextView.setTextColor(textColor)
        }
        toastTextView.setTypeface(currentTypeface)
        toastTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize.toFloat())
        currentToast.setView(toastLayout)
        if (!allowQueue) {
            if (lastToast != null) lastToast!!.cancel()
            lastToast = currentToast
        }

        // Make sure to use default values for non-specified ones.
        currentToast.setGravity(
            if (toastGravity == -1) currentToast.gravity else toastGravity,
            if (xOffset == -1) currentToast.xOffset else xOffset,
            if (yOffset == -1) currentToast.yOffset else yOffset
        )
        return currentToast
    }

    private fun normalWithDarkThemeSupport(
        context: Context,
        message: CharSequence,
        icon: Drawable?,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return if (supportDarkTheme && Build.VERSION.SDK_INT >= 29) {
            val uiMode =
                context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            if (uiMode == Configuration.UI_MODE_NIGHT_NO) {
                withLightTheme(context, message, icon, duration, withIcon)
            } else withDarkTheme(context, message, icon, duration, withIcon)
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                withLightTheme(context, message, icon, duration, withIcon)
            } else {
                withDarkTheme(context, message, icon, duration, withIcon)
            }
        }
    }

    private fun withLightTheme(
        context: Context,
        message: CharSequence,
        icon: Drawable?,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return custom(
            context, message, icon, ToastyUtils.getColor(context, R.color.defaultTextColor),
            ToastyUtils.getColor(context, R.color.normalColor), duration, withIcon, true
        )
    }

    private fun withDarkTheme(
        context: Context,
        message: CharSequence,
        icon: Drawable?,
        duration: Int,
        withIcon: Boolean
    ): Toast {
        return ToastyUtils.getColor(context, R.color.defaultTextColor).let {
            ToastyUtils.getColor(context, R.color.normalColor).let { it1 ->
                custom(
                    context, message, icon, it1,
                    it, duration, withIcon, true
                )
            }
        }
    }

    class Config private constructor() {
        private var typeface = currentTypeface
        private var textSize = Toasty.textSize
        private var tintIcon = Toasty.tintIcon
        private var allowQueue = true
        private var toastGravity = Toasty.toastGravity
        private var xOffset = Toasty.xOffset
        private var yOffset = Toasty.yOffset
        private var supportDarkTheme = true
        private var isRTL = false

        @CheckResult
        fun setToastTypeface(typeface: Typeface): Config {
            this.typeface = typeface
            return this
        }

        @CheckResult
        fun setTextSize(sizeInSp: Int): Config {
            this.textSize = sizeInSp
            return this
        }

        @CheckResult
        fun tintIcon(tintIcon: Boolean): Config {
            this.tintIcon = tintIcon
            return this
        }

        @CheckResult
        fun allowQueue(allowQueue: Boolean): Config {
            this.allowQueue = allowQueue
            return this
        }

        @CheckResult
        fun setGravity(gravity: Int, xOffset: Int, yOffset: Int): Config {
            this.toastGravity = gravity
            this.xOffset = xOffset
            this.yOffset = yOffset
            return this
        }

        @CheckResult
        fun setGravity(gravity: Int): Config {
            this.toastGravity = gravity
            return this
        }

        @CheckResult
        fun supportDarkTheme(supportDarkTheme: Boolean): Config {
            this.supportDarkTheme = supportDarkTheme
            return this
        }

        fun setRTL(isRTL: Boolean): Config {
            this.isRTL = isRTL
            return this
        }

        fun apply() {
            currentTypeface = typeface
            Toasty.textSize = textSize
            Toasty.tintIcon = tintIcon
            Toasty.allowQueue = allowQueue
            Toasty.toastGravity = toastGravity
            Toasty.xOffset = xOffset
            Toasty.yOffset = yOffset
            Toasty.supportDarkTheme = supportDarkTheme
            Toasty.isRTL = isRTL
        }

        companion object {
            @get:CheckResult
            val instance: Config
                get() = Config()

            fun reset() {
                currentTypeface = LOADED_TOAST_TYPEFACE
                textSize = 16
                tintIcon = true
                allowQueue = true
                toastGravity = -1
                xOffset = -1
                yOffset = -1
                supportDarkTheme = true
                isRTL = false
            }
        }
    }
}
