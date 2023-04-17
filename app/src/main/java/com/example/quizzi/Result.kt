package com.example.quizzi

import android.content.Intent
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

        finishButton = findViewById(R.id.finish_btn)
        tvUserName = findViewById(R.id.user_name)
        tvUserName?.text = intent.getStringExtra(Constants.USER_NAME)

        val totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTION, 0)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWER, 0)

        score = findViewById(R.id.tv_score)
        score?.text = "Your score is ${totalQuestion - correctAnswer} out of $totalQuestion"

        finishButton?.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }




    }
}