package me.s097t0r1.geminio_kotlin_dsl.recipe.constants

class Expression(val value: String) : CharSequence by value {
    override fun toString(): String = "\${$value}"
}
