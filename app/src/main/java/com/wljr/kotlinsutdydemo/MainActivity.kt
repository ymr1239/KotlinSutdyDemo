package com.wljr.kotlinsutdydemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sum(6,76)
    }

    fun sum(a:Int,b:Int){
        println("sum of $a and $b is ${a+b}")
    }
}
