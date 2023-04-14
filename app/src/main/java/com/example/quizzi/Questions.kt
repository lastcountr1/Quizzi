package com.example.quizzi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class Questions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val listOfQuestion = Constants.getQuestion()
        Log.i("Question List Size IS ", "${listOfQuestion.size}")

    }
}