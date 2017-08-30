package com.byjw.packagenameviewer

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.byjw.kotlinpractice.View.MyAdapter
import com.byjw.packagenameviewer.Presenter.MainContract
import com.byjw.packagenameviewer.Presenter.MainPresenter
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

class MainActivity : AppCompatActivity(), MainContract.View {
    val TAG = "MainActivity"

    val fab by lazy {
        findViewById(R.id.fab) as FloatingActionButton
    }

    val recyclerView by lazy {
        findViewById(R.id.recycler_view) as RecyclerView
    }

    val adView by lazy {
        findViewById(R.id.adView) as AdView
    }

    private lateinit var mainPresenter: MainPresenter

    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        adView.loadAd(AdRequest.Builder().build())

        myAdapter = MyAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdapter


        mainPresenter = MainPresenter().apply {
            view = this@MainActivity
            context = this@MainActivity
            adapterModel = myAdapter
            adapterView = myAdapter
        }

        mainPresenter?.loadItems()

        fab.setOnClickListener { view ->
            mainPresenter?.loadItems()
            showToast("Refresh")
        }
    }

    override fun showToast(title: String) {
        Toast.makeText(this, title, Toast.LENGTH_SHORT).show()
    }
}