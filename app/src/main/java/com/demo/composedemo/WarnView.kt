package com.demo.composedemo

import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.composedemo.ui.theme.ComposeDemoTheme

/**
 * User: wanglei
 * Date: 2023/2/8 10:44
 * Description:
 */
class WarnView {


    @Preview(showBackground = true)
    @Composable
    fun WarnPreview() {
        val interactionSource = remember { MutableInteractionSource() }

        ComposeDemoTheme {
            Column {
                Box(
                    Modifier
                        .size(100.dp)
                        .background(Color.Green)
                        .padding(16.dp)
                )
                Box(
                    Modifier
                        .size(100.dp)
                        .padding(16.dp)
                        .background(Color.Green)
                )

                Box(
                    Modifier
                        .sizeIn(minWidth = 40.dp, minHeight = 40.dp)
                        .wrapContentSize(Alignment.TopCenter)
                        .size(20.dp)
                        .background(Color.Blue)
                )

                Box(
                    Modifier
                        .sizeIn(minWidth = 40.dp, minHeight = 40.dp)
                        .size(20.dp)
                        .background(Color.Blue)
                )

                Column {
                    Text(
                        text = "Click me and my neighbour will indicate as well!",
                        modifier = Modifier
                            // clickable will dispatch events using MutableInteractionSource and show ripple
                            .clickable(
                                interactionSource = interactionSource,
                                indication = rememberRipple()
                            ) {
                                /**do something */
                            }
                            .padding(10.dp)
                    )
                    Spacer(Modifier.requiredHeight(10.dp))
                    Text(
                        text = "I'm neighbour and I indicate when you click the other one",
                        modifier = Modifier
                            // this element doesn't have a click, but will show default indication from the
                            // CompositionLocal as it accepts the same MutableInteractionSource
                            .indication(interactionSource, LocalIndication.current)
                            .padding(10.dp)
                    )
                }


                val gradientBrush = Brush.horizontalGradient(
                    colors = listOf(Color.Red, Color.Blue, Color.Green),
                    startX = 0.0f,
                    endX = 500.0f,
                    tileMode = TileMode.Repeated
                )
                Text(
                    "Text with gradient border",
                    modifier = Modifier.padding(10.dp).border(width = 2.dp, brush = gradientBrush, shape = CircleShape)
                        .padding(10.dp)
                )

            }
        }
    }
}

