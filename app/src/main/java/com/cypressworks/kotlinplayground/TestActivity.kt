package com.cypressworks.kotlinplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlin.properties.Delegates

public class TestActivity : AppCompatActivity() {

    val aaa: String by extra()
    val b: String by extra()

    var node: Node<String> by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("TestActivity", aaa)
        Log.d("TestActivity", b)

        val node = this.node
        val a = when (node) {
            is Node.Leaf -> node.value
            is Node.Branch -> null
        }
    }

    val f: Foo.() -> String = Foo::bar
}

sealed class Node<T> {
    class Leaf<T>(val value: T) : Node<T>()
    class Branch<T>(val left: Node<T>, val right: Node<T>) : Node<T>()
}