package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import manager.execKeyEvent

/**
 * author       : wangyincan
 * email        : wangyincan@corp.netease.com
 * date         : 2024/4/3
 * description  :
 */

@Composable
fun RightPanel() {
    var outputString by remember { mutableStateOf(true) }
    Column(
        Modifier.height(IntrinsicSize.Min).padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier.size(200.dp).clip(CircleShape).background(Color.Black)
                .padding(8.dp),
        ) {
            KeyButton("OK",
                modifier = Modifier.size(70.dp).clip(CircleShape).align(Alignment.Center),
                onClick = {
                    execKeyEvent(23)
                    outputString = outputString.not()
                })

            KeyButton(
                "上",
                modifier = Modifier.size(40.dp).align(Alignment.TopCenter),
                Icons.Filled.KeyboardArrowUp,
                onClick = {
                    execKeyEvent(19)
                    outputString = outputString.not()
                })

            KeyButton("下",
                modifier = Modifier.size(40.dp).align(Alignment.BottomCenter),
                Icons.Filled.KeyboardArrowDown,
                onClick = {
                    execKeyEvent(20)
                    outputString = outputString.not()
                })

            KeyButton("左",
                modifier = Modifier.size(40.dp).align(Alignment.CenterStart),
                Icons.Filled.KeyboardArrowLeft,
                onClick = {
                    execKeyEvent(21)
                    outputString = outputString.not()
                })

            KeyButton("右",
                modifier = Modifier.size(40.dp).align(Alignment.CenterEnd),
                Icons.Filled.KeyboardArrowRight,
                onClick = {
                    execKeyEvent(22)
                    outputString = outputString.not()
                })
        }

        Spacer(Modifier.size(8.dp))

        Row(Modifier.height(IntrinsicSize.Min)) {
            KeyButton("home", onClick = {
                execKeyEvent(3)
                outputString = outputString.not()
            })
            Spacer(Modifier.size(8.dp))
            KeyButton("返回", onClick = {
                execKeyEvent(4)
                outputString = outputString.not()
            })
            Spacer(Modifier.size(8.dp))
            KeyButton("菜单", onClick = {
                execKeyEvent(1)
                outputString = outputString.not()
            })
        }

        Text(text = "", modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun KeyButton(
    name: String,
    modifier: Modifier = Modifier,
    imageVector: ImageVector? = null,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.padding(0.dp),
        contentPadding = PaddingValues(0.dp),
        shape = RoundedCornerShape(100),
        onClick = { onClick.invoke() }) {
        if (imageVector != null) {
            Icon(imageVector, contentDescription = null)
        } else {
            Text(name, modifier = Modifier.padding(0.dp))
        }
    }
}