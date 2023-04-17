package com.example.quizzi

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizzi.Result

class Questions : AppCompatActivity(), View.OnClickListener {

    private var mQuestionList: ArrayList<QuestionsData> ?= null
    private var mCurrentPosition: Int = 1
    private var mSelectedOption: Int = 0
    private var mUserName: String ?= null
    private var WrongAnser: Int = 0



    private var progressBar:ProgressBar ?= null
    private var tvQuestion:TextView ?= null
    private var tvImage:ImageView ?= null
    private var tvProgrss:TextView ?= null
    private var tvOption1:TextView ?= null
    private var tvOption2:TextView ?= null
    private var tvOption3:TextView ?= null
    private var tvOption4:TextView ?= null
    private var subBtn: Button ?=  null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        tvQuestion = findViewById(R.id.tv_question)
        progressBar = findViewById(R.id.progress_bar)
        tvProgrss = findViewById(R.id.tv_progress)
        tvImage = findViewById(R.id.tv_image)
        tvOption1 = findViewById(R.id.tv_option1)
        tvOption2 = findViewById(R.id.tv_option2)
        tvOption3 = findViewById(R.id.tv_option3)
        tvOption4 = findViewById(R.id.tv_option4)
        subBtn = findViewById(R.id.btn_submit)

        mQuestionList = Constants.getQuestion()
        SetQuestion()

        tvOption1?.setOnClickListener(this)
        tvOption2?.setOnClickListener(this)
        tvOption3?.setOnClickListener(this)
        tvOption4?.setOnClickListener(this)
        subBtn?.setOnClickListener(this)

    }

    private fun SetQuestion() {


        defaultOptionView()
        val question: QuestionsData = mQuestionList!![mCurrentPosition - 1]


        if (mCurrentPosition == mQuestionList!!.size) {
            subBtn?.text = "FINISH"
        } else {
            subBtn?.text = "SUBMIT"
        }

        tvQuestion?.text = question.question
        tvImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgrss?.text = "${mCurrentPosition}/${progressBar?.max}"
        tvOption1?.text = question.option1
        tvOption2?.text = question.option2
        tvOption3?.text = question.option3
        tvOption4?.text = question.option4



    }



    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        tvOption1?.let {
            options.add(0, it)
        }
        tvOption2?.let {
            options.add(1, it)
        }
        tvOption3?.let {
            options.add(2, it)
        }
        tvOption4?.let {
            options.add(3, it)
        }

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.default_option_border_bg
            )

        }

    }


    private fun selectedOption(tv: TextView, selectedOptionNum: Int){
        defaultOptionView()
        mSelectedOption = selectedOptionNum
        tv.setTextColor(Color.parseColor("#6911cf"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option_border_bg
        )


    }





    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_option1 -> {
                tvOption1?.let{
                    selectedOption(it, 1)
                }
            }
            R.id.tv_option2 -> {
                tvOption2?.let{
                    selectedOption(it, 2)
                }
            }
            R.id.tv_option3 -> {
                tvOption3?.let{
                    selectedOption(it, 3)
                }
            }
            R.id.tv_option4 -> {
                tvOption4?.let{
                    selectedOption(it, 4)
                }
            }

            R.id.btn_submit ->{
                if(mSelectedOption == 0){
                    mCurrentPosition ++

                    when{
                        mCurrentPosition <= mQuestionList!!.size ->{
                            SetQuestion()
                        }
                        else -> {
                            val intent = Intent(this, Result::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWER, WrongAnser)
                            intent.putExtra(Constants.TOTAL_QUESTION, mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if (question!!.correctAnswer != mSelectedOption){
                        answerView(mSelectedOption, R.drawable.wrong_option_border_bg)
                        WrongAnser ++
                    }
                    answerView(question.correctAnswer, R.drawable.right_option_border_bg)

                    if (mCurrentPosition == mQuestionList!!.size){
                        subBtn?.text = "Finish"
                    }else{
                        subBtn?.text = "Go to next Question"

                    }

                    mSelectedOption = 0


                }




            }

        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 ->{
                tvOption1?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            2 ->{
                tvOption2?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            3 ->{
                tvOption3?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }

            4 ->{
                tvOption4?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }

    }


}