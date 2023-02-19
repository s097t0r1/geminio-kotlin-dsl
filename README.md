# geminio-kotlin-dsl

## Why?
Allows to use all features of strongly typed language,
such as autocompletion and highlighting of incorrect constructions, and for
fan of course🙃

Inspired by [github-workflows-kt](https://github.com/krzema12/github-workflows-kt)

## How to use?

1. Install Kotlin as a stand-alone binary, e.g. from Brew for MacOS:
```shell
$ brew install kotlin
```
2. Create a new executable file in your repository:
```shell
touch path/to/geminio/recipe/name.main.kts
```
> **IMPORTANT:** name of file should end `.main.kts`

3. Put this template into previously created file and save it
``` kotlin
#!/usr/bin/env kotlin

@file:DependsOn("it.krzeminski:github-actions-kotlin-dsl:0.37.0")

import it.krzeminski.githubactions.actions.actions.CheckoutV3
import it.krzeminski.githubactions.domain.RunnerType.UbuntuLatest
import it.krzeminski.githubactions.domain.triggers.Push
import it.krzeminski.githubactions.dsl.workflow
import it.krzeminski.githubactions.yaml.toYaml

val workflow = workflow(
    name = "Test workflow",
    on = listOf(Push()),
    sourceFile = __FILE__.toPath(),
) {
    job(id = "test_job", runsOn = UbuntuLatest) {
        uses(name = "Check out", action = CheckoutV3())
        run(name = "Print greeting", command = "echo 'Hello world!'")
    }
}

println(workflow.toYaml())
```