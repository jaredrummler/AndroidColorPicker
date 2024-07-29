plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.jaredrummler.android.colorpicker"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
        testOptions.targetSdk  = 34
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        buildConfig = false
    }
}

afterEvaluate {
    publishing{
        publications{
            create<MavenPublication>("release") {
                // Applies the component for the release build variant.
                from(components["release"])
            }
        }
    }
}
//noinspection UseTomlInstead
dependencies {
    api ("androidx.core:core-ktx:1.13.1")
//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.appcompat)
    api ("com.google.android.material:material:1.12.0")

//    implementation(libs.material)
    api("androidx.preference:preference-ktx:1.2.1")
}
