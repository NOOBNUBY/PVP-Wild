import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("com.github.johnrengelman.shadow") version "8.1.1"
    kotlin("jvm") version "1.9.0"
}

group = property("group")!!
version = property("version")!!

java.toolchain {
    languageVersion.set(JavaLanguageVersion.of(8))
}

repositories {
    mavenCentral()
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
    maven { url = uri("https://maven.enginehub.org/repo/") }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("io.github.monun:kommand:1.2.1")
    implementation("com.sk89q.worldedit:worldedit-bukkit:7.2.15")
    compileOnly("com.destroystokyo.paper:paper-api:1.16.5-R0.1-SNAPSHOT")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    processResources {
        filesMatching("plugin.yml") {
            expand(project.properties)
        }
    }

    create<Jar>("paperJar") {
        archiveBaseName.set(rootProject.name)
        archiveClassifier.set("")

        from(sourceSets["main"].output)
        doLast {
            copy {
                val dir = File("/Users/noobnuby/Documents/minecraft/minecraft-server/1.16.5/plugins")
                from(archiveFile)
                into(if (File(dir, archiveFileName.get()).exists()) dir else dir)
            }
        }
    }
}