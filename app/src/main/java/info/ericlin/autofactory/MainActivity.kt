package info.ericlin.autofactory

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.google.auto.factory.AutoFactory
import com.google.auto.factory.Provided
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

@AutoFactory(implementing = [ActivityFactory::class])
class MainActivity(@Provided private val random: Random) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "${random.nextInt()}", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}
