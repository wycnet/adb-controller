This is a Kotlin Multiplatform project targeting Android, Desktop.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…


[compose](https://developer.android.com/develop/ui/compose/lifecycle?hl=zh-cn)

https://juejin.cn/post/7307934456995774499?searchId=202405301754360D4FBE752B528DFF462E

https://juejin.cn/post/7324384083428835367?searchId=202405301845401FB7E2FE1D0B890A379F#heading-34

https://jetpackcompose.cn/docs/