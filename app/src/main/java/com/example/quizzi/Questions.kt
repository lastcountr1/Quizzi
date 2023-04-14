package com.example.quizzi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class Questions : AppCompatActivity() {
    private var progressBar:ProgressBar ?= null
    private var tvQuestion:TextView ?= null
    private var tvImage:ImageView ?= null
    private var tvProgrss:TextView ?= null
    private var tvOption1:TextView ?= null
    private var tvOption2:TextView ?= null
    private var tvOption3:TextView ?= null
    private var tvOption4:TextView ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        val questionList = Constants.getQuestion()
        Log.i("Question List Size IS ", "${questionList.size}")


        for(i in questionList){
            Log.e("question is ", i.question)
        }
        tvQuestion = findViewById(R.id.tv_question)
        progressBar = findViewById(R.id.progress_bar)
        tvProgrss = findViewById(R.id.tv_progress)
        tvImage = findViewById(R.id.tv_image)
        tvOption1 = findViewById(R.id.tv_option1)
        tvOption2 = findViewById(R.id.tv_option2)
        tvOption3 = findViewById(R.id.tv_option3)
        tvOption4 = findViewById(R.id.tv_option4)

        var currentPosition = 1

        val question:QuestionsData = questionList[currentPosition-1]

        tvQuestion?.text = question.question
        tvImage?.setImageResource(question.image)
        progressBar?.progress = currentPosition
        tvProgrss?.text = "${currentPosition}/${progressBar?.max}"
        tvOption1?.text = question.option1
        tvOption2?.text = question.option2
        tvOption3?.text = question.option3
        tvOption4?.text = question.option4





    }
}