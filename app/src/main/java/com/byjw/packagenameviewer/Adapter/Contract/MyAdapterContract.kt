package com.byjw.packagenameviewer.Adapter.Contract

import com.byjw.packagenameviewer.MyListItem

/**
 * Created by jungwoon on 2017. 4. 28..
 */
interface MyAdapterContract {

    interface View {

        var onClickFunc : ((Int) -> Unit)?

        fun notifyAdapter()

    }

    interface Model {

        fun addItems(itemList: ArrayList<MyListItem>)

        fun clear()

        fun getItem(position: Int): MyListItem

    }

}