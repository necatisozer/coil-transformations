import coiltransformations.coilVersion
import coiltransformations.minSdk
import coiltransformations.targetSdk

plugins {
    id("com.android.library")
    id("kotlin-android")
}

apply(from = "../publish.gradle")

android {
    namespace = "com.commit451.coiltransformations.gpu"
    compileSdk = project.targetSdk
    defaultConfig {
        minSdk = project.minSdk
        targetSdk = project.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    libraryVariants.all {
        generateBuildConfigProvider?.configure { enabled = false }
    }
}

dependencies {
    api("io.coil-kt:coil-base:${project.coilVersion}")
    api("jp.co.cyberagent.android:gpuimage:2.1.0")
}
