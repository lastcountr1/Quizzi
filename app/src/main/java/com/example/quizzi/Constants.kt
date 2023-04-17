package com.example.quizzi

object Constants {

    const val USER_NAME : String = "user_name"
    const val CORRECT_ANSWER: String = "correct_answer"
    const val TOTAL_QUESTION: String = "total_question"
    fun getQuestion(): ArrayList<QuestionsData>{
        val questionList = ArrayList<QuestionsData>()

        val ques1 = QuestionsData(
            1, R.drawable.ic_flag_of_india,
            "What country does this flag belong to ?",
            "India", "Australia", "Japan", "USA",
            1
        )

        questionList.add(ques1)

        val ques2 = QuestionsData(
            2, R.drawable.ic_flag_of_argentina,
            "What country does this flag belong to ?",
            "Argentina", "Australia", "Japan", "USA",
            1
        )

        questionList.add(ques2)

        val ques3 = QuestionsData(
            3, R.drawable.ic_flag_of_australia,
            "What country does this flag belong to ?",
            "Argentina", "Australia", "New Zealand", "USA",
            2
        )

        questionList.add(ques3)

        val ques4 = QuestionsData(
            4, R.drawable.ic_flag_of_belgium,
            "What country does this flag belong to ?",
            "Argentina", "Australia", "New Zealand", "Belgium",
            4
        )

        questionList.add(ques4)


        val ques5 = QuestionsData(
            5, R.drawable.ic_flag_of_brazil,
            "What country does this flag belong to ?",
            "Argentina", "Brazil", "New Zealand", "Kenya",
            2
        )

        questionList.add(ques5)

        val ques6 = QuestionsData(
            6, R.drawable.ic_flag_of_denmark,
            "What country does this flag belong to ?",
            "Denmark", "Brazil", "Australia", "Kenya",
            1
        )

        questionList.add(ques6)


        val ques7 = QuestionsData(
            7, R.drawable.ic_flag_of_fiji,
            "What country does this flag belong to ?",
            "India", "Fiji", "Australia", "South Africa",
            2
        )

        questionList.add(ques7)


        val ques8 = QuestionsData(
            5, R.drawable.ic_flag_of_germany,
            "What country does this flag belong to ?",
            "Argentina", "Brazil", "Germany", "India",
            3
        )

        questionList.add(ques8)

        val ques9 = QuestionsData(
            5, R.drawable.ic_flag_of_kuwait,
            "What country does this flag belong to ?",
            "Japan", "USA", "Kuwait", "UAE",
            3
        )

        questionList.add(ques9)

        val ques10 = QuestionsData(
            5, R.drawable.ic_flag_of_new_zealand,
            "What country does this flag belong to ?",
            "Russia", "New Zealand", "Australia", "China",
            2
        )

        questionList.add(ques10)

        return questionList

    }

}