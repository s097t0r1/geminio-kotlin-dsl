package me.s097t0r1.geminio_kotlin_dsl.recipe.recipe

import me.s097t0r1.geminio_kotlin_dsl.recipe.RecipeNode

class InstantiateAndOpen(
    private val from: String,
    private val to: String
) : RecipeNode {

    override fun unwrap(): Any {
        return mapOf(
            Recipe.INSTANTIATE_AND_OPEN_KEY to mapOf(
                FROM_KEY to from,
                TO_KEY to to
            )
        )
    }

    companion object {
        private const val FROM_KEY = "from"
        private const val TO_KEY = "to"
    }

}