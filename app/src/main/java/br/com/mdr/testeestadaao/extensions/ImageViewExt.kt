package br.com.mdr.testeestadaao.extensions

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder

inline fun ImageView.loadImage(
    context: Context,
    url: String,
    onConfigure: RequestBuilder<Drawable>.() -> RequestBuilder<Drawable> = { this }
) =
    Glide.with(context)
        .load(url)
        .onConfigure()
        .into(this)

@BindingAdapter("urlload")
fun ImageView.loadImageBinding(imageUrl: String?) =
    imageUrl?.let { loadImage(context, it) }
