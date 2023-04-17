package com.example.quizzi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.quizzi.Result

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.start_btn)
        val editName = findViewById<EditText>(R.id.edit_name)

        startBtn.setOnClickListener {



            if(editName.text.isEmpty()){
                Toast.makeText(this, "Please enter yout name", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, Questions::class.java)
                intent.putExtra(Constants.USER_NAME, editName.text.toString())
                startActivity(intent)
                finish()


            }
        }

    }
}