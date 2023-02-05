package me.s097t0r1.geminio_kotlin_dsl.recipe.recipe

import me.s097t0r1.geminio_kotlin_dsl.recipe.RecipeNode

class MkDirs : RecipeNode {

    private val nodes = mutableListOf<String>()

    infix fun mkDir(dir: String) {
        nodes.add(dir)
    }

    override fun unwrap(): Any = mapOf(
        Recipe.MK_DIRS_KEY to nodes
    )
}
