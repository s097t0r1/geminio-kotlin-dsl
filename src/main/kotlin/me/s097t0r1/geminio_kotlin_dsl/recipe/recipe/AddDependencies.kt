package me.s097t0r1.geminio_kotlin_dsl.recipe.recipe

import me.s097t0r1.geminio_kotlin_dsl.recipe.RecipeNode

class AddDependencies : RecipeNode {

    private val nodes = mutableListOf<RecipeNode>()
    fun implementation(value: String) {
        nodes += Dependency(Dependency.DependencyType.IMPLEMENTATION, value)
    }

    fun kapt(value: String) {
        nodes += Dependency(Dependency.DependencyType.KAPT, value)
    }

    fun compileOnly(value: String) {
        nodes += Dependency(Dependency.DependencyType.COMPILE_ONLY, value)
    }

    fun testImplementation(value: String) {
        nodes += Dependency(Dependency.DependencyType.TEST_IMPLEMENTATION, value)
    }

    fun androidTestImplementation(value: String) {
        nodes += Dependency(Dependency.DependencyType.ANDROID_TEST_IMPLEMENTATION, value)
    }

    override fun unwrap(): Any {
        return mapOf(
            Recipe.ADD_DEPENDENCIES_KEY to nodes.map(RecipeNode::unwrap)
        )
    }

    class Dependency(
        private val type: DependencyType,
        private val value: String
    ) : RecipeNode {
        enum class DependencyType(val value: String) {
            IMPLEMENTATION("implementation"),
            KAPT("kapt"),
            COMPILE_ONLY("compileOnly"),
            TEST_IMPLEMENTATION("testImplementation"),
            ANDROID_TEST_IMPLEMENTATION("androidTestImplementation")
        }

        override fun unwrap(): Any {
            return mapOf(type.value to value)
        }
    }
}