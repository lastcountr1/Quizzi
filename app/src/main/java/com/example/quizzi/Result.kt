package com.example.quizzi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {

    private var tvUserName: TextView ?= null
    private var score: TextView ?= null
    private var finishButton : Button ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvUserName = findViewById(R.id.user_name)
        tvUserName?.text = intent.getStringExtra(Constants.USER_NAME)




    }
}