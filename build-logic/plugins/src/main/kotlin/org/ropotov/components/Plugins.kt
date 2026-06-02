package org.ropotov.components

enum class Plugins(val id: String) {
    ANDROID_APPLICATION("android-application"),
    KMP_LIBRARY("android-kmp-library"),
    COMPOSE_MULTIPLATFORM("compose-multiplatform"),
    COMPOSE_COMPILER("compose-compiler"),
    KOTLIN_MULTIPLATFORM("kotlin-multiplatform"),
    KOTLIN_SERIALIZATION("kotlinx-serialization"),
    KSP("ksp"),
    ROOM("room"),
}