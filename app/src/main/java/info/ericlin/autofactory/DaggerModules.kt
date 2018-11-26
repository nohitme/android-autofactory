package info.ericlin.autofactory

import android.app.Activity
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import kotlin.random.Random
import kotlin.reflect.KClass

@MapKey
annotation class ActivityClassKey(val value: KClass<out Activity>)

@Module
object RandomModule {

    @Provides
    @JvmStatic
    fun random(): Random = Random(123)
}

@Module
interface ActivityFactoryModule {

    @Binds
    @IntoMap
    @ActivityClassKey(MainActivity::class)
    fun mainActivityFactory(factory: MainActivityFactory): ActivityFactory
}

