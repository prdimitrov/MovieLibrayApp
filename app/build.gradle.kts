plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.movielibrayapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.movielibrayapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation (libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.swiperefreshlayout)
    //Glide
    implementation (libs.glide)
    annotationProcessor(libs.compiler)

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}