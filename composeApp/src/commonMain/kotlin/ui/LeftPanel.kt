package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Colors
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import bean.DeviceVO
import manager.DataManager
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * author       : wangyincan
 * email        : wangyincan@corp.netease.com
 * date         : 2024/4/3
 * description  :
 */

val leftPanelBgColor = Color.Black.copy(alpha = 0.5f)

@Preview
@Composable
fun LeftPanel() {
    var deviceList by remember { mutableStateOf(DataManager.updateDevices()) }
    Column(modifier = Modifier.background(leftPanelBgColor)) {
        OutlinedButton(
            onClick = {
            deviceList = DataManager.updateDevices()
        }) {
            Text("刷新")
        }
        DeviceList(deviceList)
    }
}

@Composable
fun DeviceList(devices: List<DeviceVO>) {
    Column {
        for (item in devices) {
            DeviceItemView(item, onClick = {
                DataManager.chooseDevice(it)
            })
        }
    }
}

@Preview
@Composable
fun DeviceItemView(device: DeviceVO, onClick: (DeviceVO) -> Unit) {
    Button(onClick = { onClick.invoke(device) }) {
        Text(text = "${device.deviceName} ${device.status}")
    }
}


