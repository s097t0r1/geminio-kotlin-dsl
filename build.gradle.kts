plugins {
    kotlin("jvm") version "1.8.0"
}

repositories {
    mavenCentral()
}

dependencies {

    implementation("org.yaml:snakeyaml:1.8")

    testImplementation(kotlin("test"))
}