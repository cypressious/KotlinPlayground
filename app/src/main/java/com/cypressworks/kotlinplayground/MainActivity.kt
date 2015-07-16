package com.cypressworks.kotlinplayground

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.activity_main.button1
import kotlinx.android.synthetic.activity_main.editText1
import kotlinx.android.synthetic.activity_main.editText2
import java.io.Serializable
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty1

public class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.component.inject(this)

        button1.setOnClickListener {
            buildIntent<TestActivity>()
                    .putExtra(TestActivity::aaa, editText1.getText().toString())
                    .putExtra(TestActivity::b, editText2.getText().toString())
                    .start()
        }

    }

}

suppress("UNCHECKED_CAST")
fun <T : Activity, R : Any> T.extra(default: R? = null) = object : ReadOnlyProperty<T, R> {
    var value: R? = null

    override fun get(thisRef: T, property: PropertyMetadata): R {
        if (value == null) {
            val key = property.name
            value = thisRef.getIntent()?.getExtras()?.get(key) as? R
                    ?: default
                    ?: throw IllegalStateException("No extra with key $key and no non-null default")

        }

        return value!!
    }
}

class IntentBuilder<T : Activity>(
        private val c: Context,
        val intent: Intent) {

    fun <E> putExtra(prop: KProperty1<T, E>, value: E): IntentBuilder<T> {
        intent.putExtra(prop.name, value as Serializable)
        return this
    }

    fun start() {
        c.startActivity(intent)
    }

}

inline fun <reified T : Activity> Context.buildIntent() = IntentBuilder<T>(this, Intent(this, javaClass<T>()))
