package view

import constant.*


class OutputView {
    fun startMessage(){
        println(START)
    }

    fun coachNameMessage(){
        println(COACH_NAME)
    }

    fun inputErrorMessage(e : IllegalArgumentException){
        println(e.message)
    }
}