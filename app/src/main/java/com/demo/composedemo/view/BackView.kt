package com.demo.composedemo.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.composedemo.PerActivity

/**
 * User: wanglei
 * Date: 2023/2/8 10:44
 * Description:
 */
class BackView {

    @Composable
    fun Back(finishActivity:()->Unit) {
        val context = LocalContext.current
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .background(color = Color.Yellow)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onPress = {
                            Log.i("Back", "触摸")
                        },
                        onTap = {
                            Log.i(PerActivity.TAG, "点击")
                            finishActivity()
                        }, onDoubleTap = {
                            Log.i(PerActivity.TAG, "双击")
                        }, onLongPress = {
                            Log.i(PerActivity.TAG, "长按")
                        }
                    )
                }
        ) {
            Text(textAlign = TextAlign.Center, fontSize = 20.sp, text = "Back")
        }
    }
}

