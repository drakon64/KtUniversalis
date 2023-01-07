plugins {
    kotlin("multiplatform") version "1.8.0"
    id("maven-publish")
    id("dev.petuska.npm.publish") version "3.2.0"
}

group = "cloud.drakon"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }

    js(IR) {
        nodejs()
        useCommonJs()
        binaries.library()
    }

    sourceSets {
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
        val jsMain by getting
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
                "name" by "ktdiscord"
                "repository" by "github:drakon64/KtUniversalis"
            }
            packageJsonTemplateFile.set(projectDir.resolve("build/js/packages/ktuniversalis/package.json"))
        }
    }
    readme.set(rootDir.resolve("README.md"))
    registries {
        github {
            authToken.set(System.getenv("GITHUB_TOKEN"))
        }

//        npmjs {
//            authToken.set(System.getenv("NPM_ACCESS_TOKEN"))
//        }

    }
}
