package bean

data class DeviceVO(
    val deviceName: String,
    val status: String,
    var selected: Boolean = false
)
