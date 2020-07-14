package com.example.preferencesapp

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_settings.*
import yuku.ambilwarna.AmbilWarnaDialog
import yuku.ambilwarna.AmbilWarnaDialog.OnAmbilWarnaListener


class SettingsActivity : AppCompatActivity() {

    var DefaultColor = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sp = getSharedPreferences("MyPref", Activity.MODE_PRIVATE)
        val editor = sp.edit()
        setContentView(R.layout.activity_settings)

        window.decorView.setBackgroundColor(sp.getInt("background_color",DefaultColor))

        btnChangeColor.setOnClickListener{
            colorPicker(editor)

        }

        btnReturn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }


    fun colorPicker(editor : SharedPreferences.Editor) {
        val dialog =
            AmbilWarnaDialog(this, DefaultColor, object : OnAmbilWarnaListener {
                override fun onCancel(dialog: AmbilWarnaDialog) {}


                override fun onOk(dialog: AmbilWarnaDialog, color: Int) {
                    DefaultColor = color
                    Toast.makeText(baseContext, "Selected Color : $color", Toast.LENGTH_LONG)
                        .show()

                    editor.putInt("background_color",DefaultColor)
                    editor.commit()
                    val intent = intent
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    finish()
                    startActivity(intent)
                }
            })
        dialog.show()
    }


}
