package view

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */

enum class OutputMessage(val message : String){
    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    INPUT_UP_DOWN("이동할 칸을 선택하세요. (위: U, 아래: D)"),
    GAME_RETRYQUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_FINISH("최종 게임 결과"),
    GAME_RESULT("게임 성공 여부"),
    GAME_SUCCESS("성공"),
    GAME_FAIL("실패"),
    GAME_TRY("총 시도한 횟수: ");

    fun gameSuccessMessage(): String {
        return this.message + ": " + GAME_SUCCESS.message
    }

    fun gameFailMessage() : String {
        return this.message + ": " + GAME_FAIL.message
    }

    fun gameTry(count : Int) : String {
        return this.message + count.toString()
    }

}

class OutputView {

    fun start(){
        println(OutputMessage.GAME_START.message)
    }

    fun showBridgeSizeInput(){
        println(OutputMessage.INPUT_BRIDGE_SIZE.message)
    }

    fun showChooseUpDown(){
        println(OutputMessage.INPUT_UP_DOWN.message)
    }

    fun showChooseRetryQuit(){
        println()
        println(OutputMessage.GAME_RETRYQUIT.message)
    }

    fun showGameFinish(){
        println()
        println(OutputMessage.GAME_FINISH.message)
    }

    fun showGameSuccess(){
        println()
        println(OutputMessage.GAME_RESULT.gameSuccessMessage())
    }

    fun showGameFail(){
        println()
        println(OutputMessage.GAME_RESULT.gameFailMessage())
    }

    fun showGameTry(count : Int){
        println(OutputMessage.GAME_TRY.gameTry(count))
    }




    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printMap(mapPair : Pair<String, String>) {
        println(mapPair.first)
        println(mapPair.second)
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     *
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    fun printResult(mapPair : Pair<String, String>) {
        println(mapPair.first)
        println(mapPair.second)
    }
}
