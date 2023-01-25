package controller

import view.InputView
import view.OutputView

class Controller(private val inputView : InputView, private val outputView: OutputView) {

    fun start(){
        outputView.startMessage()
        outputView.coachNameMessage()
        coachName()
    }

    fun coachName(){
        while (true){
            try{
                val coachList = inputView.readName()
                break
            }catch (e : IllegalArgumentException){
                outputView.inputErrorMessage(e)
            }
        }
        noFood()
    }

    fun noFood(){

    }

}