package com.bigthinkapps.theleague.utils

import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bigthinkapps.theleague.data.Team
import com.bigthinkapps.theleague.data.TeamEvent
import com.bigthinkapps.theleague.view.adapter.contract.TeamAdapterContract
import com.bigthinkapps.theleague.view.adapter.contract.TeamEventPagerContract
import com.squareup.picasso.Picasso

@BindingAdapter("items")
fun setItems(recyclerView: RecyclerView, list: List<Team>?) {
    recyclerView.adapter?.let { adapter ->
        if (adapter is TeamAdapterContract) {
            list?.let {
                adapter.replaceItems(list)
            }
        }
    }
}

@BindingAdapter("image")
fun setImage(imageView: ImageView, urlImage: String) {
    Picasso.get().load(urlImage).into(imageView)
}

@BindingAdapter("validateText")
fun setValidateText(textView: TextView, text: String?) {
    textView.movementMethod = LinkMovementMethod.getInstance()
    textView.visibility = if (text.isNullOrBlank()) View.GONE else View.VISIBLE
    textView.text = text
}

@BindingAdapter("itemsPager")
fun setValidateText(viewPager: ViewPager, list: List<TeamEvent>?) {
    viewPager.adapter?.let { adapter ->
        if (adapter is TeamEventPagerContract) {
            list?.let {
                adapter.replaceItems(it)
            }
        }
    }
}
