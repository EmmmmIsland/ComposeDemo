package com.demo.composedemo.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.core.view.WindowCompat
import com.demo.composedemo.view.BackView
import com.example.jetnews.DemoApplication


class DemoActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 内容是否延伸到状态bar
        WindowCompat.setDecorFitsSystemWindows(window, true)

        val appContainer = (application as DemoApplication).container
        setContent {
            val widthSizeClass = calculateWindowSizeClass(this).widthSizeClass
            Column() {
                BackView().Back {
                    this@DemoActivity.finish()
                }
                HomeApp(appContainer, widthSizeClass)
            }

        }
    }
}