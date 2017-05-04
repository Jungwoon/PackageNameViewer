package com.byjw.packagenameviewer.Presenter

import android.content.Context
import com.byjw.packagenameviewer.Adapter.Contract.MyAdapterContract

/**
 * Created by jungwoon on 2017. 4. 28..
 */
interface MainContract {

    interface View {
        fun showToast(title: String)
    }

    interface Presenter {
        var view: MainContract.View
        var context: Context
        var adapterModel: MyAdapterContract.Model
        var adapterView: MyAdapterContract.View?

        fun loadItems()
    }
}