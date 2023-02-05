package me.s097t0r1.geminio_kotlin_dsl.recipe.globals

import me.s097t0r1.geminio_kotlin_dsl.recipe.RecipeNode

class GlobalsBooleanParameter(
    private val id: String,
    private val value: String
) : RecipeNode {
    override fun unwrap(): Map<String, Any> {
        return mapOf(
            BOOLEAN_PARAMETER to mapOf(
                ID_KEY to id,
                VALUE_KEY to value
            )
        )
    }

    companion object {
        private const val ID_KEY = "id"
        private const val VALUE_KEY = "value"

        private const val BOOLEAN_PARAMETER = "booleanParameter"
    }

}
