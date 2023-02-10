plugins {
    kotlin("jvm") version "1.8.10"
}

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.yaml:snakeyaml:1.8")

    testImplementation(kotlin("test"))
}