package org.ropotov.dailyharmony

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform