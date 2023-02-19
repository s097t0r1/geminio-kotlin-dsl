package me.s097t0r1.geminio_kotlin_dsl.recipe.predefined_features

import me.s097t0r1.geminio_kotlin_dsl.recipe.RecipeNode

class PredefinedFeatures() : RecipeNode {

    private val nodes = mutableMapOf<String, RecipeNode>()

    fun enableModuleCreationParams(builder: EnableModuleCreationParams.() -> Unit) {
        nodes[ENABLE_MODULE_CREATION_PARAMS_KEY] = EnableModuleCreationParams().apply(builder)
    }

    override fun unwrap(): Any = nodes.mapValues { it.value.unwrap() }

    companion object {
        private const val ENABLE_MODULE_CREATION_PARAMS_KEY = "enableModuleCreationParams"
    }
}
