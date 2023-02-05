package me.s097t0r1.geminio_kotlin_dsl.recipe.widgets

import me.s097t0r1.geminio_kotlin_dsl.recipe.RecipeNode

class WidgetBooleanParameter(
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

    infix fun default(defaultValue: Boolean) {
        params[DEFAULT_KEY] = defaultValue
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
            BOOLEAN_KEY to params.toMap()
        )
    }

    companion object {
        private const val ID_KEY = "id"
        private const val NAME_KEY = "name"
        private const val BOOLEAN_KEY = "booleanParameter"

        private const val HELP_KEY = "help"
        private const val CONSTRAINT_KEY = "constraints"
        private const val DEFAULT_KEY = "default"
        private const val VISIBILITY_KEY = "visibility"
        private const val AVAILABILITY_KEY = "availability"
    }

}
