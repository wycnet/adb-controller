package ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import bean.DeviceVO
import manager.DataManager
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * author       : wangyincan
 * email        : wangyincan@corp.netease.com
 * date         : 2024/4/3
 * description  :
 */

val leftPanelBgColor = Color.Black.copy(alpha = 0.1f)

@Preview
@Composable
fun LeftPanel() {
    var deviceList by remember { mutableStateOf(DataManager.updateDevices()) }
    Column() {
        OutlinedButton(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            shape = RoundedCornerShape(20.dp),
            border = BorderStroke(1.dp, Color.Gray),
            onClick = {
                deviceList = DataManager.updateDevices()
            }) {
            Text("刷新")
        }
        DeviceList(deviceList) {
            deviceList = DataManager.chooseDevice(it)
        }
    }
}

@Composable
fun DeviceList(devices: List<DeviceVO>, onItemClick: (DeviceVO) -> Unit) {
    Column {
        for (item in devices) {
            DeviceItemView(item, onClick = {
                onItemClick(it)
            })
        }
    }
}

@Preview
@Composable
fun DeviceItemView(device: DeviceVO, onClick: (DeviceVO) -> Unit) {
    TextButton(
        modifier = Modifier.fillMaxWidth()
            .background(color = if (device.selected) Color.White.copy(alpha = 0.4f) else Color.Transparent),
        onClick = {
            if (!device.selected) {
                onClick.invoke(device)
            }
        }) {
        Text(text = "${device.deviceName} ${device.status}")
    }
}


