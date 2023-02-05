package me.s097t0r1.geminio_kotlin_dsl.recipe.yaml

import org.yaml.snakeyaml.Yaml
import java.io.Writer

fun Any.toYaml(): String = Yaml().dump(this)

fun Any.toYaml(writer: Writer) = Yaml().dump(this, writer)
