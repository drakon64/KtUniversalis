import kotlinx.kover.api.DefaultJacocoEngine

plugins {
    kotlin("multiplatform") version "1.8.0"
    kotlin("plugin.serialization") version "1.8.0"
    id("maven-publish")
    id("dev.petuska.npm.publish") version "3.2.0"
    id("org.jetbrains.dokka") version "1.7.20"

    id("org.jetbrains.kotlinx.kover") version "0.6.1"
    id("org.sonarqube") version "3.5.0.2730"
}

group = "cloud.drakon"
version = "0.0.1"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }

    jvmToolchain(11)

    js(IR) {
        nodejs()
        useCommonJs()
        binaries.library()
    }

    sourceSets {
        val ktorVersion = "2.2.2"

        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")

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

npmPublish {
    packages {
        named("js") {
            packageJson {
                "bugs" by "https://github.com/drakon64/KtUniversalis/issues"
                "homepage" by "https://github.com/drakon64/KtUniversalis"
                "license" by "AGPL - 3.0 - only"
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

tasks.dokkaJekyll.configure {
    outputDirectory.set(buildDir.resolve("dokka"))

    dokkaSourceSets {
        configureEach {
            jdkVersion.set(11)
        }
    }
}

kover {
    engine.set(DefaultJacocoEngine)

    xmlReport {
        onCheck.set(true)
    }

    htmlReport {
        onCheck.set(false)
    }
}

sonarqube {
    properties {
        property("sonar.projectKey", "KtUniversalis")
        property("sonar.organization", "drakon64")
        property("sonar.host.url", "https://sonarcloud.io")
        property(
            "sonar.coverage.jacoco.xmlReportPaths",
            "${project.buildDir}/reports/kover/xml/report.xml"
        )
    }
}
