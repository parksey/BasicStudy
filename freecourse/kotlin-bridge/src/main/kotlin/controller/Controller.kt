package controller

import bridge.BridgeGame
import view.InputView
import view.OutputView


class Controller {
    var count = 0

    private val inputView = InputView()
    private val outputView = OutputView()
    private val bridgeGame = BridgeGame()

    private var check = true
    private var successFail = true

    fun gameStart(){
        outputView.start()
        outputView.showBridgeSizeInput()
        val bridgeSize = inputView.readBridgeSize()
        bridgeGame.makeBridge(bridgeSize)
        moveBridge()
    }
    fun moveBridge(){
        while (check){
            outputView.showChooseUpDown()
            val mapPair = bridgeGame.move()
            if (bridgeGame.flag){
                outputView.printMap(mapPair)
            }
            else{
                outputView.printMap(mapPair)
                failGame(mapPair)
            }
            if (bridgeGame.checkGame){
                count++
                gameFinish(mapPair)
            }
        }
    }

    fun failGame(mapPair : Pair<String, String>){
        outputView.showChooseRetryQuit()
        when (inputView.readGameCommand()){
            RETRY -> {
                count++
                bridgeGame.retry()
                bridgeGame.flag = true
            }
            QUIT -> {
                check = false
                successFail = false
                gameFinish(mapPair)
            }
        }
    }

    fun gameFinish(mapPair : Pair<String, String>){
        check = false
        outputView.showGameFinish()
        outputView.printResult(mapPair)
        successOrFail()
        outputView.showGameTry(count)
    }

    fun successOrFail(){
        when(successFail){
            true -> outputView.showGameSuccess()
            false -> outputView.showGameFail()
        }
    }

    companion object{
        const val RETRY = "R"
        const val QUIT = "Q"
    }
}