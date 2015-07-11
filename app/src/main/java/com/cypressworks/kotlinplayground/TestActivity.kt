package com.cypressworks.kotlinplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

public class TestActivity : AppCompatActivity() {

    val aaa: String by extra()
    val b: String by extra()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("TestActivity", aaa)
        Log.d("TestActivity", b)
    }

}
