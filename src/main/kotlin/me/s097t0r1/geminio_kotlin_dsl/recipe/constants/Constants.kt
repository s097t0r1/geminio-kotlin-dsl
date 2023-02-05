package me.s097t0r1.geminio_kotlin_dsl.recipe.constants

object Constants {
    operator fun get(key: String) = Constant(key)

    val srcOut: Constant
        get() = Constant(SRC_OUT)

    val formattedModuleName: Constant
        get() = Constant(FORMATTED_MODULE_NAME)

    class Constant(val value: String) : CharSequence by value {
        override fun toString(): String = "\${$value}"
    }

    private const val SRC_OUT = "srcOut"
    private const val FORMATTED_MODULE_NAME = "__formattedModuleName"
}
