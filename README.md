JetBrains have [silently replaced Kotlin Multiplatform with a framework for developing cross-platform UI apps](https://www.jetbrains.com/kotlin-multiplatform/) and [removed the Kotlin Multiplatform templates from IntelliJ](https://youtrack.jetbrains.com/issue/KTIJ-27727/disappeared-new-kotlin-multiplatform-project-wizard-with-kotlin-plugin1.9.20#focus=Comments-27-8340985.0-0). As a result, I will not be developing a library for a platform that JetBrains can't be bothered to support.

# KtUniversalis

[![Kotlin](https://img.shields.io/badge/kotlin-1.9.10-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![License](https://img.shields.io/github/license/drakon64/KtUniversalis)](https://opensource.org/license/mit/)
[![KDoc](https://javadoc.io/badge2/cloud.drakon/ktuniversalis/7.0.1/KDoc.svg)](https://javadoc.io/doc/cloud.drakon/ktuniversalis/7.0.1)

KtUniversalis is a Kotlin Multiplatform and JavaScript/TypeScript library for the [Universalis](https://universalis.app) REST API.

## Installation

KtUniversalis is available from Maven Central (for Kotlin and the JVM) and npm (for JavaScript/TypeScript).

### Gradle

Add the following to your `build.gradle.kts` file to install KtUniversalis:

```kotlin
dependencies {
    implementation("cloud.drakon:ktuniversalis:7.0.1")
}
```

### JavaScript/TypeScript

#### `package.json`

```json
"ktuniversalis": "7.0.1"
```

#### Command line

```commandline
npm install ktuniversalis
```
