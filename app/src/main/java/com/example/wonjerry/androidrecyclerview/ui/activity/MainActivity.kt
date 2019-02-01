package com.example.wonjerry.androidrecyclerview.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.example.wonjerry.androidrecyclerview.R
import com.example.wonjerry.androidrecyclerview.ui.adapter.ExampleListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import list.Clickable
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(), Clickable {
    override fun clickItem(text: String) {
        toast(text)
    }

    private val exampleListAdapter = ExampleListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val exampleList = listOf(
            "apple",
            "banana",
            "kiwi",
            "mango",
            "pineapple",
            "watermelon"
        )
        with(recycler_view) {
            adapter = exampleListAdapter
            addItemDecoration(DividerItemDecoration(applicationContext, LinearLayoutManager.VERTICAL))
        }

        exampleList.forEach(exampleListAdapter::addItem)

        btn_add.setOnClickListener {
            exampleListAdapter.addItem("wonjae")
        }
    }
}
