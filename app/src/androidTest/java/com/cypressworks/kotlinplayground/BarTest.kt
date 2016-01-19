package com.cypressworks.kotlinplayground

import junit.framework.TestCase

class BarTest : TestCase() {
    fun testFoo() {
        assertEquals("Hello from Bar", Bar().hello())
    }
}