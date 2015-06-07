package com.cypressworks.kotlinplayground

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import javax.inject.Inject
import kotlin.properties.Delegates

public class MainActivity : AppCompatActivity() {

    var foo: Foo by Delegates.notNull()
        @Inject set

    var bar: Bar by Delegates.notNull()
        @Inject set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MyApplication.component.inject(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.getItemId()) {
        R.id.action_settings -> true
        else -> super.onOptionsItemSelected(item)
    }
}
