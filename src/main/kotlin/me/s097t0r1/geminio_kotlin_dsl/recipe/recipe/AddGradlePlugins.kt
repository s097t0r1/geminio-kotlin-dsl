package me.s097t0r1.geminio_kotlin_dsl.recipe.recipe

import me.s097t0r1.geminio_kotlin_dsl.recipe.RecipeNode

class AddGradlePlugins(
    private val nodes: List<String>
) : RecipeNode {

    override fun unwrap(): Any {
        return mapOf(
            Recipe.ADD_GRADLE_PLUGINS_KEY to nodes
        )
    }

}