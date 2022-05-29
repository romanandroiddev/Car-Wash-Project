package uz.project.mycarwashproject

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.Koin
import org.koin.core.context.startKoin
import timber.log.Timber
import uz.project.mycarwashproject.di.helperModule
import uz.project.mycarwashproject.di.networkModule
import uz.project.mycarwashproject.di.repositoryModule
import uz.project.mycarwashproject.di.viewModelModule

class App : Application() {

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        val modules = listOf(
            networkModule, viewModelModule, helperModule, repositoryModule
        )
        startKoin {
            androidLogger()
            androidContext(this@App)
            androidFileProperties()
            koin.loadModules(modules)
        }

    }
}