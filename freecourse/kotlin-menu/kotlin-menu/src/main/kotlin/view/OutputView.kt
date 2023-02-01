package view

import constant.*
import model.RecommendCategory


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

    fun menuResultMessage(category : String, menuList : MutableList<String>){
        println(MENU_RESULT)
        println(MENU_DAY)
        println(category)
        for (menu in menuList){
            println(menu)
        }
    }

    fun finishMessage(){
        println()
        println(FINISH)
    }
}