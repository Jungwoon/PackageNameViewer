package com.byjw.packagenameviewer

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by jungwoon on 2017. 4. 28..
 */
class MyViewHolder(context: Context, parent: ViewGroup?, val listenerFun: ((Int) -> Unit)?)
    : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)) {

    val appIcon by lazy {
        itemView.findViewById(R.id.app_icon) as ImageView
    }

    val packageName by lazy {
        itemView.findViewById(R.id.package_name) as TextView
    }

    val appName by lazy {
        itemView.findViewById(R.id.app_name) as TextView
    }

    fun onBind(item: MyListItem, position: Int) {
        appIcon.setImageDrawable(item.appIcon)
        packageName.text = item.packageName
        appName.text = item.appName

        itemView.setOnClickListener {
            listenerFun?.invoke(position)
        }
    }
}