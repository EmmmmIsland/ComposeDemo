package com.demo.composedemo.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material.icons.twotone.Search
import androidx.compose.material.icons.twotone.Settings
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
class ExIconView {

    @Composable
    fun exIcon() {
        val context = LocalContext.current
        Row() {
            Column() {
                Icon(painter = painterResource(id = R.drawable.icon), contentDescription = "1")
                Icon(painter = painterResource(id = R.drawable.icon), contentDescription = "1", tint = Color.Yellow)
                androidx.compose.material3.Icon(painter = painterResource(id = R.drawable.flower), contentDescription = "x1")
                Icon(bitmap = ImageBitmap.imageResource(id = R.drawable.img), contentDescription = "2")
                Icon(bitmap = ImageBitmap.imageResource(id = R.drawable.img), contentDescription = "2",tint = Color.Green)
                androidx.compose.material3.Icon(bitmap = ImageBitmap.imageResource(id = R.drawable.flower), contentDescription = "x2")
                Icon(imageVector = Icons.Filled.Search, contentDescription = "3")
                Icon(imageVector = Icons.Filled.Search, contentDescription = "3", tint = Color.Blue)
                androidx.compose.material3.Icon(imageVector = Icons.Filled.Search, contentDescription = "x3")
            }

            Column() {

                Icon(modifier = Modifier.size(80.dp), imageVector = Icons.Outlined.Settings, contentDescription = "3")
                Icon(modifier = Modifier.size(80.dp),imageVector = Icons.Filled.Settings, contentDescription = "3")
                Icon(modifier = Modifier.size(80.dp),imageVector = Icons.Sharp.Settings, contentDescription = "3")
                Icon(modifier = Modifier.size(80.dp),imageVector = Icons.TwoTone.Settings, contentDescription = "3")
                Icon(modifier = Modifier.size(80.dp),imageVector = Icons.Rounded.Settings, contentDescription = "3")

                Icon(modifier = Modifier.size(80.dp),imageVector = Icons.Outlined.Settings, contentDescription = "3", tint = Color.Blue)
                Icon(modifier = Modifier.size(80.dp),imageVector = Icons.Filled.Settings, contentDescription = "3", tint = Color.Green)
                Icon(modifier = Modifier.size(80.dp),imageVector = Icons.Sharp.Settings, contentDescription = "3", tint = Color.Yellow)
                Icon(modifier = Modifier.size(80.dp),imageVector = Icons.TwoTone.Settings, contentDescription = "3", tint = Color.Red)
                Icon(modifier = Modifier.size(80.dp),imageVector = Icons.Rounded.Settings, contentDescription = "3", tint = Color.Cyan)

            }
        }

    }
}

