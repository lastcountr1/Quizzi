package com.example.quizzi

data class QuestionsData(
    val id: Int,
    val image: Int,
    val question: String,
    val option1: String,
    val option2: String,
    val option3: String,
    val option4: String,
    val correctAnswer: Int,

    )
