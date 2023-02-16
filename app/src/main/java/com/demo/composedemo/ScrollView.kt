package com.demo.composedemo

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.composedemo.ui.theme.ComposeDemoTheme
import kotlin.math.roundToInt

/**
 * User: wanglei
 * Date: 2023/2/8 10:44
 * Description:
 */
class ScrollView {


    @Preview(showBackground = true)
    @Composable
    fun ScrollPreview() {
        val interactionSource = remember { MutableInteractionSource() }

        ComposeDemoTheme {
            Column(Modifier.verticalScroll(rememberScrollState(), enabled = true, reverseScrolling = false,flingBehavior =  ScrollableDefaults.flingBehavior())) {
                repeat(10){
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    ){
                        Text(text = "测试$it")
                    }
                }
            }
        }


        val offset = remember { mutableStateOf(0f) }
        Box(
            Modifier
                .size(150.dp)
                .scrollable(
                    orientation = Orientation.Vertical,
                    // state for Scrollable, describes how consume scroll amount
                    state = rememberScrollableState { delta ->
                        offset.value = offset.value + delta // update the state
                        delta // indicate that we consumed all the pixels available
                    }
                )
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Text(offset.value.roundToInt().toString(), style = TextStyle(fontSize = 32.sp))
        }
    }
}

