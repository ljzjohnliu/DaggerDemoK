package com.ljz.daggerk.singletonuse

import javax.inject.Inject

class Book () {

    var name: String = ""
    var price: Float = 0.0f

    @Inject
    constructor(name: String, price: Float) : this() {
        this.name = name
        this.price = price
    }
}