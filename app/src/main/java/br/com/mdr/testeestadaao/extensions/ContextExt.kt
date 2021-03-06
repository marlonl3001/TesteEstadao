package br.com.mdr.testeestadaao.extensions

import android.content.Context
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import br.com.mdr.testeestadaao.R
import com.google.android.material.snackbar.Snackbar

fun Context.showSnackMessage(snackMessage: String, view: View) {
    val snackBar = Snackbar.make(view, snackMessage, Snackbar.LENGTH_LONG)
    val textId = com.google.android.material.R.id.snackbar_text
    val snackView = snackBar.view
    val txtSnack = snackView.findViewById<TextView>(textId)
    txtSnack.maxLines = 5
    val params = snackView.layoutParams as FrameLayout.LayoutParams
    val sideMargin = 16
    params.setMargins(params.leftMargin + sideMargin,
        params.topMargin,
        params.rightMargin + sideMargin,
        params.bottomMargin + sideMargin)
    snackView.layoutParams = params

    snackView.setBackgroundResource(R.color.colorError)

    txtSnack.setTextColor(ContextCompat.getColor(this, R.color.white))
    snackBar.show()
}