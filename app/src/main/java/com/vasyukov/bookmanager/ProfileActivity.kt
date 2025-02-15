package com.vasyukov.bookmanager

import android.os.Bundle

class ProfileActivity : BaseActivity() {

    override fun getLayoutResId(): Int {
        return R.layout.activity_profile
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.title = "Second Activity"
    }
}