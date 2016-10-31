package com.sys1yagi.counterpoint

class Pitch(val name: Name, val level: Int) {
    enum class Name {
        C,
        DF,
        D,
        EF,
        E,
        F,
        GF,
        G,
        AF,
        A,
        BF,
        B
    }
}