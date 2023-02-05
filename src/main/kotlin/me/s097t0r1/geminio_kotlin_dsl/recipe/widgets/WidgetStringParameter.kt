package me.s097t0r1.geminio_kotlin_dsl.recipe.widgets

import me.s097t0r1.geminio_kotlin_dsl.recipe.RecipeNode

class WidgetStringParameter(
    private val id: String,
    private val name: String,
) : RecipeNode {

    private val params: MutableMap<String, Any> = mutableMapOf()

    infix fun help(text: String) {
        params[HELP_KEY] = text
    }

    fun constraints(vararg constraints: WidgetConstraint) {
        params[CONSTRAINT_KEY] = constraints.map(WidgetConstraint::value)
    }

    infix fun default(defaultValue: String) {
        params[DEFAULT_KEY] = defaultValue
    }

    infix fun suggest(value: String) {
        params[SUGGEST_KEY] = value
    }

    infix fun visibility(value: String) {
        params[VISIBILITY_KEY] = value
    }

    infix fun availability(value: String) {
        params[AVAILABILITY_KEY] = value
    }

    override fun unwrap(): Map<String, Any> {
        params[ID_KEY] = id
        params[NAME_KEY] = name
        return mapOf(
            STRING_PARAMETER to params
        )
    }

    companion object {
        private const val ID_KEY = "id"
        private const val NAME_KEY = "name"

        private const val STRING_PARAMETER = "stringParameter"

        private const val HELP_KEY = "help"
        private const val CONSTRAINT_KEY = "constraints"
        private const val DEFAULT_KEY = "default"
        private const val SUGGEST_KEY = "suggest"
        private const val VISIBILITY_KEY = "visibility"
        private const val AVAILABILITY_KEY = "availability"
    }

}