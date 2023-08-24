package com.example.subject8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ツールバーをアクションバーとしてセット
        val Toolbar: Toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(Toolbar)
        // タイトルを設定
        supportActionBar!!.setTitle("Exercise11_Preference")

        val registerButton = findViewById<Button>(R.id.register_button)
        registerButton.setOnClickListener{
            val intent = Intent(this@MainActivity,EditActivity::class.java )
            startActivity(intent)
        }

        val confirmButton = findViewById<Button>(R.id.confirm_button)
        confirmButton.setOnClickListener{
            val intent = Intent(this@MainActivity,ConfirmActivity::class.java )
            startActivity(intent)
        }
    }
}