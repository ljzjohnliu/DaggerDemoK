package com.ljz.daggerk.basicuse

import javax.inject.Inject

class Cat {

    @Inject
    constructor() {

    }

    override fun toString(): String {
        return "喵星人来了!";
    }
}