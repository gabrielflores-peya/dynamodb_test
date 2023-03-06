import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
//    https://central.sonatype.com/search?q=software.amazon.awssdk%253Adynamodb&namespace=software.amazon.awssdk&page=13
    implementation("software.amazon.awssdk:dynamodb:2.20.17")
    implementation("software.amazon.awssdk:dynamodb-enhanced:2.20.17")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}