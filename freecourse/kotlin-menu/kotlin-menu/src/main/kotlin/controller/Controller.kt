package controller

import model.FoodData
import model.RecommendCategory
import model.RecommendMenu
import view.InputView
import view.OutputView

class Controller(private val inputView : InputView, private val outputView: OutputView) {

    fun start(){
        outputView.startMessage()
        outputView.coachNameMessage()
        RecommendCategory.pickCategory()
        coachName()
    }

    fun coachName(){
        while (true){
            try{
                val coachList = inputView.readName()
                noFood(coachList)
                break
            }catch (e : IllegalArgumentException){
                outputView.inputErrorMessage(e)
            }
        }
    }

    fun noFood(coachList : List<String?>){
        for (name in coachList){
            outputView.noFoodMessage(name)
            while (true){
                try{
                    val noFoodList = inputView.readNoFood()
                    recommend(name, noFoodList)
                    break
                } catch(e : IllegalArgumentException){
                    outputView.noFoodErrorMessage(e)
                }
            }
        }
    }

    fun recommend(name : String?, noFoodList : List<String?>){
        val recommendMenu = RecommendMenu(name, noFoodList)
        recommendMenu.pickMenu()
        println(recommendMenu.getCategory())
        println(recommendMenu.getRecommendMenu())
    }
}