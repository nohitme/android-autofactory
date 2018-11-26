package info.ericlin.autofactory

import android.app.Activity
import android.app.AppComponentFactory
import android.app.Application
import android.content.Intent

@Suppress("unused")
class AutoAppComponentFactory : AppComponentFactory() {

    private lateinit var application: AutoApplication

    override fun instantiateApplication(cl: ClassLoader, className: String): Application {
        application = super.instantiateApplication(cl, className) as AutoApplication
        return application
    }

    override fun instantiateActivity(cl: ClassLoader, className: String, intent: Intent?): Activity {
        val clazz = cl.loadClass(className)
        val activityFactories = application.appComponent.activityFactories()
        val activityFactory = activityFactories[clazz]
        val activity = activityFactory?.create()
        if (activity != null && intent != null) {
            activity.intent = intent
        }

        return activity ?: super.instantiateActivity(cl, className, intent)
    }
}