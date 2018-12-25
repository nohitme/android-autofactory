buildscript {
    repositories {
        google()
        jcenter()
    }

    val kotlinVersion = "1.3.11"

    dependencies {
        classpath("com.android.tools.build:gradle:3.4.0-alpha09")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}


allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.create("clean") {
    delete(rootProject.buildDir)
}
