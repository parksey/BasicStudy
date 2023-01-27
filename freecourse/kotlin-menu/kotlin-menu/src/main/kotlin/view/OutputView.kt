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

    fun noFoodMessage(name : String?){
        println(name + NO_FOOD)
    }

    fun noFoodErrorMessage(e : IllegalArgumentException){
        println(e.message)
    }
}