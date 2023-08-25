package com.example.subject8

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ConfirmActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm)

        // ツールバーをアクションバーとしてセット
        val Toolbar: Toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(Toolbar)
        // タイトルを設定
        supportActionBar!!.setTitle("Exercise11_Preference")

        findViewById<Button>(R.id.edit_button).setOnClickListener {
            val intent = Intent(this@ConfirmActivity,EditActivity::class.java )
            startActivity(intent)
        }

        loadFromPreference()
    }
    /**
     * プリファレンスからの値のロード
     */
    private fun loadFromPreference() {
        //DefaultPreferenceの取得
        val defaultPreference = PreferenceManager.getDefaultSharedPreferences(applicationContext)

        //名前の読み込み
        var name = defaultPreference.getString("name", "名前")
        findViewById<TextView>(R.id.name_result).text = name

        //性別の読み込み
        var sex = defaultPreference.getString("sex", "未選択")
        findViewById<TextView>(R.id.sex_result).text = sex

        // メールアドレスの読み込み
        var mailAddress = defaultPreference.getString("mailAddress", "sample@gmail.com")
        findViewById<TextView>(R.id.mail_result).text = mailAddress

        // メルマガの読み込み
        var mailMagazine = defaultPreference.getString("mailMagazine", "受け取らない")
        findViewById<TextView>(R.id.mailMagazine_result).text = mailMagazine
    }
}