package br.com.mdr.testeestadaao.extensions

import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import com.google.android.material.textview.MaterialTextView

@BindingAdapter(value = ["htmlString"], requireAll = true)
fun MaterialTextView.setHtmlString(htmlString: String?) {
    if (!htmlString.isNullOrEmpty()) {
        text = HtmlCompat.fromHtml(htmlString, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}