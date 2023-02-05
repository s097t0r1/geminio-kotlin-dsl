package me.s097t0r1.geminio_kotlin_dsl.recipe.required_params

import me.s097t0r1.geminio_kotlin_dsl.recipe.RecipeNode

class RequiredParams(
    private val name: String,
    private val description: String
) : RecipeNode {
    override fun unwrap(): Map<String, Any> {
        return mutableMapOf(
            NAME_KEY to name,
            DESCRIPTION_KEY to description
        )
    }

    companion object {
        private const val NAME_KEY = "name"
        private const val DESCRIPTION_KEY = "description"
    }
}