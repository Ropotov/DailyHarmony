package org.ropotov.dailyharmony.startup

import android.content.Context
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import org.koin.core.scope.Scope

actual class ContextWrapper constructor(val context: Context)

@Module
actual class ContextWrapperModule {
    @Single
    actual fun providesContextWrapper(scope: Scope): ContextWrapper = ContextWrapper(scope.get())
}