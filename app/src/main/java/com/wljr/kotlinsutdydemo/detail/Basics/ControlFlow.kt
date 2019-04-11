package com.wljr.kotlinsutdydemo.detail.Basics

import java.lang.Integer.parseInt

class ControlFlow{
    constructor(){
        /**
         * If 表达式
         * 在 Kotlin 中，if是一个表达式，即它会返回一个值。
         * 因此就不需要三元运算符（条件 ? 然后 : 否则），因为普通的 if 就能胜任这个角色。
         */
        // 传统用法
        var a=0
        var b=1
        var max = a
        if (a < b) max = b

        // With else
        var max2: Int
        if (a > b) {
            max2 = a
        } else {
            max2 = b
        }

        // 作为表达式
        val max3 = if (a > b) a else b

        //if的分支可以是代码块，最后的表达式作为该块的值：
        val max4 = if (a > b) {
            print("Choose a")
            a
        } else {
            print("Choose b")
            b
        }

        /**
         * When 表达式
         * when 取代了类 C 语言的 switch 操作符。其最简单的形式如下：
         */
        var x=1
        when (x) {
            1 -> print("x == 1")
            2 -> print("x == 2")
            else -> { // 注意这个块
                print("x is neither 1 nor 2")
            }
        }
        //如果很多分支需要用相同的方式处理，则可以把多个分支条件放在一起，用逗号分隔：
        when (x) {
            0, 1 -> print("x == 0 or x == 1")
            else -> print("otherwise")
        }
        //我们可以用任意表达式（而不只是常量）作为分支条件
        var s="123"
        when (x) {
            parseInt(s) -> print("s encodes x")
            else -> print("s does not encode x")
        }
        //我们也可以检测一个值在（in）或者不在（!in）一个区间或者集合中：
        var validNumbers= arrayListOf<Int>(1,2,4)
        when (x) {
            in 1..10 -> print("x is in the range")
            in validNumbers -> print("x is valid")
            !in 10..20 -> print("x is outside the range")
            else -> print("none of the above")
        }

        //另一种可能性是检测一个值是（is）或者不是（!is）一个特定类型的值。
        // 注意： 由于智能转换，你可以访问该类型的方法与属性而无需任何额外的检测。
        fun hasPrefix(x: Any) = when(x) {
            is String -> x.startsWith("prefix")
            else -> false
        }

        //when 也可以用来取代 if-else if链。
        // 如果不提供参数，所有的分支条件都是简单的布尔表达式，而当一个分支的条件为真时则执行该分支：
        when {
            1==1 -> print("x is odd")
            2===3 -> print("x is even")
            else -> print("x is funny")
        }

        //Since Kotlin 1.3, it is possible to capture when subject in a variable using following syntax:
        /* fun Request.getBody() =
            when (val response = executeRequest()) {
                is Success -> response.body
                is HttpError -> throw HttpException(response.status)
            } */

        /**
         * For 循环
         * for 循环可以对任何提供迭代器（iterator）的对象进行遍历，
         * 这相当于像 C# 这样的语言中的 foreach 循环。语法如下：
         */
        var collection= arrayListOf<String>("1","2")
        for (item in collection) print(item)
        //循环体可以是一个代码块。
        for (item: String in collection) {
            // ……
        }
        /*
        如上所述，for 可以循环遍历任何提供了迭代器的对象。即：
        有一个成员函数或者扩展函数 iterator()，它的返回类型
        有一个成员函数或者扩展函数 next()，并且
        有一个成员函数或者扩展函数 hasNext() 返回 Boolean。
        这三个函数都需要标记为 operator。
        */

        //如需在数字区间上迭代，请使用区间表达式:
        for (i in 1..3) {
            println(i)
        }
        for (i in 6 downTo 0 step 2) {
            println(i)
        }

        //对区间或者数组的 for 循环会被编译为并不创建迭代器的基于索引的循环。
        //如果你想要通过索引遍历一个数组或者一个 list，你可以这么做：
        for (i in collection.indices) {
            println(collection[i])
        }
        //或者你可以用库函数 withIndex：
        for ((index, value) in collection.withIndex()) {
            println("the element at $index is $value")
        }

        /**
         * While 循环
         * while 与 do..while 照常使用
         * 在循环中 Kotlin 支持传统的 break 与 continue 操作符
         */
        while (x > 0) {
            x--
        }

        do {
            val y = retrieveData()
        } while (y != null) // y 在此处可见
    }

    private fun retrieveData(): Any {
        return ""
    }
}