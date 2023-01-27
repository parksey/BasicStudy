package controller

import model.FoodData
import view.InputView
import view.OutputView

class Controller(private val inputView : InputView, private val outputView: OutputView) {

    fun start(){
        outputView.startMessage()
        outputView.coachNameMessage()
//        val test = FoodData.foodMap["일식"] ?: throw IllegalArgumentException("ㅠㅠ")
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
                } catch(e : IllegalArgumentException){
                    outputView.noFoodErrorMessage(e)
                }
            }
        }
    }
}