package me.s097t0r1.geminio_kotlin_dsl.recipe.recipe

import me.s097t0r1.geminio_kotlin_dsl.recipe.RecipeNode

class Predicate(
    private val validIf: String,
    private val commands: Commands,
    private val elseCommands: Commands
) : RecipeNode {

    private val nodes = mutableListOf<RecipeNode>()

    class Commands() : RecipeNode {

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

        override fun unwrap(): Any = nodes.map(RecipeNode::unwrap)

    }

    override fun unwrap(): Any {
        return mapOf(
            Recipe.PREDICATE_KEY to mapOf(
                VALID_IF_KEY to validIf,
                COMMANDS_KEY to commands.unwrap(),
                ELSE_COMMANDS_KEY to elseCommands.unwrap()
            )
        )
    }

    companion object {
        private const val VALID_IF_KEY = "validIf"
        private const val COMMANDS_KEY = "commands"
        private const val ELSE_COMMANDS_KEY = "elseCommands"
    }
}