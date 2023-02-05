package me.s097t0r1.geminio_kotlin_dsl.recipe.recipe

import me.s097t0r1.geminio_kotlin_dsl.recipe.RecipeNode

class Recipe : RecipeNode {

    private val nodes = mutableListOf<RecipeNode>()

    fun mkdirs(builder: MkDirs.() -> Unit) {
        nodes += MkDirs().apply(builder)
    }

    fun instantiateAndOpen(from: String, to: String) {
        nodes += InstantiateAndOpen(from, to)
    }

    fun instantiate(from: String, to: String) {
        nodes += Instantiate(from, to)
    }

    fun open(filePath: String) {
        nodes += Open(filePath)
    }

    fun predicate(validIf: String, commands: Predicate.Commands.() -> Unit, elseCommands: Predicate.Commands.() -> Unit) {
        nodes += Predicate(validIf, Predicate.Commands().apply(commands), Predicate.Commands().apply(elseCommands))
    }

    fun addDependencies(builder: AddDependencies.() -> Unit) {
        nodes += AddDependencies().apply(builder)
    }

    fun addGradlePlugins(vararg plugins: String) {
        nodes += AddGradlePlugins(plugins.toList())
    }

    override fun unwrap(): Any = nodes.map(RecipeNode::unwrap)

    companion object {
        const val MK_DIRS_KEY = "mkDirs"
        const val INSTANTIATE_AND_OPEN_KEY = "instantiateAndOpen"
        const val INSTANTIATE_KEY = "instantiate"
        const val OPEN_KEY = "open"
        const val PREDICATE_KEY = "predicate"
        const val ADD_DEPENDENCIES_KEY = "addDependencies"
        const val ADD_GRADLE_PLUGINS_KEY = "addGradlePlugins"
    }
}
