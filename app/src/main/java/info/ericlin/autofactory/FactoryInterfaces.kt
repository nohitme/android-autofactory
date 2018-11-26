package info.ericlin.autofactory

import android.app.Activity

interface ActivityFactory {

    fun create(): Activity
}