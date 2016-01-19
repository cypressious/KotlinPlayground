package com.cypressworks.kotlinplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

/**
 * aa
 * bb
 */
public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.component.inject(this)


        button1.setOnClickListener {
            toast("Hello")
        }
    }

}
