package manager

import bean.DeviceVO
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.logging.Logger

const val TAG = "CommandUtils"

val runtime = Runtime.getRuntime()

/**
 * 获取设备列表
 */
fun getDevices(): List<DeviceVO> {
    val res = "adb devices".executeWithBack().first
    return res.trim().split("\n")
        .apply {
            Logger.getLogger(TAG).info("updateDevices, deviceString: $this")
        }.filter { it.isNotEmpty() && it != "null" && it != "List of devices attached" }.map {
            val list = it.split("\t")
            DeviceVO(deviceName = list.getOrElse(0) { "" },
                status = list.getOrElse(1) { "" })
        }.apply {
            Logger.getLogger(TAG).info("updateDevices, Devicis: $this")
        }
}

/**
 * 遥控按钮
 */
fun execKeyEvent(key: Int, deviceName: String = DataManager.currentDevice?.deviceName ?: "") {
    "adb -s $deviceName shell input keyevent $key".apply {
        Logger.getLogger(TAG).info("execKeyEvent, shell: $this")
        DataManager.addOutString(this)
    }.executeWithBack()
}


private fun String.executeWithBack(): Pair<String, Int> {
    val process = this.execute()
    val exitCode = process.waitFor()
    val res = process.text()
    return Pair(res, exitCode)
}

/**
 * 给String扩展 execute() 函数
 */
private fun String.execute(): Process {
    return runtime.exec(this)
}

/**
 * 扩展Process扩展 text() 函数
 */
private fun Process.text(): String {
    // 输出 Shell 执行结果
    val inputStream = this.inputStream
    val insReader = InputStreamReader(inputStream)
    val bufReader = BufferedReader(insReader)

    var output = ""
    var line: String? = ""
    while (null != line) {
        // 逐行读取shell输出，并保存到变量output
        line = bufReader.readLine()
        if (line.isNullOrEmpty()) {
            continue
        }
        DataManager.addOutString(line)
        output += line + "\n"
    }
    return output
}

