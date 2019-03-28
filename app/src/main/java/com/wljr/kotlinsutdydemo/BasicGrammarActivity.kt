package com.wljr.kotlinsutdydemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BasicGrammarActivity : AppCompatActivity() {
    /**
     * 定义变量
     */
    val a: Int = 1  // 立即赋值
    val b = 2   // 自动推断出 `Int` 类型
    abstract val c: Int  // 如果没有初始值类型不能省略

    /**
     * 变量空处理
     */
    var a1: String = "abc"
    val l = a1.length //正确
    var b1: String? = "abc"
    //val l1 = b1.length // 错误：变量“b”可能为空


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_grammar)
        /*--------------------------------------变量------------------------------------------------ */
        /**
         * 安全调用
         */
        val b: String? = "Kotlin"
        if (b != null && b.length > 0) {
            print("String of length ${b.length}")
        } else {
            print("Empty string")
        }

        val a = "Kotlin"
        val b1: String? = null
        println(b1?.length)//如果 b 非空，就返回 b.length，否则返回 null
        println(a?.length) // 无需安全调用

        /**
         * 链式调用
         * bob?.department?.head?.name
         * 如果任意一个属性（环节）为空，这个链式调用就会返回 null
         */

        /**
         * 如果要只对非空值执行某个操作，安全调用操作符可以与 let 一起使用：
         */
        val listWithNulls: List<String?> = listOf("Kotlin", null)
        for (item in listWithNulls) {
            item?.let { println(it) } // 输出 A 并忽略 null
        }

        // 如果 `person` 或者 `person.department` 其中之一为空，都不会调用该函数：
        // person?.department?.head = managersPool.getManager()

        /**
         * Elvis 操作符
         */
        //如果 ?: 左侧表达式非空，elvis 操作符就返回其左侧表达式，否则返回右侧表达式。
        // 请注意，当且仅当左侧为空时，才会对右侧表达式求值。
        val l: Int = if (b != null) b.length else -1
        val l1 = b?.length ?: -1

        /*因为 throw 和 return 在 Kotlin 中都是表达式，所以它们也可以用在 elvis 操作符右侧。
        这可能会非常方便，例如，检查函数参数：
        fun foo(node: Node): String? {
            val parent = node.getParent() ?: return null
            val name = node.getName() ?: throw IllegalArgumentException("name expected")
            // ……
        }*/

        /**
         *  !! 操作符
         *  b一定不能为空,否则会报错
         */
        val l3 = b!!.length

        /**
         * 安全的类型转换
         * 如果尝试转换不成功则返回 null
         */
        val aInt: Int? = a as? Int

        /**
         * 可空类型的集合
         * 如果你有一个可空类型元素的集合，并且想要过滤非空元素，你可以使用 filterNotNull 来实现
         */
        val nullableList: List<Int?> = listOf(1, 2, null, 4)
        val intList: List<Int> = nullableList.filterNotNull()
        /*--------------------------------------变量------------------------------------------------ */
    }



    /**
     * 定义函数
     */
    //1.
    fun sum(a: Int, b: Int): Int {
        return a + b
    }
    //2.返回单表达式时{}可省略
    fun sum2(a: Int, b: Int) = a + b

    //3.Unit可以省略
    fun printSum(a: Int, b: Int): Unit {
        println("sum of $a and $b is ${a + b}")
    }

    //4.
    //默认参数 函数参数可以有默认值，当省略相应的参数时使用默认值。与其他语言相比，这可以减少重载数量
    // 默认值通过类型后面的 = 及给出的值来定义
    fun read(b: Array<Byte>, off: Int = 0, len: Int = b.size) {  }

    //覆盖方法总是使用与基类型方法相同的默认参数值。 当覆盖一个带有默认参数值的方法时，
    // 必须从签名中省略默认参数值：
    open class A {
        open fun foo(i: Int = 10) {}
    }

    class B : A() {
        override fun foo(i: Int) {}  // 不能有默认值
    }

    //如果一个默认参数在一个无默认值的参数之前，那么该默认值只能通过使用命名参数调用该函数来使用
    fun foo(bar: Int = 0, baz: Int) {}
    //foo(baz = 1) // 使用默认值 bar = 0

    //如果在默认参数之后的最后一个参数是 lambda 表达式，那么它既可以作为命名参数在括号内传入，
    // 也可以在括号外传入
    fun foo(bar: Int = 0, baz: Int = 1, qux: () -> Unit) {}
    //foo(1) { println("hello") }     // 使用默认值 baz = 1
    //foo(qux = { println("hello") }) // 使用两个默认值 bar = 0 与 baz = 1
    //foo { println("hello") }        // 使用两个默认值 bar = 0 与 baz = 1

    //5.命名参数
    fun reformat(str: String,
                 normalizeCase: Boolean = true,
                 upperCaseFirstLetter: Boolean = true,
                 divideByCamelHumps: Boolean = false,
                 wordSeparator: Char = ' ') {
    }

    //6.可变数量的参数（Varargs）
    fun <T> asList(vararg ts: T): List<T> {
        val result = ArrayList<T>()
        for (t in ts) // ts is an Array
            result.add(t)
        return result
    }
    //当我们调用 vararg-函数时，我们可以一个接一个地传参，例如 asList(1, 2, 3)，或者，
    // 如果我们已经有一个数组并希望将其内容传给该函数，我们使用伸展（spread）操作符（在数组前面加 *）
    val a3 = arrayOf(1, 2, 3)
    val list = asList(-1, 0, *a3, 4)

    //7.中缀表示法(待写)

    //8.函数作用域
    //局部函数:Kotlin 支持局部函数，即一个函数在另一个函数内部：
    /*
    fun dfs(graph: Graph) {
        fun dfs(current: Vertex, visited: Set<Vertex>) {
            if (!visited.add(current)) return
            for (v in current.neighbors)
                dfs(v, visited)
        }

        dfs(graph.vertices[0], HashSet())
     }
    * */

    //局部函数可以访问外部函数（即闭包）的局部变量，所以在上例中，visited 可以是局部变量：
    /*
    * fun dfs(graph: Graph) {
        val visited = HashSet<Vertex>()
        fun dfs(current: Vertex) {
            if (!visited.add(current)) return
            for (v in current.neighbors)
                dfs(v)
        }

        dfs(graph.vertices[0])
    }
    * */

    /**
     * 未完,待续
     */

}
