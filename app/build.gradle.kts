plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.0"
    id("kotlin-kapt")
}

android {
    namespace = "br.edu.ifal.aluno.arestro"
    compileSdk = 36

    defaultConfig {
        applicationId = "br.edu.ifal.aluno.arestro"
        minSdk = 24
        targetSdk = 36
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation("androidx.room:room-runtime:2.6.1")

// Coroutines support for Room
    implementation("androidx.room:room-ktx:2.6.1")

    // Jetpack Compose
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.compose.ui:ui:1.6.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.0")
    implementation("androidx.compose.material3:material3:1.2.1")

    // Navegação entre telas
    implementation("androidx.navigation:navigation-compose:2.7.7")

    // Coil (carregar imagens de URL)
    implementation("io.coil-kt:coil-compose:2.5.0")

    // Preview e debug
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.0")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.6.0")

    //Retrofit (para chamadas HTTP)
    implementation("com.squareup.retrofit2:retrofit:2.11.0")

    //Conversor JSON (usa Gson para converter objetos automaticamente)
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    //OkHttp (cliente HTTP usado pelo Retrofit)
    implementation("com.squareup.okhttp3:okhttp:4.12.0")

    implementation("androidx.compose.material:material-icons-extended")

    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}