package me.s097t0r1.geminio_kotlin_dsl.recipe.globals

import me.s097t0r1.geminio_kotlin_dsl.recipe.RecipeNode

class Globals : RecipeNode {

    private var nodes = mutableListOf<RecipeNode>()

    fun stringParameter(id: String, value: String) {
        nodes += GlobalsStringParameter(id, value)
    }

    fun booleanParameter(id: String, value: String) {
        nodes += GlobalsBooleanParameter(id, value)
    }
    override fun unwrap(): List<Any> = nodes.map(RecipeNode::unwrap)

}