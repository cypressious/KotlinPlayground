package com.cypressworks.kotlinplayground

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class Ticket(

) : RealmObject() {
    @PrimaryKey open var id: String = ""

    open var foo : String = ""
}