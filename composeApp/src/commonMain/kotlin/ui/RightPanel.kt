package ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.util.fastJoinToString
import manager.DataManager
import manager.execKeyEvent

/**
 * author       : wangyincan
 * email        : wangyincan@corp.netease.com
 * date         : 2024/4/3
 * description  :
 */

@Composable
fun RightPanel() {
    var outputString by remember { mutableStateOf(DataManager.outStrings) }
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        KeyButton("上", onClick = {
            execKeyEvent(19)
        })
        Row {
            KeyButton("左", onClick = {
                execKeyEvent(21)
            })
            KeyButton("OK", onClick = {
                execKeyEvent(23)
            })
            KeyButton("右", onClick = {
                execKeyEvent(22)
            })
        }
        KeyButton("下", onClick = {
            execKeyEvent(20)
        })
        Row {
            KeyButton("home", onClick = {
                execKeyEvent(3)
            })
            KeyButton("返回", onClick = {
                execKeyEvent(4)
            })
            KeyButton("菜单", onClick = {
                execKeyEvent(1)
            })
        }

        Text(text = outputString.fastJoinToString { "" }, modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun KeyButton(name: String, onClick: () -> Unit) {
    Button(onClick = { onClick.invoke() }) {
        Text(name)
    }
}