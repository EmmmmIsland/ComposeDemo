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
import androidx.compose.ui.graphics.vector.ImageVector
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
import androidx.lifecycle.MutableLiveData
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.demo.composedemo.ui.theme.ComposeDemoTheme

/**
 * User: wanglei
 * Date: 2023/2/8 10:44
 * Description:
 */
class LoginStateView {

    /**
     * Modifier
     *  weight 如果在Row使用,就是宽度权重占1,在Column使用,则是高度权重占1
     */
    //    @Preview(showBackground = true)
    @Composable
    fun LoginStatePreview() {

//        val mlivedate = MutableLiveData("myusername")
//
//        //name为State<String>对象,只能读数值,不能修改数值
//        var name = mlivedate.observeAsState(initial = "")

        var name by remember {
            mutableStateOf("")
        }

        var pwd by remember {
            mutableStateOf("")
        }

        Column() {
            InputText(
                imageVector = Icons.Default.AccountBox,
                tip = "请输入用户名",
                value = name,
                onValueChange = { name = it })
            InputText(
                imageVector = Icons.Default.Lock,
                tip = "请输入密码",
                value = pwd,
                onValueChange = { pwd = it },isPwd = true)
        }
    }

    @Composable
    fun InputText(
        imageVector: ImageVector,
        tip: String,
        value: String,
        onValueChange: (String) -> Unit,
        isPwd: Boolean = false
    ) {

        val pwdVisualTransformation = PasswordVisualTransformation()
        var showPwd by remember {
            mutableStateOf(true)
        }
        val transformation = if (showPwd) pwdVisualTransformation else VisualTransformation.None

        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            placeholder = {
                Text(tip)
            },
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
            leadingIcon = {
                Icon(
                    imageVector = imageVector,
                    contentDescription = null
                )
            },
            //密码相关配置
            visualTransformation = if (isPwd) transformation else VisualTransformation.None,
            trailingIcon = {
                if (isPwd) {
                    IconButton(onClick = { showPwd = !showPwd }) {
                        Icon(
                            painter = painterResource(id = R.drawable.next_pressed),
                            contentDescription = null,
                            Modifier.size(30.dp)
                        )
                    }
                }
            },
        )
    }
}

