package com.mealsonwheels.ui.auth


import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.mealsonwheels.MapsActivity
import com.mealsonwheels.R
import com.mealsonwheels.ui.DashboardActivity
import kotlinx.android.synthetic.main.activity_welcome.*
import java.util.*

class Welcome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadLocale()
        setContentView(R.layout.activity_welcome)

        val actionBar : androidx.appcompat.app.ActionBar? = supportActionBar
        actionBar?.setTitle(resources.getString(R.string.app_name))

        val button : Button = findViewById(R.id.button)
        button.setOnClickListener{
            showchangelanguage()
        }
        buttonNext.setOnClickListener {
           val intent = Intent(this,MapsActivity::class.java)
            startActivity(intent)
        }

    }

    private fun showchangelanguage(){

        val languages = arrayOf<String>("English","हिन्दी")

        val builder = AlertDialog.Builder(this@Welcome)
        builder.setTitle("Choose Language")
        builder.setSingleChoiceItems(languages,-1) { dialogInterface: DialogInterface?, i: Int ->
            if(i==0) {
                setLocale("en")
                recreate()
            }
            else if(i==1) {
                setLocale("hi")
                recreate()
            }
            dialogInterface?.dismiss()
        }
        val mDialog = builder.create()
        //builder.create()
        mDialog.show()
    }

    private fun setLocale(lang: String) {
        val locale : Locale = Locale(lang)
        Locale.setDefault(locale)
        val config: Configuration = Configuration()
        config.locale = locale
        baseContext.resources.updateConfiguration(config,baseContext.resources.displayMetrics)
        val editor : SharedPreferences.Editor = getSharedPreferences("Settings", Context.MODE_PRIVATE).edit()
        editor.putString("My_Lang",lang)
        editor.apply()

    }
    public fun loadLocale(){
        val prefs :SharedPreferences = getSharedPreferences("Settings", Activity.MODE_PRIVATE)
        val language: String?= prefs.getString("My_Lang","")
        if (language != null) {
            setLocale(language)
        }
    }


}
