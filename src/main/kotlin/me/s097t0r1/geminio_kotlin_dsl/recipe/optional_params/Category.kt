package me.s097t0r1.geminio_kotlin_dsl.recipe.optional_params

enum class Category(val value: String) {
    ACTIVITY("activity"),
    FRAGMENT("fragment"),
    APPLICATION("application"),
    FOLDER("folder"),
    UI_COMPONENT("ui_component"),
    AUTOMOTIVE("automotive"),
    XML("xml"),
    WEAR("wear"),
    AIDL("aidl"),
    WIDGET("widget"),
    GOOGLE("google"),
    COMPOSE("compose"),
    OTHER("other")
}