package com.wljr.kotlinsutdydemo.detail.Basics

class BasicTypes{
    /**
     * 数字字面值中的下划线（自 1.1 起）
     */
    val oneMillion = 1_000_000
    val creditCardNumber = 1234_5678_9012_3456L
    val socialSecurityNumber = 999_99_9999L
    val hexBytes = 0xFF_EC_DE_5E
    val bytes = 0b11010010_01101001_10010100_10010010

    /**
     * 运算
     * 这是完整的位运算列表（只用于 Int 与 Long）：
     */
    /*
    *inv() – 位非
    *shl(bits) – 有符号左移 (Java 的 <<)
    *shr(bits) – 有符号右移 (Java 的 >>)
    *ushr(bits) – 无符号右移 (Java 的 >>>)
    *and(bits) – 位与
    *or(bits) – 位或
    *xor(bits) – 位异或
    * */

    /**
     * String操作
     * 原始字符串 使用三个引号（"""）分界符括起来，内部没有转义并且可以包含换行以及任何其他字符:
     */
    val text = """
    for (c in "foo")
        print(c)
    """
    //你可以通过 trimMargin() 函数去除前导空格：
    //默认 | 用作边界前缀，但你可以选择其他字符并作为参数传入，比如 trimMargin(">")。
    val text2 = """
    |Tell me and I forget.
    |Teach me and I remember.
    |Involve me and I learn.
    |(Benjamin Franklin)
    """.trimMargin()

    constructor(){
        /**
         * 字符串模板
         * 字符串可以包含模板表达式 ，即一些小段代码，会求值并把结果合并到字符串中。
         * 模板表达式以美元符（$）开头，由一个简单的名字构成:
         */
        val i = 10
        println("i = $i") // 输出“i = 10”
        //或者用花括号括起来的任意表达式:
        val s = "abc"
        println("$s.length is ${s.length}") // 输出“abc.length is 3”
        //原始字符串与转义字符串内部都支持模板。
        // 如果你需要在原始字符串中表示字面值 $ 字符（它不支持反斜杠转义），你可以用下列语法：
        val price = """${'$'}9.99"""
    }
}