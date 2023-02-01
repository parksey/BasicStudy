package controller

import model.FoodData
import model.MenuData
import model.RecommendCategory
import model.RecommendMenu
import view.InputView
import view.OutputView

class Controller(private val inputView : InputView, private val outputView: OutputView) {
    private val menuData = MenuData()
    fun start(){
        outputView.startMessage()
        outputView.coachNameMessage()
        RecommendCategory.pickCategory()
        coachName()
        showResult()
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
        menuData.addData(recommendMenu.getRecommendMenu())
    }

    fun showResult(){
        outputView.menuResultMessage(RecommendCategory.getCategory(), menuData.getData())
        outputView.finishMessage()
    }
}