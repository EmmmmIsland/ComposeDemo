package com.demo.composedemo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.*
import com.demo.composedemo.ui.theme.ComposeDemoTheme

/**
 * User: wanglei
 * Date: 2023/2/8 10:44
 * Description:
 */
class TextFiledDemoView {
    /**
    // 输入的文字颜色
    textColor: Color = LocalContentColor.current.copy(LocalContentAlpha.current),

    // 禁用 TextField 时，已有的文字颜色
    disabledTextColor: Color = textColor.copy(ContentAlpha.disabled),

    // 输入框的背景颜色，当设置为 Color.Transparent 时，将透明
    backgroundColor: Color = MaterialTheme.colors.onSurface.copy(alpha = BackgroundOpacity),

    // 输入框的光标颜色
    cursorColor: Color = MaterialTheme.colors.primary,

    // 当 TextField 的 isError 参数为 true 时，光标的颜色
    errorCursorColor: Color = MaterialTheme.colors.error,

    // 当输入框处于焦点时，底部指示器的颜色
    focusedIndicatorColor: Color = MaterialTheme.colors.primary.copy(alpha = ContentAlpha.high),

    // 当输入框不处于焦点时，底部指示器的颜色
    unfocusedIndicatorColor: Color = MaterialTheme.colors.onSurface.copy(alpha = UnfocusedIndicatorLineOpacity),

    // 禁用 TextField 时，底部指示器的颜色
    disabledIndicatorColor: Color = unfocusedIndicatorColor.copy(alpha = ContentAlpha.disabled),

    // 当 TextField 的 isError 参数为 true 时，底部指示器的颜色
    errorIndicatorColor: Color = MaterialTheme.colors.error,

    // TextField 输入框前头的颜色
    leadingIconColor: Color = MaterialTheme.colors.onSurface.copy(alpha = IconOpacity),

    // 禁用 TextField 时 TextField 输入框前头的颜色
    disabledLeadingIconColor: Color = leadingIconColor.copy(alpha = ContentAlpha.disabled),

    // 当 TextField 的 isError 参数为 true 时 TextField 输入框前头的颜色
    errorLeadingIconColor: Color = leadingIconColor,

    // TextField 输入框尾部的颜色
    trailingIconColor: Color = MaterialTheme.colors.onSurface.copy(alpha = IconOpacity),

    // 禁用 TextField 时 TextField 输入框尾部的颜色
    disabledTrailingIconColor: Color = trailingIconColor.copy(alpha = ContentAlpha.disabled),

    // 当 TextField 的 isError 参数为 true 时 TextField 输入框尾部的颜色
    errorTrailingIconColor: Color = MaterialTheme.colors.error,

    // 当输入框处于焦点时，Label 的颜色
    focusedLabelColor: Color = MaterialTheme.colors.primary.copy(alpha = ContentAlpha.high),

    // 当输入框不处于焦点时，Label 的颜色
    unfocusedLabelColor: Color = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium),

    // 禁用 TextField 时，Label 的颜色
    disabledLabelColor: Color = unfocusedLabelColor.copy(ContentAlpha.disabled),

    // 当 TextField 的 isError 参数为 true 时，Label 的颜色
    errorLabelColor: Color = MaterialTheme.colors.error,

    // Placeholder 的颜色
    placeholderColor: Color = MaterialTheme.colors.onSurface.copy(ContentAlpha.medium),

    // 禁用 TextField 时，placeholder 的颜色
    disabledPlaceholderColor: Color = placeholderColor.copy(ContentAlpha.disabled)
     */
    //    @Preview(showBackground = true)
    @Composable
    fun TextFiledPreview() {
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

        var text by remember {
            mutableStateOf("")
        }
        var isShowPwd by remember { mutableStateOf(false) }
        val myVisualTransformation =
            if (isShowPwd) VisualTransformation.None else PasswordVisualTransformation()


        val cardVisualTransformation = CardVisualTransformation()
        ComposeDemoTheme {
            Column() {
                TextField(value = "", onValueChange = {}, label = { Text("用户名") })
                TextField(
                    value = "",
                    onValueChange = {},
                    label = {
                        Icon(
                            painter = painterResource(id = R.drawable.photo_box),
                            null
                        )
                    })

                OutlinedTextField(value = "", onValueChange = {}, label = { Text("用户名") })

                BasicTextField(value = "", onValueChange = {})

                TextField(
                    value = text,
                    singleLine = true,
                    onValueChange = {
                        text = it
                    },
                    visualTransformation = myVisualTransformation,
                    leadingIcon = {
                        Icon(Icons.Filled.Search, null)
                    },
                    trailingIcon = {
                        IconButton(onClick = { isShowPwd = !isShowPwd }) {
                            Icon(Icons.Filled.Search, null)
                        }

                    },
                )


                TextField(
                    value = text,
                    label={
                        Text(text = "卡号")
                    },
                    colors=TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent),
                    onValueChange = { value -> text = value },
                    visualTransformation = cardVisualTransformation
                )

                val focusManager = LocalFocusManager.current
                TextField(
                    value = text,
                    label = {Text(text = "用户")},
                    onValueChange = { value -> text = value },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(onNext = {
                        //移动焦点在下方
                        focusManager.moveFocus(FocusDirection.Down)
                    })
                )

                TextField(
                    value = text,
                    label = {Text(text = "密码")},
                    onValueChange = { value -> text = value },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone  = {
                        //移动焦点在下方
                        focusManager.clearFocus()
                    })
                )

            }

        }
    }
}

