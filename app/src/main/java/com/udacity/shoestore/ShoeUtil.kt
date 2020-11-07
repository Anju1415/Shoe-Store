package com.udacity.shoestore

import android.content.res.Resources
import android.os.Build
import android.text.Html
import android.text.Spanned
import androidx.core.text.HtmlCompat
import com.udacity.shoestore.models.Shoe

fun formatShoeDetail(shoes: MutableList<Shoe>, resources: Resources): Spanned {
    val sb = StringBuilder()
    sb.apply {
        append(resources.getString(R.string.title))
        shoes.forEach {
            append("<br>")
            append(resources.getString(R.string.shoe_name))
            append("\t${it.name}<br>")
            append(resources.getString(R.string.company_name))
            append("\t${it.company}<br>")
            append(resources.getString(R.string.shoe_size))
            append("\t${it.company}<br>")
            append(resources.getString(R.string.shoe_description))
            append("\t${it.description}<br><br>")

        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(sb.toString(), Html.FROM_HTML_MODE_LEGACY)
        } else {
            return HtmlCompat.fromHtml(sb.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY)
        }
    }
}