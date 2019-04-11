package com.wljr.kotlinsutdydemo.summary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.wljr.kotlinsutdydemo.R
import com.wljr.kotlinsutdydemo.summary.model.MemberListEntity
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

/**
 * 习惯用法
 */

class IdiomaticUsageActivity : AppCompatActivity() {
    /**
     * 创建实体类
     * 参见MemberListEntity
     */
    private var mMemberListEntity : MemberListEntity?=null
    private var name:String="123"
    private var map:Map<String,String>?= HashMap()
    /**
     * 只读 list
     */
    val list = listOf("a", "b", "c")

    /**
     * 延迟属性
     */
    val p: String by lazy {
        String()//待完善,只是不报错了
    }

    /**
     * 创建单例
     */
    object Resource {
        val name = "Name"
    }

    /**
     * If not null 缩写
     */
    val files = File("Test").listFiles()

    /**
     * if null 执行一个语句
     */
    val values = mapOf("email" to 1, "b" to 2, "c" to 3)
    val email = values["email"] ?: throw IllegalStateException("Email is missing!")
    //在可能会空的集合中取第一元素
    val emails = emptyList<Int>() // 可能会是空集合
    val mainEmail = emails.firstOrNull() ?: ""




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_idiomatic_usage)
        if (mMemberListEntity!!.source_data.page==0) { }//实体类简单实用
        /**
         * 字符串内插
         */
        println("Name $name")

        /**
         * 类型判断
         */
        when (name) {
            is String -> {
                name="我是String"
            }
            else -> {
                name="你猜我是啥类型"
            }
        }

        /**
         * 遍历 map/pair型list
         * k、v 可以改成任意名字。
         */
        map!!.forEach { (k, v) ->
            println("$k -> $v")
        }

        /**
         * 使用区间
         */
        for (i in 1..100) {  }  // 闭区间：包含 100
        for (i in 1 until 100) {  } // 半开区间：不包含 100
        for (x in 2..10 step 2) {  }
        for (x in 10 downTo 1) {  }
        val x = 0
        if (x in 1..10) {  }

        /**
         * 只读 map
         */
        val mapOnlyRead = mapOf("a" to 1, "b" to 2, "c" to 3)
        //访问 map
        println(mapOnlyRead["key"])

        /**
         * 扩展函数
         */
        fun String.spaceToCamelCase() { }
        "Convert this to camelcase".spaceToCamelCase()

        //If not null 写法
        println(files?.size)
        //If not null and else 缩写
        println(files?.size ?: "empty")

        /**
         * if not null 执行代码
         */
        val value = ""
        value?.let {
             // 代码会执行到此处, 假如data不为null
        }

        /**
         * 映射可空值（如果非空的话）
         */
        val value1 = ""

        val mapped = value1?.let { "123" } ?: "456"

        /**
         * 对一个对象实例调用多个方法 （with）
         */
        class Turtle {
            fun penDown() {}
            fun penUp(){}
            fun turn(degrees: Double){}
            fun forward(pixels: Double){}
        }
        with(Turtle()) { // 画一个 100 像素的正方形
            penDown()
            for(i in 1..4) {
                forward(100.0)
                turn(90.0)
            }
            penUp()
        }

        /**
         * Java 7 的 try with resources
         */
        val stream = Files.newInputStream(Paths.get("/some/file.txt"))
        stream.buffered().reader().use { reader ->
            println(reader.readText())
        }

        /**
         * 使用可空布尔
         */
        val b: Boolean? =null
        if (b == true) {

        } else {
            // `b` 是 false 或者 null
        }

        /**
         * 交换两个变量
         */
        var a = 1
        var b1 = 2
        a = b1.also { b1 = a }
    }

    /**
     * 函数的默认参数
     */
    fun foo(a: Int = 0, b: String = "") { }

    /**
     * 过滤 list
     */
    private var mList:List<Int>?=ArrayList()
    val positives1 = mList!!.filter { x -> x > 0 }
    val positives2 = mList!!.filter { it > 0 }

    /**
     * 返回 when 表达式
     */
    fun transform(color: String): Int {
        return when (color) {
            "Red" -> 0
            "Green" -> 1
            "Blue" -> 2
            else -> throw IllegalArgumentException("Invalid color param value")
        }
    }

    /**
     * “try/catch”表达式
     */
    fun test() {
        val result = try {
            transform("Red")
        } catch (e: ArithmeticException) {
            throw IllegalStateException(e)
        }
        // 使用 result
    }

    /**
     * “if”表达式
     */
    fun foo(param: Int) {
        val result = if (param == 1) {
            "one"
        } else if (param == 2) {
            "two"
        } else {
            "three"
        }
    }

    /**
     * 返回类型为 Unit 的方法的 Builder 风格用法
     * fill() 用提供的值填充原始数组。
     */
    fun arrayOfMinusOnes(size: Int): IntArray {
        return IntArray(size).apply { fill(-1) }
    }

    /**
     * 单表达式函数
     */
    fun theAnswer() = 42
    //等价于
    fun theAnswer1(): Int {
        return 42
    }

    /**
     * 单表达式函数与其它惯用法一起使用能简化代码，例如和 when 表达式一起使用：
     */
    fun transform2(color: String): Int = when (color) {
        "Red" -> 0
        "Green" -> 1
        "Blue" -> 2
        else -> throw IllegalArgumentException("Invalid color param value")
    }

    /**
     * 对于需要泛型信息的泛型函数的适宜形式
     */
    inline fun < reified T: Any> Gson.fromJson(json: JsonElement): T = this.fromJson(json, T::class.java)


}
