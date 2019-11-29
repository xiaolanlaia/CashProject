1、扩展方法

```kotlin

// 扩展方法
fun String.howMany(char: Char): Int {
    var count = 0
    val lowerCaseLetter = char.toLowerCase()
    for (i in 0 until length) {
        if (lowerCaseLetter == this[i].toLowerCase()) count++
    }
    return count
}

// 执行
val string = "Elephant"
string.howMany('e')

```