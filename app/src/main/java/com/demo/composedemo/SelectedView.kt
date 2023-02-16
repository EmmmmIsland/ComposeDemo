package com.demo.composedemo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.demo.composedemo.ui.theme.ComposeDemoTheme

/**
 * User: wanglei
 * Date: 2023/2/8 10:44
 * Description:
 */
class SelectedView {


    @Preview(showBackground = true)
    @Composable
    fun SelectedPreview() {
        ComposeDemoTheme {
            val option1 = Color.Red
            val option2 = Color.Blue
            var selectedOption by remember { mutableStateOf(option1) }
            Column {
                Text("Selected: $selectedOption")
                Row {
                    listOf(option1, option2).forEach { color ->
                        val selected = selectedOption == color
                        Box(
                            Modifier
                                .size(100.dp)
                                .background(color = color)
                                .selectable(
                                    selected = selected,
                                    onClick = { selectedOption = color }
                                )
                        ) {
                            if (selected) Text(text = "已选", color = Color.White)
                        }
                    }
                }


                var checked by remember { mutableStateOf(false) }
// content that you want to make toggleable
                Text(
                    modifier = Modifier.toggleable(
                        value = checked,
                        onValueChange = { checked = it }),
                    text = checked.toString()
                )

                Box(Modifier.height(100.dp).aspectRatio(2f).width(100.dp).background(Color.Green))

                Box(
                    Modifier.scale(scaleX = 0.2f, scaleY = 0.5f)
                        .background(Color.Black)
                        .size(100.dp, 100.dp)
                )

            }
        }
    }
}

