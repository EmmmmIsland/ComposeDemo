package com.demo.composedemo.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.demo.composedemo.R

/**
 * User: wanglei
 * Date: 2023/2/8 10:44
 * Description:布局位置相关
 */
class ExLayoutView {

    @Composable
    fun exLayout() {
        val context = LocalContext.current
        Column() {
            Row(
                Modifier
                    .background(color = Color.Yellow)
                    .width(800.dp)
                    .height(400.dp),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.End
            ) {
                Image(painter = painterResource(id = R.drawable.flower), contentDescription = "image")
                Column {
                    Text(text = "verticalAlignment = Alignment.Top",Modifier.background(color = Color.Green))
                    Text(text = "horizontalArrangement = Arrangement.End",Modifier.background(color = Color.White))
                }
            }

            Row(
                Modifier
                    .background(color = Color.Blue)
                    .width(800.dp)
                    .height(400.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(painter = painterResource(id = R.drawable.flower), contentDescription = "image")
                Column {
                    Text(text = "verticalAlignment = Alignment.CenterVertically",Modifier.background(color = Color.Green))
                    Text(text = "horizontalArrangement = Arrangement.Center",Modifier.background(color = Color.White))
                }
            }

        }

    }
}

