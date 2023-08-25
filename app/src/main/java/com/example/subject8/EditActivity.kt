package com.example.subject8

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        // ツールバーをアクションバーとしてセット
        val Toolbar: Toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(Toolbar)
        // タイトルを設定
        supportActionBar!!.setTitle("Exercise11_Preference")


        findViewById<Button>(R.id.decide_button).setOnClickListener {
            saveToPreference()
            val intent = Intent(this@EditActivity,ConfirmActivity::class.java )
            startActivity(intent)
        }
    }
    /**
     * プリファレンスへの値のセーブ
     */
    private fun saveToPreference() {
        //DefaultPreferenceの取得
        val defaultPreference = PreferenceManager.getDefaultSharedPreferences(applicationContext)

        //Editorの取得
        val editor = defaultPreference.edit()

        //名前のセット
        val name = findViewById<EditText>(R.id.name_edit).text
        editor.putString("name", "$name")

        // 性別のセット
        val selectedRadioButtonId = findViewById<RadioGroup>(R.id.radioGroup).checkedRadioButtonId
        val sex = findViewById<RadioButton>(selectedRadioButtonId).text
        editor.putString("sex", "$sex")

        //メールアドレスのセット
        val mailAddress = findViewById<EditText>(R.id.mail_edit).text
        editor.putString("mailAddress", "$mailAddress")

        //メールマガジンのセット
        val checkBox = findViewById<CheckBox>(R.id.checkbox_mailMagazine)
        val mailMagazine =
            if (checkBox.isChecked){
                "受け取る"
            }else{
                "受け取らない"
            }
        editor.putString("mailMagazine", "$mailMagazine")

        editor.apply()
    }
}