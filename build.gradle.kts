plugins {
    kotlin("jvm") version "1.8.10"
    id("maven-publish")
}

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.yaml:snakeyaml:1.8")

    testImplementation(kotlin("test"))
}

afterEvaluate {
    publishing {
        publications {
            register("release", MavenPublication::class) {
                from(components["kotlin"])
                groupId = "me.s097t0r1"
                artifactId = "geminio-kotlin-dsl"
                version = "1.0.0"
            }
        }
    }
}