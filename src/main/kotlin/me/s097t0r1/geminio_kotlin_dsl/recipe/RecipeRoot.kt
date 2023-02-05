package me.s097t0r1.geminio_kotlin_dsl.recipe

import me.s097t0r1.geminio_kotlin_dsl.recipe.globals.Globals
import me.s097t0r1.geminio_kotlin_dsl.recipe.optional_params.OptionalParams
import me.s097t0r1.geminio_kotlin_dsl.recipe.recipe.Recipe
import me.s097t0r1.geminio_kotlin_dsl.recipe.required_params.RequiredParams
import me.s097t0r1.geminio_kotlin_dsl.recipe.widgets.Widgets

class RecipeRoot : RecipeNode {

    private val params: MutableMap<String, RecipeNode> = mutableMapOf()

    override fun unwrap(): Map<String, Any> = params.mapValues { it.value.unwrap() }

    fun requiredParams(name: String, description: String) {
        params[REQUIRED_PARAMS] = RequiredParams(name, description)
    }

    fun optionalParams(builder: OptionalParams.() -> Unit) {
        params[OPTIONAL_PARAMS] = OptionalParams().apply(builder)
    }

    fun widgets(builder: Widgets.() -> Unit) {
        params[WIDGETS_PARAMS] = Widgets().apply(builder)
    }

    fun globals(builder: Globals.() -> Unit) {
        params[GLOBALS_PARAMS] = Globals().apply(builder)
    }

    fun recipe(builder: Recipe.() -> Unit) {
        params[RECIPE_PARAMS] = Recipe().apply(builder)
    }

    companion object {
        private const val REQUIRED_PARAMS = "requiredParams"
        private const val OPTIONAL_PARAMS = "optionalParams"
        private const val WIDGETS_PARAMS = "widgets"
        private const val GLOBALS_PARAMS = "globals"
        private const val RECIPE_PARAMS = "recipe"
    }
}

