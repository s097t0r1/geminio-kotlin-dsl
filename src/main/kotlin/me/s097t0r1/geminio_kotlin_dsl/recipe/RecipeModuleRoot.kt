package me.s097t0r1.geminio_kotlin_dsl.recipe

import me.s097t0r1.geminio_kotlin_dsl.recipe.globals.Globals
import me.s097t0r1.geminio_kotlin_dsl.recipe.optional_params.OptionalParams
import me.s097t0r1.geminio_kotlin_dsl.recipe.predefined_features.PredefinedFeatures
import me.s097t0r1.geminio_kotlin_dsl.recipe.recipe.Recipe
import me.s097t0r1.geminio_kotlin_dsl.recipe.required_params.RequiredParams
import me.s097t0r1.geminio_kotlin_dsl.recipe.widgets.Widgets

class RecipeModuleRoot : RecipeNode {

    private val params: MutableMap<String, RecipeNode> = mutableMapOf()

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

    fun predefinedFeatures(builder: PredefinedFeatures.() -> Unit) {
        params[PREDEFINED_FEATURES_PARAMS] = PredefinedFeatures().apply(builder)
    }

    fun recipe(builder: Recipe.() -> Unit) {
        params[RECIPE_PARAMS] = Recipe().apply(builder)
    }

    override fun unwrap(): Map<String, Any> = params.mapValues { it.value.unwrap() }

    companion object {
        private const val REQUIRED_PARAMS = "requiredParams"
        private const val OPTIONAL_PARAMS = "optionalParams"
        private const val WIDGETS_PARAMS = "widgets"
        private const val PREDEFINED_FEATURES_PARAMS = "predefinedFeatures"
        private const val GLOBALS_PARAMS = "globals"
        private const val RECIPE_PARAMS = "recipe"
    }
}
