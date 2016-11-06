package com.sys1yagi.counterpoint

class Pitch(val name: Name, val level: Int) {
    enum class Name(val pos: Int) {
        C(0),
        DF(1),
        D(2),
        EF(3),
        E(4),
        F(5),
        GF(6),
        G(7),
        AF(8),
        A(9),
        BF(10),
        B(11)
    }

    fun pos() = name.pos + level * 12
    fun isUpDirection(next:Pitch) =
            (pos() - next.pos()) < 0
}