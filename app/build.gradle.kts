plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "info.ericlin.autofactory"
        minSdkVersion(28)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        javaCompileOptions {
            annotationProcessorOptions {
                includeCompileClasspath = false
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin_version}")
    implementation("androidx.appcompat:appcompat:1.0.2")
    implementation("androidx.core:core-ktx:1.0.1")
    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
    implementation("com.google.android.material:material:1.0.0")
    implementation("com.google.dagger:dagger:${Versions.dagger_version}")
    implementation("com.google.dagger:dagger-android-support:${Versions.dagger_version}")
    implementation("com.google.auto.factory:auto-factory:1.0-beta6")
    kapt("com.google.auto.factory:auto-factory:1.0-beta6")
    kapt("com.google.dagger:dagger-compiler:${Versions.dagger_version}")
    kapt("com.google.dagger:dagger-android-processor:${Versions.dagger_version}")
    testImplementation("junit:junit:4.12")
}

kapt {
    correctErrorTypes = true
}