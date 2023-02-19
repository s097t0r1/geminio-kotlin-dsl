package me.s097t0r1.geminio_kotlin_dsl.recipe.predefined_features

import me.s097t0r1.geminio_kotlin_dsl.recipe.RecipeNode

class EnableModuleCreationParams() : RecipeNode {

    private val nodes = mutableMapOf<String, String>()

    infix fun defaultPackageNamePrefix(packageName: String) {
        nodes[DEFAULT_PACKAGE_NAME_PREFIX_KEY] = packageName
    }

    companion object {
        private const val DEFAULT_PACKAGE_NAME_PREFIX_KEY = "defaultPackageNamePrefix"
    }

    override fun unwrap(): Any = nodes
}