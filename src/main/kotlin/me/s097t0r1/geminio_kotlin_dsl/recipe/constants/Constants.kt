package me.s097t0r1.geminio_kotlin_dsl.recipe.constants

object Constants {
    operator fun get(key: String) = Expression(key)

    val rootOut: Expression
        get() = Expression(ROOT_OUT)

    val manifestOut: Expression
        get() = Expression(MANIFEST_OUT)

    val resOut: Expression
        get() = Expression(RES_OUT)

    val srcOut: Expression
        get() = Expression(SRC_OUT)

    val __formattedModuleName: Expression
        get() = Expression(FORMATTED_MODULE_NAME)

    private const val SRC_OUT = "srcOut"
    private const val ROOT_OUT = "rootOut"
    private const val MANIFEST_OUT = "manifestOut"
    private const val RES_OUT = "resOut"

    private const val FORMATTED_MODULE_NAME = "__formattedModuleName"
}
