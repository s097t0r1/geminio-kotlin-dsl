package me.s097t0r1.geminio_kotlin_dsl.recipe

inline fun createRecipe(builder: RecipeRoot.() -> Unit) = RecipeRoot().apply(builder)

inline fun createModuleRecipe(builder: RecipeModuleRoot.() -> Unit) = RecipeModuleRoot().apply(builder)
