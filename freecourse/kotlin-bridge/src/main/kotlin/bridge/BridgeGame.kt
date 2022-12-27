package bridge

import controller.Controller
import view.InputView

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
class BridgeGame {
    var flag = true
    var checkGame = false
    private val inputView = InputView()
    private val bridgeNumberGenerator = BridgeRandomNumberGenerator()
    private val makeMap = MakeMap()
    private lateinit var bridgeList : MutableList<String>
    private var index : Int = 0


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     *
     *
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    fun makeBridge(size : Int){
        bridgeList = BridgeMaker(bridgeNumberGenerator).makeBridge(size)
    }

    fun move() : Pair<String, String>{
        val upDown = inputView.readMoving() // Controller로 이동
        return when (canMoveBridge(upDown)){
            true -> {
                makeMap.makeSuccessMap(upDown)
                checkGameFinish()
                makeMap.getMap()
            }

            false -> {
                makeMap.makeFailMap(upDown)
                flag = false
                makeMap.getMap()
            }
        }
    }

    fun canMoveBridge(upDown : String) : Boolean{
        return if (upDown == bridgeList[index]){
            index++
            true
        } else false
    }

    fun checkGameFinish(){
        if (index == bridgeList.size){
            checkGame = true
        }
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     *
     *
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun retry() {
        index = 0
        makeMap.clearMap()
    }
}
