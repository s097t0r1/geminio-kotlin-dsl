package me.s097t0r1.geminio_kotlin_dsl.recipe.yaml

import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.Yaml
import java.io.Writer

private val yamlDumper = run {
    val options = DumperOptions().apply {
        isPrettyFlow = true
        defaultFlowStyle = DumperOptions.FlowStyle.BLOCK
    }
    Yaml(options)
}
fun Any.toYaml(): String = yamlDumper.dump(this)

fun Any.toYaml(writer: Writer) = yamlDumper.dump(this, writer)
