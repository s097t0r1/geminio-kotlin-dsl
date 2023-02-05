package me.s097t0r1.geminio_kotlin_dsl.recipe.widgets

import me.s097t0r1.geminio_kotlin_dsl.recipe.RecipeNode

class Widgets : RecipeNode {

    private var params: List<RecipeNode> = emptyList()

    fun stringParameter(id: String, name: String, builder: WidgetStringParameter.() -> Unit = {}) {
        params += WidgetStringParameter(id, name).apply(builder)
    }

    fun booleanParameter(id: String, name: String, builder: WidgetBooleanParameter.() -> Unit = {}) {
        params += WidgetBooleanParameter(id, name).apply(builder)
    }
    override fun unwrap(): List<Any> = params.map(RecipeNode::unwrap)

}