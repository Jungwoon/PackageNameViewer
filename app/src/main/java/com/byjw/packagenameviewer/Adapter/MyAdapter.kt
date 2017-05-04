package com.byjw.kotlinpractice.View

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.byjw.packagenameviewer.Adapter.Contract.MyAdapterContract
import com.byjw.packagenameviewer.MyListItem
import com.byjw.packagenameviewer.MyViewHolder

/**
 * Created by jungwoon on 2017. 4. 27..
 */
class MyAdapter(val context: Context) : RecyclerView.Adapter<MyViewHolder>(), MyAdapterContract.Model, MyAdapterContract.View {
    private lateinit var itemList: ArrayList<MyListItem>

    override var onClickFunc: ((Int) -> Unit)? = null

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        itemList[position].let {
            holder?.onBind(it, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(context, parent, onClickFunc)

    override fun getItemCount() = itemList.size

    override fun getItem(position: Int) = itemList[position]

    override fun addItems(itemList: ArrayList<MyListItem>) {
        this.itemList = itemList
    }

    override fun notifyAdapter() {
        notifyDataSetChanged()
    }

    override fun clear() {
        itemList.clear()
    }

}