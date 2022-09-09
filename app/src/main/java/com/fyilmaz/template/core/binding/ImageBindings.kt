package com.fyilmaz.template.core.binding

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton


@BindingAdapter("app:image")
fun ImageView.imageURL(image: Any) {
    Glide.with(this.context).load(image).into(this)
}
@BindingAdapter("app:imageUrl")
fun ImageView.imageURL(url: String) {
    Glide.with(this.context).load(url).into(this)
}
@BindingAdapter("app:image")
fun ImageView.imageURL(@DrawableRes image: Int) {
    Glide.with(this.context).load(image).into(this)
}

@BindingAdapter("app:floatImage")
fun FloatingActionButton.imageSrc(@DrawableRes image: Int) {
    this.setImageDrawable(ContextCompat.getDrawable(this.context, image))
}
