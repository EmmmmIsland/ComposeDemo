package com.demo.composedemo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import com.demo.composedemo.ui.theme.ComposeDemoTheme
import com.demo.composedemo.view.BackView
import com.demo.composedemo.view.ExIconView
import com.demo.composedemo.view.ExLayoutView


class MainActivity : ComponentActivity() {
    companion object {
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            ComposeDemoTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//                    Greeting("Android")
//                }
//            }
//            DefaultPreview()
//            IconDemo()
//            ShapeDemo()
//            ButtonDemo()
//            TextFiledDemoView().TextFiledPreview()
//            TextFiledPreview()
//            ImageDemoView().ImagePreview()
//            LoginView().LoginPreview()
//            WarnView().WarnPreview()
//            ScrollView().ScrollPreview()
//            SelectedView().SelectedPreview()
//            ScaffoldView().ScaffoldPreview()
//            ScaffoldView().NavigationPreview()
//            Column() {
//                BackView().Back(finishActivity = { this@MainActivity.finish() })
//                LoginStateView().LoginStatePreview()
//            }

//            ExLayoutView().exLayout()
            ExIconView().exIcon()
        }

    }
}


/**
 * collectIsPressedAsState ????????????
 * collectIsDraggedAsState ????????????
 * collectIsFocusedAsState ????????????
 */
@Preview(showBackground = true)
@Composable
fun ShapeDemo() {
    val context = LocalContext.current
    var btnState by remember {
        mutableStateOf(true)
    }
    val myInteractionSource = remember {
        MutableInteractionSource()
    }
    val pressState = myInteractionSource.collectIsPressedAsState()

    Toast.makeText(context,"${pressState.value}",Toast.LENGTH_SHORT).show()
    ComposeDemoTheme {
        Column() {
            Button(
                modifier = Modifier.size(300.dp,100.dp),
                onClick = { /*TODO*/ },
                elevation = ButtonDefaults.elevation(4.dp, 10.dp, 0.dp),
                shape = RoundedCornerShape(topStart = 5.dp,topEnd = 6.dp,bottomEnd = 10.dp,bottomStart = 10.dp),
            ) {
                Text(text = AnnotatedString(
                    text = "shape",
                    spanStyle = SpanStyle(color = Red, fontSize = 40.sp)
                ))
            }

            Button(
                modifier = Modifier.size(50.dp,50.dp),
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(50),
            ) {
                Text(text = "")
            }

            //??????????????????,???????????????50%????????????
            Button(
                modifier = Modifier.size(50.dp,50.dp),
                onClick = { /*TODO*/ },
                shape = CutCornerShape(50.dp),
            ) {
                Text(text = "")
            }

            //?????????????????????
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(topStart = 20.dp),
            ) {
                Text(text = "??????")
            }

            //???????????????50%
            Button(
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(50),
                border = BorderStroke(1.dp, Color.Green),
                colors = ButtonDefaults.buttonColors(),
            ) {
                Text(text = "??????111")
            }

            Button(
                enabled = btnState,
                modifier = Modifier.size(200.dp,100.dp),
                onClick = { btnState = false },
                shape = CutCornerShape(25),
                border = BorderStroke(1.dp, Color.Green),
                colors = ButtonDefaults.buttonColors(Yellow, Red, Blue, Green),
                interactionSource = myInteractionSource
            ) {
                Text(text = "??????111")
            }

        }
    }
}

@Composable
fun ButtonDemo() {
    val context = LocalContext.current
    ComposeDemoTheme {
        Column() {
            Button(onClick = { println("???????????????")}){
                Icon(Icons.Default.Search,contentDescription = null)
                Text(text = "??????")
            }

            Button(
                enabled = true,
                onClick = { /*TODO*/ },
                elevation = ButtonDefaults.elevation(4.dp, 10.dp, 0.dp)
            ) {
                Text(text = AnnotatedString(
                    text = "??????",
                    spanStyle = SpanStyle(color = Red, fontSize = 40.sp)
                ))
            }


            Button(
                enabled = false,
                onClick = { /*TODO*/ },
                elevation = ButtonDefaults.elevation(4.dp, 10.dp, 0.dp)
            ) {
                Text(text = AnnotatedString(
                    text = "??????",
                    spanStyle = SpanStyle(color = Red, fontSize = 40.sp)
                ))
            }


            IconButton(onClick = {
                Toast.makeText(context,"IconButton",Toast.LENGTH_SHORT).show()
            }) {
                Icon(Icons.Rounded.Settings, contentDescription = null, tint = Color.Black)
            }

            TextButton(onClick = { Toast.makeText(context,"TextButton",Toast.LENGTH_SHORT).show()}) {
                Icon(Icons.Default.Search,contentDescription = null)
                Text(text = "??????")
            }

            OutlinedButton(onClick = { Toast.makeText(context,"OutlinedButton",Toast.LENGTH_SHORT).show() }) {
                Text(text = "??????")
            }
        }
    }
}

@Composable
fun IconDemo() {
    val context = LocalContext.current
    ComposeDemoTheme {
        Column() {
            Row() {
                Icon(Icons.Outlined.Settings, contentDescription = null, tint = Color.Red)
                Icon(Icons.Filled.Settings, contentDescription = null, tint = Color.Blue)
                Icon(Icons.Sharp.Settings, contentDescription = null, tint = Color.Green)
                Icon(Icons.TwoTone.Settings, contentDescription = null, tint = Color.Red)
                IconButton(onClick = {
                    Toast.makeText(context,"click",Toast.LENGTH_SHORT).show()
                }) {
                    Icon(Icons.Rounded.Settings, contentDescription = null, tint = Color.Black)
                }
            }
            Icon(painter = painterResource(id = R.drawable.photo_box), null)
            Icon(Icons.Filled.Search, null)


        }
    }
}

/**
 * ????????????????????????
 */
@Composable
fun textDemo() {
    val context = LocalContext.current
    ComposeDemoTheme {
        Column() {
            //????????????
            TextButton(onClick = {
                Toast.makeText(context, "login success", Toast.LENGTH_SHORT).show()
            }) {


                Text(buildAnnotatedString {
                    withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                        //??????Hello???????????????
                        withStyle(style = SpanStyle(color = Blue, fontSize = 40.sp)) {
                            append("Hello")
                        }
                        withStyle(style = SpanStyle(color = Red)) {
                            append("word")
                        }
                    }
                })
            }
            Text(
                buildAnnotatedString {
                    withStyle(style = ParagraphStyle(lineHeight = 30.sp)) {
                        //??????Hello???????????????
                        withStyle(style = SpanStyle(color = Blue, fontSize = 40.sp)) {
                            append("Hello")
                        }
                        withStyle(style = SpanStyle(color = Red)) {
                            append("word")
                        }
                    }
                },
                Modifier.clickable {
                    Toast.makeText(context, "XXXXXXXXXXX", Toast.LENGTH_SHORT).show()
                })
            /**
             * ????????????   offset??????????????????????????????
             */
            ClickableText(
                text = AnnotatedString(
                    text = "Click Me",
                    spanStyle = SpanStyle(color = Red, fontSize = 40.sp)
                ),
                onClick = { offset ->
                    Toast.makeText(context, "XXXXXXXXXXX " + offset, Toast.LENGTH_SHORT).show()
                }
            )
            Text(text = AnnotatedString(text = "word", spanStyle = SpanStyle(color = Red)))
            //????????????
            Text(text = "Hello world", color = Color.Blue)
            //????????????,sp?????????????????????
            Text("Hello World", fontSize = 30.sp)
            //??????
            Text("Hello World", fontStyle = FontStyle.Italic)
            //????????????
            Text("Hello World", fontWeight = FontWeight.Bold)
            //????????????(???????????????) repeat??????????????????,???????????????20???Hello world??????????????????
            SelectionContainer {
                Text(
                    text = "Hello world".repeat(80),
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
            }


            val annotatedText = buildAnnotatedString {
                append("Click ")

                //??????????????????????????????
                pushStringAnnotation(tag = "URL", annotation = "https://developer.android.com")
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp
                    )
                ) {
                    append("here")
                }
                //????????????
                pop()
            }

            ClickableText(
                text = annotatedText,
                onClick = { offset ->
                    val annotationList = annotatedText.getStringAnnotations(
                        tag = "URL",
                        start = offset,
                        end = offset
                    )
                    //firstOrNull??????List?????????????????????,?????????????????????null
                    annotationList.firstOrNull()?.let { annotation ->
                        val url = annotation.item
                        //?????????????????????...
                        Toast.makeText(context, url, Toast.LENGTH_SHORT).show()
                    }
                }
            )


        }
    }
}

@Composable
fun DefaultPreview() {
    /**
     * how to get context in jetpack-compose
     * https://stackoverflow.com/questions/58743541/how-to-get-context-in-jetpack-compose
     */
    val context = LocalContext.current
    var name by remember {
        mutableStateOf("")
    }
    var pwd by remember {
        mutableStateOf("")
    }

    ComposeDemoTheme {
        Column() {
            Row() {
                Text(text = "?????????")
                TextField(value = name, onValueChange = { str -> name = str })
            }
            Row() {
                Text(text = "??????")
                TextField(value = pwd, onValueChange = { str -> pwd = str })
            }
            TextButton(onClick = {
                if (name == "wl" && pwd == "123") {
                    Toast.makeText(context, "login success", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "login fail", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text(text = "??????")
            }
        }

    }
}