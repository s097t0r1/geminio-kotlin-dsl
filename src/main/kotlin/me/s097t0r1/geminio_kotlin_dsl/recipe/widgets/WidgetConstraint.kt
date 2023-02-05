package me.s097t0r1.geminio_kotlin_dsl.recipe.widgets

enum class WidgetConstraint(val value: String) {
    UNIQUE("unique"),
    EXISTS("exists"),
    NONEMPTY("nonempty"),
    ACTIVITY("activity"),
    CLASS("class"),
    PACKAGE("package"),
    APP_PACKAGE("app_package"),
    MODULE("module"),
    LAYOUT("layout"),
    DRAWABLE("drawable"),
    NAVIGATION("navigation"),
    VALUES("values"),
    SOURCE_SET_FOLDER("source_set_folder"),
    STRING("string"),
    URI_AUTHORITY("uri_authority"),
    KOTLIN_FUNCTION("kotlin_function")
}