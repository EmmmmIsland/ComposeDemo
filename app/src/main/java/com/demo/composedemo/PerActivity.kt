package com.demo.composedemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material.icons.twotone.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.demo.composedemo.PerActivity.Companion.TAG
import com.demo.composedemo.demo.DemoActivity
import com.demo.composedemo.ui.theme.ComposeDemoTheme


class PerActivity : ComponentActivity() {
    companion object {
        val TAG = "PerActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Greeting()

        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun Greeting() {
    val context = LocalContext.current
    Column() {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(60.dp)
                .width(200.dp)
                .background(color = Color.Yellow)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onPress = {
                            Log.i(TAG,"触摸")
                        },
                        onTap = {
                            Log.i(TAG,"点击")
                            Toast
                                .makeText(context, "点击", Toast.LENGTH_SHORT)
                                .show()
                            context.startActivity(Intent(context,MainActivity::class.java))
                        }, onDoubleTap = {
                            Log.i(TAG,"双击")
                        }, onLongPress = {
                            Log.i(TAG,"长按")
                        }
                    )
                }
        ) {
            Text(textAlign = TextAlign.Center, fontSize = 20.sp, text = "Base")
        }

        Box(
            contentAlignment = Alignment.BottomEnd,
            modifier = Modifier
                .height(60.dp)
                .width(200.dp)
                .background(color = Color.Yellow)
                .clickable(onClick = {
                    Toast
                        .makeText(context, "Demo", Toast.LENGTH_SHORT)
                        .show()
                    context.startActivity(Intent(context,DemoActivity::class.java))
                })
        ) {
            Text(textAlign = TextAlign.Center, fontSize = 20.sp, text = "Demo")

        }



        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(60.dp)
                .width(200.dp)
                .background(color = Color.Yellow)
                .combinedClickable(onClick = {
                    Toast
                        .makeText(context, "new点击", Toast.LENGTH_SHORT)
                        .show()
                })
        ) {
            Text(textAlign = TextAlign.Center, fontSize = 20.sp, text = "XXXX")
        }

        BoxWithConstraints {
            Text("My minHeight is $minHeight while my maxWidth is $maxWidth")
        }
    }
}



