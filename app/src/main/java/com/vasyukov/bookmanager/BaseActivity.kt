package com.vasyukov.bookmanager

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

abstract class BaseActivity : AppCompatActivity() {

    abstract fun getLayoutResId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_base)

        val contentFrame = findViewById<FrameLayout>(R.id.content)
        layoutInflater.inflate(getLayoutResId(), contentFrame, true)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            val targetActivity = when (item.itemId) {
                R.id.navigate_news -> MainActivity::class.java
                R.id.navigate_my_books -> MyBooksActivity::class.java
                R.id.navigate_profile -> ProfileActivity::class.java
                else -> null
            }

            if (targetActivity != null && this::class.java != targetActivity) {
                startActivity(Intent(this, targetActivity))
                overridePendingTransition(0, 0)
            }
            true
        }

        when (this) {
            is MainActivity -> bottomNavigationView.selectedItemId = R.id.navigate_news
            is MyBooksActivity -> bottomNavigationView.selectedItemId = R.id.navigate_my_books
            is ProfileActivity -> bottomNavigationView.selectedItemId = R.id.navigate_profile
        }
    }
}