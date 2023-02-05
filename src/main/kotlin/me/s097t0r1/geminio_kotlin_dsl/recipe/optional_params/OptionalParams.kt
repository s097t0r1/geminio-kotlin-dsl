package me.s097t0r1.geminio_kotlin_dsl.recipe.optional_params

import me.s097t0r1.geminio_kotlin_dsl.recipe.RecipeNode

class OptionalParams(
    private val params: MutableMap<String, Any> = mutableMapOf()
) : RecipeNode {

    override fun unwrap(): Map<String, Any> = params
    infix fun revision(revision: Int) {
        params[REVISION_KEY] = revision
    }

    infix fun category(category: Category) {
        params[CATEGORY_KEY] = category.value
    }

    infix fun formFactor(formFactor: FormFactor) {
        params[FORM_FACTOR_KEY] = formFactor.value
    }

    fun constraints(vararg constraints: Constraints) {
        params[CONSTRAINTS_KEY] = constraints.map(Constraints::value)
    }

    fun screens(vararg screens: Screens) {
        params[SCREENS_KEY] = screens.map(Screens::value)
    }

    infix fun minApi(version: Int) {
        params[MIN_API] = version
    }

    infix fun minBuildApi(version: Int) {
        params[MIN_BUILD_API] = version
    }

    companion object {
        private const val REVISION_KEY = "revision"
        private const val CATEGORY_KEY = "category"
        private const val FORM_FACTOR_KEY = "formFactor"
        private const val CONSTRAINTS_KEY = "constraints"
        private const val SCREENS_KEY = "screens"
        private const val MIN_API = "minApi"
        private const val MIN_BUILD_API = "minBuildApi"
    }

}