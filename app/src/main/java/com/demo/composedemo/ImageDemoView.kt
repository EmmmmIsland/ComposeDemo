package com.demo.composedemo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.demo.composedemo.ui.theme.ComposeDemoTheme

/**
 * User: wanglei
 * Date: 2023/2/8 10:44
 * Description:
 */
class ImageDemoView {

        @Preview(showBackground = true)
    @Composable
    fun ImagePreview() {

        ComposeDemoTheme {
            Row() {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    //为了便于区分,这里使用Modifier添加了个黄色的背景
                    Image(modifier = Modifier
                        .size(200.dp, 150.dp)
                        .background(color = Color.Yellow),
                        painter = painterResource(id = R.drawable.flower),
                        contentDescription = null,
                        contentScale = ContentScale.Crop)

                    Image(modifier = Modifier
                        .size(200.dp, 150.dp)
                        .background(color = Color.Yellow),
                        painter = painterResource(id = R.drawable.flower),
                        contentDescription = null,
                        contentScale = ContentScale.Inside)

                    Image(modifier = Modifier
                        .size(200.dp, 150.dp)
                        .background(color = Color.Yellow),
                        painter = painterResource(id = R.drawable.flower),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds)

                    Image(modifier = Modifier
                        .size(200.dp, 150.dp)
                        .background(color = Color.Yellow),
                        painter = painterResource(id = R.drawable.flower),
                        contentDescription = null,
                        contentScale = ContentScale.FillHeight)

                    Image(modifier = Modifier
                        .size(200.dp, 150.dp)
                        .background(color = Color.Yellow),
                        painter = painterResource(id = R.drawable.flower),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth)

                    Image(modifier = Modifier
                        .size(200.dp, 150.dp)
                        .background(color = Color.Yellow),
                        painter = painterResource(id = R.drawable.flower),
                        contentDescription = null,
                        alpha = 0.5f)



                }

                Column(Modifier.verticalScroll(rememberScrollState())) {
                    Image(modifier = Modifier
                        .size(200.dp, 150.dp),
                        painter = painterResource(id = R.drawable.flower),
                        contentDescription = null,
                        alpha = 1f,
                        colorFilter = ColorFilter.tint(color = Color.Green, BlendMode.SrcAtop)
                    )

                    /**
                     * error？？？
                     */
                    Image(
                        painter = rememberImagePainter(data = "https://lmg.jj20.com/up/allimg/1114/041621122252/210416122252-1-1200.jpg",
                            builder = {
                                //占位图
                                placeholder(R.drawable.photo_box)
                                //淡出效果
                                crossfade(true)
                                //圆形效果
                                transformations(CircleCropTransformation())
                            }),
                        contentDescription = null,
                        modifier = Modifier.size(128.dp)
                    )


                }
            }


        }
    }
}

