package com.demo.composedemo

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.composedemo.ui.theme.ComposeDemoTheme
import kotlinx.coroutines.launch

/**
 * User: wanglei
 * Date: 2023/2/8 10:44
 * Description:
 */
class ScaffoldView {


    @Composable
    fun ScaffoldPreview() {
        val rememberScaffoldState = rememberScaffoldState()
        val scope = rememberCoroutineScope()
        val interactionSource = remember { MutableInteractionSource() }
        var selectIndex by remember {
            mutableStateOf(0)
        }
        val navList = listOf("首页", "发现", "我的")
        ComposeDemoTheme {
            Scaffold(
                scaffoldState = rememberScaffoldState,
                topBar = {
                    TopAppBar(
                        navigationIcon = {
                            IconButton(
                                onClick = {
                                    scope.launch {
                                        rememberScaffoldState.drawerState.open()
                                    }
                                }
                            ) {
                                Icon(Icons.Filled.Menu, null)
                            }
                        },
                        title = {
                            Text("stars-one的测试应用")
                        }, actions = {
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(Icons.Filled.Share, null)
                            }
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(Icons.Filled.Settings, null)
                            }
                        }
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
                    }
                },
                bottomBar = {

//                    BottomAppBar(cutoutShape = RoundedCornerShape(10)) {
//
//                    }

                    BottomNavigation() {
                        navList.forEachIndexed { index, str ->
                            BottomNavigationItem(
                                selected = index == selectIndex, onClick = { selectIndex = index },
                                icon = {
                                    Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
                                }, label = { Text(str) }
                            )
                        }
                    }
                },
                //注意此参数,可以实现图中那种被裁剪的效果,前提是上面的cutoutShape也有设置
                isFloatingActionButtonDocked = true,
                floatingActionButtonPosition = FabPosition.End,
                drawerContent = {
                    Text("这是抽屉的内容")
                },
                drawerContentColor = Color.Black,
                drawerBackgroundColor = Color.Green,
                drawerScrimColor = Color.Blue,
                drawerGesturesEnabled = true,
                drawerShape = RoundedCornerShape(topEnd =20.dp, bottomEnd = 20.dp)
//                drawerShape = RoundedCornerShape(20.dp)

            ) {
                Column() {
                    Text("我是要展示的内容${navList[selectIndex]}")

                    FloatingActionButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = null)
                    }

                    ExtendedFloatingActionButton(
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                        text = { Text("ADD TO BASKET") },
                        onClick = { /*do something*/ }
                    )
                }

            }

        }

    }


    @Preview(showBackground = true)
    @Composable
    fun NavigationPreview() {
        val interactionSource = remember { MutableInteractionSource() }

        ComposeDemoTheme {
            var selectIndex by remember {
                mutableStateOf(0)
            }
            val navList = listOf("首页", "发现", "我的")
            BottomNavigation() {
                navList.forEachIndexed { index, str ->
                    BottomNavigationItem(
                        selected = index == selectIndex, onClick = { selectIndex = index },
                        icon = {
                            Icon(imageVector = Icons.Default.Favorite, contentDescription = null)
                        }, label = { Text(str) }
                    )
                }
            }

            Text(text = "这是${navList[selectIndex]}")
        }

    }
}

