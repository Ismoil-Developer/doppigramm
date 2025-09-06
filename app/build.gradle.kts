plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("org.jetbrains.kotlin.plugin.parcelize")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "uz.mrx.doppigramm"
    compileSdk = 34

    defaultConfig {
        applicationId = "uz.mrx.doppigramm"
        minSdk = 21
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

    buildFeatures {

        viewBinding = true

    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)



    // ViewBinding Property Delegate
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.6")

    // CircleImageView
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-android-compiler:2.48")

    // ViewModel delegation
    implementation("androidx.activity:activity-ktx:1.9.0")
    implementation("androidx.fragment:fragment-ktx:1.6.2")

    // SDP
    implementation("com.intuit.sdp:sdp-android:1.1.0")

    // Picasso
    implementation("com.squareup.picasso:picasso:2.8")

    // Google Maps & Location
    implementation("com.google.android.gms:play-services-maps:18.0.0")
    implementation("com.google.android.gms:play-services-location:18.0.0")
    implementation("com.google.android.libraries.places:places:3.0.0")

    // Volley
    implementation("com.android.volley:volley:1.2.1")

    // Retrofit
    implementation("com.squareup.retrofit2:converter-scalars:2.1.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")
    implementation("com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:0.9.2")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.15.1")
//    kapt("com.github.bumptech.glide:compiler:4.15.1")

    // Room
    implementation("androidx.room:room-runtime:2.5.0")
//    kapt("androidx.room:room-compiler:2.5.0")
    implementation("androidx.room:room-ktx:2.5.0")

    // Dexter
    implementation("com.karumi:dexter:6.2.3")

    // Dots Indicator
    implementation("com.tbuonomo:dotsindicator:4.3")

    // NavGraph
    implementation("androidx.navigation:navigation-fragment-ktx:2.8.9")
    implementation("androidx.navigation:navigation-ui-ktx:2.8.9")

    // Lingver
    implementation("com.github.YarikSOffice:lingver:1.3.0")

    // ✅ Country Code Picker (CCP)
    implementation("com.hbb20:ccp:2.7.1")
    implementation("com.github.mukeshsolanki:country-picker-android:2.0.1")

    //lottie
    implementation("com.airbnb.android:lottie:6.1.0")





}