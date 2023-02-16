package com.demo.composedemo

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.demo.composedemo.ui.theme.ComposeDemoTheme

/**
 * User: wanglei
 * Date: 2023/2/8 10:44
 * Description:
 */
class LoginView {

    /**
     * Modifier
     *  weight 如果在Row使用,就是宽度权重占1,在Column使用,则是高度权重占1
     */
    //    @Preview(showBackground = true)
    @Composable
    fun LoginPreview() {
        val context = LocalContext.current
        var name by remember {
            mutableStateOf("")
        }
        var pwd by remember {
            mutableStateOf("")
        }

        val pwdVisualTransformation = PasswordVisualTransformation()
        var showPwd by remember {
            mutableStateOf(true)
        }

        val transformation = if (showPwd) pwdVisualTransformation else VisualTransformation.None

        ComposeDemoTheme {
            Box(Modifier.fillMaxSize()) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    painter = painterResource(id = R.drawable.flower),
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null
                )
                Text(
                    text = "注册",
                    color = Color.White,
                    fontSize = 40.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                )
                Column() {
                    Spacer(modifier = Modifier.weight(1f))
                    Column(
                        modifier = Modifier
                            .weight(3f)
                            .background(Color.Red)
                            .padding(40.dp)
                            .fillMaxWidth()
                    ) {
                        Column() {
                            TextField(
                                modifier = Modifier.fillMaxWidth(),
                                value = name,
                                placeholder = {
                                    Text("请输入用户名")
                                },
                                onValueChange = { str -> name = str },
                                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.AccountBox,
                                        contentDescription = null
                                    )
                                })
                            TextField(
                                value = pwd, onValueChange = { str -> pwd = str },
                                modifier = Modifier.fillMaxWidth(),
                                placeholder = {
                                    Text("请输入密码")
                                },
                                visualTransformation = transformation,
                                colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Lock,
                                        contentDescription = null
                                    )
                                }, trailingIcon = {
                                    if (showPwd) {
                                        IconButton(onClick = { showPwd = !showPwd }) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.next_pressed),
                                                contentDescription = null,
                                                Modifier.size(30.dp)
                                            )
                                        }
                                    } else {
                                        IconButton(onClick = { showPwd = !showPwd }) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.next_pressed),
                                                contentDescription = null,
                                                Modifier.size(30.dp)
                                            )
                                        }
                                    }
                                }
                            )
                            /**
                             * Arrangement.Start
                             * Arrangement.END
                             * Arrangement.Center
                             * Arrangement.SpaceAround
                             * Arrangement.SpaceBetween
                             * Arrangement.SpaceEvenly
                             */
                            Row(horizontalArrangement = Arrangement.SpaceBetween,modifier = Modifier.fillMaxWidth()) {
                                Text(text = "快捷登录", fontSize = 16.sp, color = Color.Gray)
                                Text(text = "忘记密码", fontSize = 16.sp, color = Color.Gray)
                            }

                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                onClick = {
                                    if (name == "test" && pwd == "123") {
                                        Toast.makeText(context, "登录成功", Toast.LENGTH_SHORT).show()
                                    } else {
                                        Toast.makeText(context, "登录失败", Toast.LENGTH_SHORT).show()
                                    }
                                },
                                shape = RoundedCornerShape(50),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xff5c59fe)),
                                contentPadding = PaddingValues(12.dp, 16.dp)
                            ) {
                                Text("登录", color = Color.White, fontSize = 18.sp)
                            }



                            Row(horizontalArrangement = Arrangement.SpaceBetween,verticalAlignment = Alignment.CenterVertically) {
                                Row(
                                    Modifier
                                        .height(1.dp)
                                        .weight(1f)
                                        .background(Color(0xFFCFC5C5))
                                        .padding(end = 10.dp)){}
                                Text(text = "第三方登录", fontSize = 16.sp, color = Color.Gray)
                                Row(
                                    Modifier
                                        .height(1.dp)
                                        .weight(1f)
                                        .background(Color(0xFFCFC5C5))
                                        .padding(start = 10.dp)){}
                            }

                            Spacer(modifier = Modifier.height(20.dp))
                            Row(Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
                                repeat(3){
                                    Column(Modifier.weight(1f),verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally) {
                                        Image(modifier = Modifier.size(50.dp),painter = painterResource(id = R.drawable.next_pressed), contentDescription = null)
                                        Text("QQ", color = Color(0xffcdcdcd), fontSize = 16.sp,fontWeight = FontWeight.Bold)
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }


    }
}

