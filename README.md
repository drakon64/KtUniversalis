# KtUniversalis

[![Kotlin](https://img.shields.io/badge/kotlin-1.8.0-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![License](https://img.shields.io/github/license/drakon64/KtUniversalis)](https://www.gnu.org/licenses/agpl-3.0.en.html)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=KtUniversalis&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=KtUniversalis)

KtUniversalis is a Kotlin Multiplatform and JavaScript/TypeScript library for the [Universalis](https://universalis.app)
REST API.

## Installation

KtUniversalis is available from Maven Central (for Kotlin) and npm (for JavaScript/TypeScript).

### Kotlin

Add the following to your `build.gradle.kts` file to install KtUniversalis:

```kotlin
dependencies {
    implementation("cloud.drakon:ktuniversalis:1.0.1")
}
```

### JavaScript/TypeScript

### `package.json`

```json
"ktuniversalis": "1.0.1"
```

#### Command line

```commandline
npm install ktuniversalis
```

## Stability

KtUniversalis will follow Semantic Versioning 2.0.0, meaning:

* A MAJOR version denotes incompatible API changes
* A MINOR version denotes adding functionality in a backwards compatible manner
* A PATCH version denotes backwards compatible bug fixes
