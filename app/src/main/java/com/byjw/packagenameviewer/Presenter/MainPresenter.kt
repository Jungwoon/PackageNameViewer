package com.byjw.packagenameviewer.Presenter

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.pm.ResolveInfo
import com.byjw.packagenameviewer.Adapter.Contract.MyAdapterContract
import com.byjw.packagenameviewer.MyListItem

/**
 * Created by jungwoon on 2017. 4. 28..
 */
class MainPresenter : MainContract.Presenter {

    lateinit override var view: MainContract.View
    lateinit override var context: Context
    lateinit override var adapterModel: MyAdapterContract.Model

    override var adapterView: MyAdapterContract.View? = null
        set(value) {
            field = value
            field?.onClickFunc = { onClickListener(it) }
        }


    override fun loadItems() {
        val intent: Intent = Intent(Intent.ACTION_MAIN, null)
        intent.addCategory(Intent.CATEGORY_LAUNCHER) // 이 부분 세팅하지 않으면 숨어진 앱들까지 전부 나타남

        val packageManager: PackageManager = context.packageManager
        val installedAppList = packageManager.queryIntentActivities(intent, 0) as ArrayList<ResolveInfo>
        val myList: ArrayList<MyListItem> = ArrayList()

        for (list in installedAppList) {
            val packageName = list.activityInfo.packageName
            val appName = list.activityInfo.loadLabel(packageManager).toString()
            val appIcon = list.activityInfo.loadIcon(packageManager)

            myList.add(MyListItem(packageName, appName, appIcon))
        }

        adapterModel.addItems(myList)
        adapterView?.notifyAdapter()

    }

    private fun onClickListener(position: Int) {
        adapterModel.getItem(position).let {
            context.startActivity(context.packageManager.getLaunchIntentForPackage(it.packageName))
        }
    }

}