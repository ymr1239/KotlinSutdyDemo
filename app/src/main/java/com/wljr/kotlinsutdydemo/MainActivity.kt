package com.wljr.kotlinsutdydemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(),View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button_1).setOnClickListener(this)
        println("我能看懂吗"+arrayOfMinusOnes(10).asList().toString())
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button_1 -> Toast.makeText(this,"我点到了",Toast.LENGTH_SHORT).show()
        }
    }

    fun arrayOfMinusOnes(size: Int): IntArray {
        return IntArray(size).apply { fill(3,1,3) }
    }

}
