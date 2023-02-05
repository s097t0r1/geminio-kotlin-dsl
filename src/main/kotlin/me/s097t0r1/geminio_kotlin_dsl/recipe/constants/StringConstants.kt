package me.s097t0r1.geminio_kotlin_dsl.recipe.constants

fun Constants.Constant.activityToLayout(): Constants.Constant = buildString {
    append(this@activityToLayout.value)
    append(".activityToLayout()")
}.let(Constants::Constant)
