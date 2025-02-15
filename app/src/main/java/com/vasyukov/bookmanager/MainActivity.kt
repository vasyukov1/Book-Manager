package com.vasyukov.bookmanager

import android.os.Bundle

class MainActivity : BaseActivity() {

    override fun getLayoutResId(): Int {
        return R.layout.activity_news
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Main Screen"
    }

}