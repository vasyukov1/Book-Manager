package com.vasyukov.bookmanager

import android.os.Bundle

class MyBooksActivity : BaseActivity() {

    override fun getLayoutResId(): Int {
        return R.layout.activity_my_books
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Main Screen"
    }
}