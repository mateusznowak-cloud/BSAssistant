plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "pl.bsassistant"
    compileSdk = 35

    defaultConfig {
        applicationId = "pl.bsassistant"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "0.1"
    }
}
