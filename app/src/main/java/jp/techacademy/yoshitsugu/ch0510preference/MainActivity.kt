package jp.techacademy.yoshitsugu.ch0510preference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.preference.PreferenceManager
import jp.techacademy.yoshitsugu.ch0510preference.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preference = PreferenceManager.getDefaultSharedPreferences(this)
        val putButton = findViewById<Button>(R.id.putButton)
        val getButton = findViewById<Button>(R.id.getButton)
        val editText = findViewById<TextView>(R.id.editText)

        putButton.setOnClickListener{
            Log.d("putButton", "onCreate: test")
            val editor = preference.edit()
            editor.putString("TEXT", editText.text.toString())
            editor.commit()
        }
        getButton.setOnClickListener{
            Log.d("getButton", "onCreate: test")
            editText.text = preference.getString("TEXT", "まだ保存されていません")
        }

        /*
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.putButton.setOnClickListener{
            Log.d("putButton", "onCreate: RUN")
            val editor = preference.edit()
            editor.putString("TEXT", binding.editText.text.toString())
            editor.commit()
        }

        binding.getButton.setOnClickListener{
            Log.d("gutButton", "onCreate: RUN")
            binding.editText.setText(preference.getString("TEXT", "まだ保存されていません"))
        }
         */
    }
}
