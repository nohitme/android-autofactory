package info.ericlin.autofactory

import android.app.Activity
import android.app.Application
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Inject

class AutoApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        appComponent.inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }
}

@Component(modules = [AndroidSupportInjectionModule::class, ActivityFactoryModule::class, RandomModule::class])
interface AppComponent {

    fun inject(autoApplication: AutoApplication)

    fun activityFactories(): Map<Class<out Activity>, ActivityFactory>
}

