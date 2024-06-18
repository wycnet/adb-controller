package manager

import bean.DeviceVO
import java.util.LinkedList

object DataManager {

    val devicesUI = mutableListOf<DeviceVO>()

    var currentDevice: DeviceVO? = null

    val outStrings = LinkedList<String>()
    val LIST_MAX_SIZE = 100

    fun chooseDevice(device: DeviceVO): List<DeviceVO> {
        currentDevice = device
        return updateDevices()
    }

    fun updateDevices(): List<DeviceVO> {
        devicesUI.clear()
        devicesUI.addAll(getDevices().map {
            if (it.deviceName == currentDevice?.deviceName) {
                it.selected = true
            } else {
                it.selected = false
            }
            it
        }.apply {
            if (currentDevice == null) {
                this.getOrNull(0)?.apply {
                    selected = true
                    currentDevice = this
                }
            }
        })
        return devicesUI.toList()
    }

    fun addOutString(line: String) {
        outStrings.add(line)
        if (outStrings.size > LIST_MAX_SIZE) {
            outStrings.removeFirst()
        }
    }

}