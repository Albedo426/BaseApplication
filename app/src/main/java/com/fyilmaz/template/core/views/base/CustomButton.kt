package com.fyilmaz.template.core.views.base
import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.os.SystemClock
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatButton
import com.fyilmaz.template.R

class CustomButton(
    context: Context,
    attrs: AttributeSet
) : AppCompatButton(context, attrs) {

    var defaultInterval: Int = 1000
    private var lastTimeClicked: Long = 0
    var mySetOnTouchListener: (() -> Unit)? = null
    var backgroundInActive: Drawable? = null
    var backGroundDefault: Drawable? = null
    var backGroundPress: Drawable? = null
    var isSafeClick: Boolean = false
    private var customAttributesStyle: TypedArray? = null
    init {
        customAttributesStyle = context.obtainStyledAttributes(attrs, R.styleable.CustomButton, 0, 0)
        customAttributesStyle?.let { attrsStyle ->
            // set attr
            isSafeClick = attrsStyle.getBoolean(R.styleable.CustomButton_isSafeClick, false)
            backGroundDefault = attrsStyle.getDrawable(R.styleable.CustomButton_backgroundNormal)
            backgroundInActive = attrsStyle.getDrawable(R.styleable.CustomButton_backgroundInActive)
            backGroundPress = attrsStyle.getDrawable(R.styleable.CustomButton_backgroundPress)
            defaultInterval = attrsStyle.getInt(R.styleable.CustomButton_defaultInterval, 1000)

            // set default color
            changeBackground(backGroundDefault)

            // set onTouch
            setOnTouchListener { _, event ->
                performClick()
                when (event?.action) {
                    MotionEvent.ACTION_DOWN -> {
                        changeBackground(backGroundPress)
                        true
                    }
                    MotionEvent.ACTION_UP -> {
                        changeBackground(backGroundDefault)
                        if (isSafeClick) {
                            safeClickControl {
                                mySetOnTouchListener?.invoke()
                            }
                        } else {
                            mySetOnTouchListener?.invoke()
                        }
                        true
                    }
                    else -> { false }
                }
            }
        }
    }

     fun changeBackground(drawable: Drawable?) {
        drawable?.let {
            background = it
        }
    }
    private fun safeClickControl(safeControl: (() -> Unit)) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked >= defaultInterval) {
            safeControl()
            lastTimeClicked = SystemClock.elapsedRealtime()
        }
    }
}
