# geminio-kotlin-dsl

## Why?
Allows to use all features of strongly typed language,
such as autocompletion and highlighting of incorrect constructions, and for
fan of course🙃

Inspired by [github-workflows-kt](https://github.com/krzema12/github-workflows-kt)

## How to use?

1. Install Kotlin as a stand-alone binary, e.g. from Brew for macOS:
```shell
$ brew install kotlin
```
2. Create a new executable file in your repository:
```shell
$ touch path/to/geminio/recipe/name.main.kts
$ chmod +x path/to/geminio/recipe/name.main.kts
```
> **IMPORTANT:** name of file should end `.main.kts`

3. Put this template into previously created file and save it
``` kotlin
#!/usr/bin/env kotlin

@file:Repository("https://jitpack.io")
@file:DependsOn("me.s097t0r1:geminio-kotlin-dsl:1.0.0")

import me.s097t0r1.geminio_kotlin_dsl.recipe.createRecipe
import me.s097t0r1.geminio_kotlin_dsl.recipe.yaml.toYaml

val recipe = createRecipe {
    requiredParams(
        name = "Test recipe",
        description = "Test recipe description"
    )

    /* TYPE YOUR CODE HERE */

}.unwrap().toYaml().also(::println)
```

4. Generate the YAML by calling the above script and redirecting its output to the desired YAML file path:

```shell
$ ./recipe.main.kts > recipe.yaml
```