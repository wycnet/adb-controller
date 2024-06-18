package manager

import bean.DeviceVO
import java.util.LinkedList

object DataManager {

    val devicesUI = mutableListOf<DeviceVO>()

    var currentDevice: DeviceVO? = null

    val outStrings = LinkedList<String>()
    val LIST_MAX_SIZE = 100

    fun chooseDevice(device: DeviceVO) {
        devicesUI.forEach {
            if (it == device) {
                it.selected = true
                currentDevice = it
            } else {
                it.selected = false
            }
        }
    }

    fun updateDevices(): List<DeviceVO> {
        devicesUI.clear()
        devicesUI.addAll(getDevices())
        return  devicesUI.toList()
    }

    fun addOutString(line: String) {
        outStrings.add(line)
        if (outStrings.size > LIST_MAX_SIZE) {
            outStrings.removeFirst()
        }
    }

}