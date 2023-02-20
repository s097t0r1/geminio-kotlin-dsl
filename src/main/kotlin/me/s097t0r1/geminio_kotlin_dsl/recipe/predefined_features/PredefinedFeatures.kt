package me.s097t0r1.geminio_kotlin_dsl.recipe.predefined_features

import me.s097t0r1.geminio_kotlin_dsl.recipe.RecipeNode

class PredefinedFeatures() : RecipeNode {

    private val nodes = mutableListOf<RecipeNode>()

    fun enableModuleCreationParams(builder: EnableModuleCreationParams.() -> Unit) {
        nodes += EnableModuleCreationParams().apply(builder)
    }

    override fun unwrap(): Any = nodes.map(RecipeNode::unwrap)
}
