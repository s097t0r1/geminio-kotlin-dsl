package me.s097t0r1.geminio_kotlin_dsl.recipe.recipe

import me.s097t0r1.geminio_kotlin_dsl.recipe.RecipeNode

class Open(private val filePath: String) : RecipeNode {

    override fun unwrap(): Any {
        return mapOf(
            Recipe.OPEN_KEY to mapOf(
                FILE_KEY to filePath
            )
        )
    }

    companion object {
        private const val FILE_KEY = "file"
    }
}