import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    val kotlinVersion = "1.9.0"

    kotlin("multiplatform") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("maven-publish")
    id("io.github.gradle-nexus.publish-plugin") version "1.3.0"
    signing
    id("dev.petuska.npm.publish") version "3.4.0"

    id("org.jetbrains.dokka") version "1.8.20"

    id("org.jetbrains.kotlinx.kover") version "0.7.2"
    id("org.sonarqube") version "4.3.0.3225"
}

group = "cloud.drakon"
version = "3.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val jvmToolchain = 11

kotlin {
    jvm {
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }

    jvmToolchain(jvmToolchain)

    js(IR) {
        nodejs()
        binaries.library()

        generateTypeScriptDefinitions()
    }

    sourceSets {
        val ktorVersion = "2.3.2"

        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")

                implementation("io.ktor:ktor-client-core:$ktorVersion")
                implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-java:$ktorVersion")
            }
        }
        val jvmTest by getting
        val jsMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-js:$ktorVersion")
            }
        }
        val jsTest by getting
    }

    publishing {
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/drakon64/KtUniversalis")
                credentials {
                    username = System.getenv("GITHUB_ACTOR")
                    password = System.getenv("GITHUB_TOKEN")
                }
            }
        }
    }
}

nexusPublishing {
    repositories {
        sonatype {
            nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
            snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))

            username.set(System.getenv("SONATYPE_USERNAME"))
            password.set(System.getenv("SONATYPE_PASSWORD"))
        }
    }
}

tasks.withType<DokkaTask>().configureEach {
    dokkaSourceSets {
        configureEach {
            jdkVersion.set(jvmToolchain)
            languageVersion.set("1.9")
        }
    }
}

val htmlJar: TaskProvider<Jar> by tasks.registering(Jar::class) {
    dependsOn(tasks.dokkaHtml)
    archiveClassifier.set("html-docs")
    from(tasks.dokkaHtml.flatMap { it.outputDirectory })
}

val javadocJar: TaskProvider<Jar> by tasks.registering(Jar::class) {
    dependsOn(tasks.dokkaJavadoc)
    archiveClassifier.set("javadoc")
    from(tasks.dokkaJavadoc.flatMap { it.outputDirectory })
}

publishing {
    publications.withType<MavenPublication> {
        artifact(javadocJar.get())
        artifact(htmlJar.get())

        pom {
            name.set("KtUniversalis")
            description.set("Kotlin Multiplatform library for Universalis")
            url.set("https://github.com/drakon64/KtUniversalis")

            licenses {
                license {
                    name.set("MIT")
                    url.set("https://opensource.org/licenses/MIT")
                }
            }
            developers {
                developer {
                    id.set("drakon64")
                    name.set("Adam Chance")
                    email.set("adam.chance10@live.co.uk")
                }
            }
            scm {
                url.set("https://github.com/drakon64/KtUniversalis")
            }
        }
    }
}

signing {
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKey, signingPassword)
    sign(publishing.publications)
}

npmPublish {
    packages {
        named("js") {
            packageJson {
                "bugs" by "https://github.com/drakon64/KtUniversalis/issues"
                "homepage" by "https://github.com/drakon64/KtUniversalis"
                "keywords" by arrayOf("universalis", "ffxiv")
                "license" by "MIT"
                "main" by "ktuniversalis.js"
                "name" by "ktuniversalis"
                "repository" by "github:drakon64/KtUniversalis"
            }
            packageJsonTemplateFile.set(projectDir.resolve("build/js/packages/ktuniversalis/package.json"))
        }
    }
    readme.set(rootDir.resolve("README.md"))
    registries {
        npmjs {
            authToken.set(System.getenv("NPM_ACCESS_TOKEN"))
        }
    }
}

kover {
    useJacoco()
}

sonarqube {
    properties {
        property("sonar.projectKey", "KtUniversalis")
        property("sonar.organization", "drakon64")
        property("sonar.host.url", "https://sonarcloud.io")
        property(
            "sonar.coverage.jacoco.xmlReportPaths", "build/reports/kover/xml/report.xml"
        )
    }
}
