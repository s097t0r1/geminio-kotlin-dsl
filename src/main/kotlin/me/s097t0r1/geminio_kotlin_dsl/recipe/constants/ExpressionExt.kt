package me.s097t0r1.geminio_kotlin_dsl.recipe.constants

fun Expression.activityToLayout(): Expression = buildString {
    append(this@activityToLayout.value)
    append(".activityToLayout()")
}.let(::Expression)

fun Expression.fragmentToLayout(): Expression = buildString {
    append(this@fragmentToLayout.value)
    append(".fragmentToLayout()")
}.let(::Expression)

fun Expression.classToResources(): Expression = buildString {
    append(this@classToResources.value)
    append(".classToResources()")
}.let(::Expression)

fun Expression.camelCaseToUnderlines(): Expression = buildString {
    append(this@camelCaseToUnderlines.value)
    append(".camelCaseToUnderlines()")
}.let(::Expression)

fun Expression.layoutToActivity(): Expression = buildString {
    append(this@layoutToActivity.value)
    append(".layoutToActivity()")
}.let(::Expression)

fun Expression.layoutToFragment(): Expression = buildString {
    append(this@layoutToFragment.value)
    append(".layoutToFragment()")
}.let(::Expression)

fun Expression.underscoreToCamelCase(): Expression = buildString {
    append(this@underscoreToCamelCase.value)
    append(".underscoreToCamelCase()")
}.let(::Expression)
