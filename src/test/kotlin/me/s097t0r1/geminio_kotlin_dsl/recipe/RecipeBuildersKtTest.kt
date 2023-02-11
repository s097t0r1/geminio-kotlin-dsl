package me.s097t0r1.geminio_kotlin_dsl.recipe

import me.s097t0r1.geminio_kotlin_dsl.recipe.constants.Constants
import me.s097t0r1.geminio_kotlin_dsl.recipe.optional_params.Category
import me.s097t0r1.geminio_kotlin_dsl.recipe.optional_params.Constraints
import me.s097t0r1.geminio_kotlin_dsl.recipe.optional_params.FormFactor
import me.s097t0r1.geminio_kotlin_dsl.recipe.optional_params.Screens
import me.s097t0r1.geminio_kotlin_dsl.recipe.yaml.toYaml
import org.junit.Test
import java.io.File
import java.io.FileWriter


internal class RecipeBuildersKtTest {

    @Test
    fun createRecipe() {
        val standardRecipe = createRecipe {
            requiredParams(
                name = "KtCast API Module",
                description = "Create API Module"
            )
            optionalParams {
                revision(1)
                category(Category.FRAGMENT)
                formFactor(FormFactor.MOBILE)
                constraints(Constraints.KOTLIN)
                screens(Screens.NEW_MODULE)
                minApi(24)
                minBuildApi(32)
            }
            widgets {
               booleanParameter(
                   id = "includeStarter",
                   name = "Include starter for feature"
               ) {
                   help("Generate starter interface")
                   default(false)
               }
            }
            recipe {
                mkdirs {
                   mkDir("${Constants.srcOut}/api")
                }
                instantiateAndOpen(
                    from = "root/src/main/java/package/FeatureApi.kt.ftl",
                    to = "${Constants.srcOut}/api/${Constants["__formattedModuleName"]}FeatureAPI.kt"
                )
                instantiate(
                    from = "root/src/main/java/package/FeatureDependencies.kt.ftl",
                    to = "${Constants.srcOut}/api/${Constants["__formattedModuleName"]}FeatureDependencies.kt"
                )
                instantiate(
                    from = "root/build.gradle.ftl",
                    to = "${Constants["rootOut"]}/build.gradle"
                )
                instantiate(
                    from = "root/.gitignore.ftl",
                    to = "${Constants["rootOut"]}/.gitignore"
                )
                instantiate(
                    from = "root/src/main/AndroidManifest.xml.ftl",
                    to = "${Constants["rootOut"]}/src/main/AndroidManifest.xml"
                )
                predicate(
                    validIf = "${Constants["includeStarter"]}",
                    commands = {
                        instantiate(
                            from = "root/src/main/java/package/FeatureStarter.kt.ftl",
                            to = "${Constants.srcOut}/api/${Constants["__formattedModuleName"]}FeatureStarter.kt"
                        )
                    },
                    elseCommands = {}
                )
            }
        }.unwrap().toYaml().lines()

        val expectedContent = File(
            "src/test/kotlin/me/s097t0r1/geminio_kotlin_dsl/recipe/recipeBuildersKtTestExpected.yaml"
        ).readLines()

        assert(standardRecipe.size == expectedContent.size)

        for (i in standardRecipe.indices) {
            assert(standardRecipe[i].trim() == expectedContent[i].trim())
        }
    }
}