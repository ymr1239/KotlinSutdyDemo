package com.wljr.kotlinsutdydemo.detail.ClassAndObject
fun main(args: Array<String>) {
    var mInitOrderDemo: ClassDescription.InitOrderDemo = ClassDescription.InitOrderDemo("22222222")
    mInitOrderDemo.firstProperty
}
/**
 * 类声明由类名、类头（指定其类型参数、主构造函数等）以及由花括号包围的类体构成。
 * 类头与类体都是可选的； 如果一个类没有类体，可以省略花括号。
 */
class ClassDescription {
    /**
     * 构造函数
     *
     * 在 Kotlin 中的一个类可以有一个主构造函数以及一个或多个次构造函数。
     * 主构造函数是类头的一部分：它跟在类名（与可选的类型参数）后。
     *
     * 主构造函数不能包含任何的代码。
     * 初始化的代码可以放到以 init 关键字作为前缀的初始化块（initializer blocks）中。
     */
    class ClassDescription constructor(firstName: String) {}

    //如果主构造函数没有任何注解或者可见性修饰符，可以省略这个 constructor 关键字。
    //class ClassDescription(firstName: String) {  }

    //在实例初始化期间，初始化块按照它们出现在类体中的顺序执行，与属性初始化器交织在一起：
    class InitOrderDemo(name: String) {
        val firstProperty = "First property: $name".also(::println)

        init {
            println("First initializer block that prints ${name}")
        }



//        val secondProperty = "Second property: ${name.length}".also(::println)
//
//        init {
//            println("Second initializer block that prints ${name.length}")
//        }
    }
}